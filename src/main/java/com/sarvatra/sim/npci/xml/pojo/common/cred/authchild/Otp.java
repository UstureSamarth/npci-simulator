package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Otp {

    @XmlAttribute
    private String uid;

    @XmlAttribute
    private String ts;

    @XmlAttribute
    private String ac;

    @XmlAttribute
    private String sa;

    @XmlAttribute
    private String ver;

    @XmlAttribute
    private String txn;

    @XmlAttribute
    private String lk;

    @XmlAttribute
    private String type;

    @XmlElement
    private Opts opts;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Opts {
        @XmlAttribute
        private String ch;
    }
}
