package com.sarvatra.sim;


import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.io.Serializable;

import static com.sarvatra.sim.npci.xml.util.SimulatorConstant.*;
import static com.sarvatra.sim.util.HttpClientBuilder.sendAsync;
import static com.sarvatra.sim.util.ResponseBuilder.*;

public final class SendFinalResponse implements AbortParticipant {
    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | READONLY;
    }

    @Override
    public void commit(long id, Serializable context) {
        Context ctx = (Context) context;
        String response = getResponse(ctx);
        logResponse(ctx, response);
        if (response != null) {
            int delay = Integer.parseInt(ctx.getString(DELAY, "0"));
            sendAsync(ctx.getString(CLIENT_URL), response, delay);
        }
    }

    @Override
    public void abort(long id, Serializable context) {
        this.commit(id, context);
    }

    public String getResponse(Context ctx) {
        String reqName = ctx.getString(REQUEST_NAME);
        try {
            return switch (reqName) {
                case REQ_BIO_AUTH -> getRespBioAuth(ctx);
                case REQ_BAL_ENQ -> getRespBalEnq(ctx);
                case REQ_PAY -> getRespPay(ctx);
                case REQ_CHK_TXN -> getRespChkTxn(ctx);
                case REQ_OTP -> getRespOtp(ctx);
                default -> null;
            };
        } catch (Exception e) {
            ctx.log(e);
        }
        return null;
    }

    void logResponse(Context ctx, String xmlPayload) {
        ctx.log("Response :-\n");
        ctx.log(xmlPayload);
        ctx.log("\n");
    }

}
