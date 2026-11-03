package com.sarvatra.sim.npci.xml.pojo.common.cred;

import com.sarvatra.sim.npci.xml.pojo.common.cred.authchild.KycReqInfo;
import com.sarvatra.sim.npci.xml.pojo.common.cred.authchild.Otp;
import com.sarvatra.sim.npci.xml.pojo.enums.CredType;
import com.sarvatra.sim.npci.xml.pojo.enums.SubType;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cred {

    @XmlAttribute
    @Builder.Default
    private CredType type = CredType.AADHAAR;

    @XmlAttribute
    @Builder.Default
    private SubType subType = SubType.AADHAAR_BIO_FP;

    @XmlElement(name = "Data")
    private Data data;

    @XmlElement(name = "Auth")
    private Auth auth;

    @XmlElement(name = "Otp")
    private Otp otp;

    @XmlElement(name = "KycReqInfo")
    private KycReqInfo kycReqInfo;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Data {

        @XmlValue
        private String value;

        @XmlAttribute(name = "code")
        private String code;

        @XmlAttribute(name = "ki")
        private String ki;
    }
}
