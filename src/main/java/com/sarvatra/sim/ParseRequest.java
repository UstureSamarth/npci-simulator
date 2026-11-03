package com.sarvatra.sim;

import com.sarvatra.sim.base.PrepareParticipant;
import com.sarvatra.sim.exception.SimulatorException;
import com.sarvatra.sim.npci.xml.pojo.Head;
import com.sarvatra.sim.npci.xml.pojo.Payer;
import com.sarvatra.sim.npci.xml.pojo.Txn;
import com.sarvatra.sim.npci.xml.pojo.common.Amount;
import com.sarvatra.sim.npci.xml.pojo.enums.AccountDetailNameType;
import com.sarvatra.sim.npci.xml.pojo.enums.TxnPurpose;
import com.sarvatra.sim.npci.xml.pojo.enums.TxnType;
import com.sarvatra.sim.npci.xml.util.NPCIXmlUtil;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.CharsetUtil;
import org.jpos.qrest.Constants;
import org.jpos.transaction.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static com.sarvatra.sim.npci.xml.util.SimulatorConstant.*;
import static com.sarvatra.sim.util.AssertionUtil.notBlank;
import static com.sarvatra.sim.util.ResponseUtil.generate12DigitNumber;
import static com.sarvatra.sim.util.ResponseUtil.putRequired;
import static org.jpos.qrest.Constants.PATHPARAMS;

public final class ParseRequest extends PrepareParticipant {

    @Override
    protected void doPrepare(Context ctx) throws Exception {
        FullHttpRequest fullHttpRequest = ctx.get(Constants.REQUEST);
        String xmlPayload = fullHttpRequest.content().toString(CharsetUtil.UTF_8);
        logRequest(ctx, xmlPayload);
        Map<String, String> pathParams = ctx.get(PATHPARAMS);
        String messageName = pathParams.get("reqName");
        ctx.put(REQUEST_NAME, messageName);
        Object npciMessage = NPCIXmlUtil.unmarshal(xmlPayload, REQUEST_MAP.get(messageName));
        ctx.put(CLIENT_REQUEST, npciMessage);
        Head head = extractHead(npciMessage);
        parseHead(head, ctx);
        ctx.put(REQUEST_HEAD_TAG, head);
        Txn txn = extractTxn(npciMessage);
        parseTxn(txn, ctx);
        Payer payer = extractPayer(npciMessage);
        parsePayer(payer, ctx);
        putTxnName(ctx);
        if (BAV.equals(ctx.getString(TXN_NAME))) {
            txn.setDepositId(generate12DigitNumber());
        }
        ctx.put(REQUEST_TXN_TAG, txn);
    }

    void parseHead(Head head, Context ctx) throws SimulatorException {
        putRequired(ctx, MSG_ID, head.getMsgId());
        putRequired(ctx, ACQUIRER, head.getOrgId());
    }

    void parseTxn(Txn txn, Context ctx) throws SimulatorException {
        putRequired(ctx, TXN_ID, txn.getId());
        putRequired(ctx, STAN, txn.getRefId());
        putRequired(ctx, RRN, txn.getCustRef());
        putRequired(ctx, TXN_TYPE, txn.getType());
        ctx.put(PURPOSE_CODE, txn.getPurpose());
        if (REQ_CHK_TXN.equals(ctx.getString(REQUEST_NAME))) {
            putRequired(ctx, DEPOSIT_ID, txn.getDepositId());
        }
    }

    void putTxnName(Context ctx) throws SimulatorException {
        String request = ctx.getString(REQUEST_NAME);
        TxnPurpose purpose = ctx.get(PURPOSE_CODE);
        TxnType type = ctx.get(TXN_TYPE);
        String name = resolveTxnName(request, purpose, type);
        notBlank(name, "Unable to resolve TXN_NAME for request=" + request + ", purpose=" + purpose);
        ctx.put(TXN_NAME, name);
    }

    String resolveTxnName(String request, TxnPurpose purpose, TxnType type) {
        if (REQ_BIO_AUTH.equals(request)) {
            return BIO_AUTH;
        }

        if (REQ_OTP.equals(request)) {
            return GEN_OTP;
        }

        if (REQ_PAY.equals(request)) {
            return switch (purpose) {
                case P22 -> CW;
                case P23 -> BAV;
                case P24 -> FT;
                default -> null;
            };
        }

//        if (REQ_CHK_TXN.equals(request) && TxnPurpose.P23 == purpose) {
//            return CDA;
//        }

        if (REQ_CHK_TXN.equals(request)) {
            return CDA;
        }

        if (REQ_BAL_ENQ.equals(request)) {
            return switch (type) {
                case TxnType.BAL_ENQ -> BAL_ENQ;
                case TxnType.MINI_STMT -> MINI_STAT;
                default -> null;
            };
        }
        return null;
    }

    void parsePayer(Payer payer, Context ctx) throws SimulatorException {
        var details = payer.getAc().getDetails();
        if (details == null || details.isEmpty()) {
            throw new SimulatorException("Payer details are missing");
        }
        for (var detail : details) {
            String key = getKey(detail.getName());
            String value = detail.getValue();
            putRequired(ctx, key, value);
        }
        Amount amount = payer.getAmount();
        if (amount != null && amount.getValue() != null) {
            ctx.put(AMOUNT, amount.getValue().toPlainString());
        }
    }

    Head extractHead(Object npciMessage) {
        if (npciMessage == null) return null;
        try {
            Method getHeadMethod = npciMessage.getClass().getMethod("getHead");
            return (Head) getHeadMethod.invoke(npciMessage);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    Txn extractTxn(Object npciMessage) {
        if (npciMessage == null) return null;
        try {
            Method getHeadMethod = npciMessage.getClass().getMethod("getTxn");
            return (Txn) getHeadMethod.invoke(npciMessage);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    Payer extractPayer(Object npciMessage) {
        if (npciMessage == null) return null;
        try {
            Method getPayerMethod = npciMessage.getClass().getMethod("getPayer");
            return (Payer) getPayerMethod.invoke(npciMessage);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    String getKey(AccountDetailNameType type) {
        return switch (type) {
            case AccountDetailNameType.UIDNUM -> UID;
            case AccountDetailNameType.VID -> VID;
            case AccountDetailNameType.UIDTOKEN -> UID_TOKEN;
            case AccountDetailNameType.IIN -> IIN;
        };
    }

    void logRequest(Context ctx, String xmlPayload) {
        ctx.log("Request :-\n");
        ctx.log(xmlPayload);
        ctx.log("\n");
    }
}
