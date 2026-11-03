package com.sarvatra.sim.npci.xml.util;


import com.sarvatra.sim.npci.xml.pojo.request.*;
import com.sarvatra.sim.npci.xml.pojo.response.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JAXBContextConstants {
    public static final Map<Class<?>, JAXBContext> JAXB_CONTEXT_MAP;

    static {
        try {
            JAXB_CONTEXT_MAP = Map.ofEntries(
                    Map.entry(ReqBioAuth.class, JAXBContext.newInstance(ReqBioAuth.class)),
                    Map.entry(ReqPay.class, JAXBContext.newInstance(ReqPay.class)),
                    Map.entry(ReqBalEnq.class, JAXBContext.newInstance(ReqBalEnq.class)),
                    Map.entry(ReqChkTxn.class, JAXBContext.newInstance(ReqChkTxn.class)),
                    Map.entry(ReqOtp.class, JAXBContext.newInstance(ReqOtp.class)),
                    Map.entry(RespBioAuth.class, JAXBContext.newInstance(RespBioAuth.class)),
                    Map.entry(RespPay.class, JAXBContext.newInstance(RespPay.class)),
                    Map.entry(RespBalEnq.class, JAXBContext.newInstance(RespBalEnq.class)),
                    Map.entry(RespChkTxn.class, JAXBContext.newInstance(RespChkTxn.class)),
                    Map.entry(RespOtp.class, JAXBContext.newInstance(RespOtp.class)),
                    Map.entry(ReqHbt.class, JAXBContext.newInstance(ReqHbt.class)),
                    Map.entry(RespHbt.class, JAXBContext.newInstance(RespHbt.class)),
                    Map.entry(Ack.class, JAXBContext.newInstance(Ack.class))
            );
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
