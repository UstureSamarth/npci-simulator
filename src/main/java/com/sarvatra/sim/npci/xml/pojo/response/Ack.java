package com.sarvatra.sim.npci.xml.pojo.response;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

@XmlRootElement(name = "Ack", namespace = "http://npci.org/upi/schema/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ack {

    private List<ErrorMessage> errorMessages;

    @XmlAttribute(name = "api")
    private String api;

    @XmlAttribute(name = "reqMsgId")
    private String reqMsgId;

    @XmlAttribute(name = "ts")
    private String ts;

    @XmlAttribute(name = "err")
    private String err;

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ErrorMessage {

        @XmlElement(name = "errorCd", required = true)
        protected String errorCode;

        @XmlElement(name = "errorDtl", required = true)
        protected String errorDetail;

        public static ErrorMessage of(String code, String detail) {
            return new ErrorMessage(code, detail);
        }
    }
}
