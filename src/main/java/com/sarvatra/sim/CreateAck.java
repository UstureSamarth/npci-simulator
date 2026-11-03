package com.sarvatra.sim;

import com.sarvatra.sim.base.PrepareParticipant;
import com.sarvatra.sim.npci.xml.pojo.response.Ack;
import jakarta.xml.bind.JAXBException;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.List;

import static com.sarvatra.sim.npci.xml.util.NPCIXmlUtil.toXmlString;
import static com.sarvatra.sim.npci.xml.util.SimulatorConstant.*;
import static com.sarvatra.sim.util.DateUtil.getTimeStamp;
import static com.sarvatra.sim.util.ResponseUtil.putResponse;
import static com.sarvatra.sim.util.ResultCodeUtil.EXTRC;
import static com.sarvatra.sim.util.ResultCodeUtil.RC;

public final class CreateAck extends PrepareParticipant implements AbortParticipant {

    @Override
    protected void doPrepare(Context ctx) throws JAXBException {
        putAck(ctx);
        ctx.put(PREPARE_RESPONSE, "Y");
    }

    @Override
    protected void doPrepareForAbort(Context ctx) throws JAXBException {
        putAck(ctx);
    }

    Ack getAck(Context ctx) {
        return Ack.builder()
                .reqMsgId(ctx.getString(MSG_ID))
                .api(ctx.getString(REQUEST_NAME))
                .ts(getTimeStamp())
                .errorMessages(getErrorMessage(ctx))
                .build();
    }

    List<Ack.ErrorMessage> getErrorMessage(Context ctx) {
        List<Ack.ErrorMessage> messages = null;
        String rc = ctx.getString(RC);
        if (rc != null) {
            messages = List.of(
                    Ack.ErrorMessage.of(ctx.getString(RC), ctx.getString(EXTRC))
            );
        }
        return messages;
    }

    void putAck(Context ctx) throws JAXBException {
        String ack = toXmlString(getAck(ctx));
        logAck(ctx, ack);
        putResponse(ack, ctx);
    }

    void logAck(Context ctx, String xmlPayload) {
        ctx.log("Ack :-\n");
        ctx.log(xmlPayload);
        ctx.log("\n");
    }

}
