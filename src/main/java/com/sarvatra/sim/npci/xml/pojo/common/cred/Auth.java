package com.sarvatra.sim.npci.xml.pojo.common.cred;

import com.sarvatra.sim.npci.xml.pojo.common.cred.authchild.*;
import com.sarvatra.sim.npci.xml.pojo.enums.AuthDataType;
import lombok.*;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auth {

    @XmlAttribute(name = "lk")
    private String lk;

    @XmlAttribute(name = "ac")
    private String ac;

    @XmlAttribute(name = "sa")
    private String sa;

    @XmlAttribute(name = "uid")
    private String uid;

    @XmlAttribute(name = "ver")
    @Builder.Default
    private String ver = "2.5";

    @XmlAttribute(name = "tid")
    @Builder.Default
    private String tid = "registered";

    @XmlAttribute(name = "txn")
    private String txn;

    @XmlAttribute(name = "rc")
    @Builder.Default
    private String rc = "Y";

    @XmlElement(name = "Uses")
    private Uses uses;

    @XmlElement(name = "Meta")
    private Meta meta;

    @XmlElement(name = "Skey")
    private Skey skey;

    @XmlElement(name = "Hmac")
    private String hmac;

    @XmlElement(name = "Bfd")
    private BFD bfd;

    @XmlElement(name = "Tokenize")
    private Tokenize tokenize;

    @XmlElement(name = "Data")
    private AuthData authData;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AuthData {

        @XmlAttribute(name = "type")
        private AuthDataType type;

        @XmlValue
        private String value;

        public static AuthData of(String type, String value) {
            AuthDataType authDataType = AuthDataType.P.name().equals(type) ? AuthDataType.P : AuthDataType.X;
            return new AuthData(authDataType, value);
        }

    }

}
