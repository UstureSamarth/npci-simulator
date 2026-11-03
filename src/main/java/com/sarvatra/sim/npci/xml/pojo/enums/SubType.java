package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum SubType {
    @XmlEnumValue("AADHAAR-BIO-FP") AADHAAR_BIO_FP,
    @XmlEnumValue("AADHAAR-BIO-IRIS") AADHAAR_BIO_IRIS,
    @XmlEnumValue("AADHAAR-BIO-FACE") AADHAAR_BIO_FACE,
    @XmlEnumValue("AADHAAR-BIO-OTP") AADHAAR_BIO_OTP,
    @XmlEnumValue("UIDAI-AUTH-CODE") UIDAI_AUTH_CODE,
    @XmlEnumValue("NA") NA
}
