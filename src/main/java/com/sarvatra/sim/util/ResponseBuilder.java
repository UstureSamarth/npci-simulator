package com.sarvatra.sim.util;

import com.sarvatra.sim.npci.xml.pojo.response.*;
import jakarta.xml.bind.JAXBException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jpos.transaction.Context;

import static com.sarvatra.sim.npci.xml.util.NPCIXmlUtil.toXmlString;
import static com.sarvatra.sim.npci.xml.util.SimulatorConstant.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseBuilder {

    public static String getRespPay(Context ctx) throws JAXBException {
        RespPay pay = RespPay.builder()
                .head(ctx.get(REQUEST_HEAD_TAG))
                .txn(ctx.get(REQUEST_TXN_TAG))
                .resp(ctx.get(RESP_TAG))
                .build();
        return toXmlString(pay);
    }

    public static String getRespBioAuth(Context ctx) throws JAXBException {
        RespBioAuth bioAuth = RespBioAuth.builder()
                .head(ctx.get(REQUEST_HEAD_TAG))
                .txn(ctx.get(REQUEST_TXN_TAG))
                .resp(ctx.get(RESP_TAG))
                .uidaiData(ctx.get(UIDAI_DATA))
                .build();
        return toXmlString(bioAuth);
    }

    public static String getRespChkTxn(Context ctx) throws JAXBException {
        RespChkTxn chkTxn = RespChkTxn.builder()
                .head(ctx.get(REQUEST_HEAD_TAG))
                .txn(ctx.get(REQUEST_TXN_TAG))
                .resp(ctx.get(RESP_TAG))
                .build();
        return toXmlString(chkTxn);
    }

    public static String getRespOtp(Context ctx) throws JAXBException {
        RespOtp otpTxn = RespOtp.builder()
                .head(ctx.get(REQUEST_HEAD_TAG))
                .txn(ctx.get(REQUEST_TXN_TAG))
                .resp(ctx.get(RESP_TAG))
                .uidaiData(ctx.get(UIDAI_DATA))
                .build();
        return toXmlString(otpTxn);
    }

    public static String getRespBalEnq(Context ctx) throws JAXBException {
        RespBalEnq balEnq = RespBalEnq.builder()
                .head(ctx.get(REQUEST_HEAD_TAG))
                .txn(ctx.get(REQUEST_TXN_TAG))
                .resp(ctx.get(RESP_TAG))
                .payer(ctx.get(PAYER_OF_RESP_BAL_ENQ_TAG))
                .build();
        return toXmlString(balEnq);
    }
}
