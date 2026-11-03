package com.sarvatra.sim;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sarvatra.sim.base.PrepareParticipant;
import com.sarvatra.sim.npci.xml.pojo.common.resp.Ref;
import com.sarvatra.sim.npci.xml.pojo.common.resp.Resp;
import com.sarvatra.sim.npci.xml.pojo.common.resp.bal.MiniStatement;
import com.sarvatra.sim.npci.xml.pojo.common.resp.bal.PayerOfRespBalEnq;
import com.sarvatra.sim.npci.xml.pojo.common.resp.bio.UidaiData;
import com.sarvatra.sim.npci.xml.pojo.enums.RefType;
import com.sarvatra.sim.npci.xml.pojo.enums.ResultType;
import org.jpos.core.Configuration;
import org.jpos.qrest.Mapper;
import org.jpos.transaction.Context;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.sarvatra.sim.npci.xml.util.SimulatorConstant.*;
import static com.sarvatra.sim.util.ResponseUtil.generateAuthCode;
import static com.sarvatra.sim.util.ResponseUtil.getRandomAmount;
import static com.sarvatra.sim.util.StmtGenerator.generateStmtData;

public final class PrepareResponse extends PrepareParticipant {

    Set<String> UIDAI_DATA_TXN = Set.of(REQ_BIO_AUTH, REQ_OTP);
    Map<String, String> responseMap;
    Map<String, String> tokenMap;

    @Override
    protected void doPrepare(Context ctx) {
        String requestName = ctx.getString(REQUEST_NAME);
        String url = responseMap.get("url") + "/aeps/" + REQUEST_RESPONSE_MAP.get(requestName) + "/2.0/urn:txnid:" + ctx.getString(TXN_ID);
        ctx.put(CLIENT_URL, url);
        ctx.put(DELAY, responseMap.get("delay"));

        if (UIDAI_DATA_TXN.contains(requestName)) {
            ctx.put(UIDAI_DATA, getUidaiData(ctx, requestName));
        }
        putRespTag(ctx);
        if (RESP_BAL_TXN.contains(ctx.getString(TXN_NAME))) {
            putPayerOfRespBal(ctx);
        }
    }

    UidaiData getUidaiData(Context ctx, String requestName) {
        String tokenKey = ctx.getString(ACQUIRER) + "." + ctx.getString(UID);
        String token = tokenMap.get(tokenKey);
        ctx.log("TokenKey= " + tokenKey + "  Token= " + token);
        if (token == null) {
            token = ctx.getString(UID_TOKEN);
        }
        String info = "UID{" + token + ",extra}";
        String error = null;
        if (!REQ_OTP.equals(requestName) && token == null) {
            error = "Token not found for " + tokenKey;
            info = null;
        }
        return UidaiData.builder()
                .info(info)
                .err(error)
                .build();
    }

    void putRespTag(Context ctx) {
        String rc = responseMap.get("rc");
        ResultType resultType = ResultType.FAILURE;
        String errorCode = rc;

        if ("00".equals(rc)) {
            resultType = ResultType.SUCCESS;
            errorCode = null;
        }

        UidaiData uidaiData = ctx.get(UIDAI_DATA);
        if (uidaiData != null && uidaiData.getErr() != null) {
            resultType = ResultType.FAILURE;
            errorCode = "Z2";
        }

        Resp resp = Resp.builder()
                .authCode(generateAuthCode())
                .reqMsgId(ctx.getString(MSG_ID))
                .result(resultType)
                .ref(getListOfRefTag(ctx))
                .errCode(errorCode)
                .build();
        ctx.put(RESP_TAG, resp);
    }

    List<Ref> getListOfRefTag(Context ctx) {
        if (NO_REF_REQUIRED.contains(ctx.getString(TXN_NAME))) return null;
        return List.of(
                Ref.builder()
                        .refType(RefType.PAYER)
                        .orgAmount(ctx.getString(AMOUNT))
                        .balAmt(getRandomAmount())
                        .build(),
                Ref.builder()
                        .refType(RefType.PAYEE)
                        .orgAmount(ctx.getString(AMOUNT))
                        .build()
        );
    }

    void putPayerOfRespBal(Context ctx) {
        PayerOfRespBalEnq payer = PayerOfRespBalEnq.builder()
                .bal(getBal(ctx))
                .miniStatement(getMiniStatement(ctx))
                .build();
        ctx.put(PAYER_OF_RESP_BAL_ENQ_TAG, payer);
    }

    PayerOfRespBalEnq.Bal getBal(Context ctx) {
        PayerOfRespBalEnq.Bal bal = null;
        if (BAL_ENQ.equals(ctx.getString(TXN_NAME))) {
            bal = PayerOfRespBalEnq.Bal.of(getRandomAmount());
        }
        return bal;
    }

    MiniStatement getMiniStatement(Context ctx) {
        MiniStatement statement = null;
        int count = 10;
        if (MINI_STAT.equals(ctx.getString(TXN_NAME))) {
            statement = MiniStatement.builder()
                    .beneMas("XXX")
                    .stmtLineCount(String.valueOf(count))
                    .stmtDatas(generateStmtData(count))
                    .build();
        }
        return statement;
    }


    @Override
    public void setConfiguration(Configuration cfg) {
        super.setConfiguration(cfg);
        try {
            String responseFile = Files.readString(Path.of("./cfg/response.json"));
            responseMap = Mapper.getMapperNoNulls().readValue(responseFile,
                    new TypeReference<HashMap<String, String>>() {
                    });
            String tokenFile = Files.readString(Path.of("./cfg/tokens.json"));
            tokenMap = Mapper.getMapperNoNulls().readValue(tokenFile,
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
