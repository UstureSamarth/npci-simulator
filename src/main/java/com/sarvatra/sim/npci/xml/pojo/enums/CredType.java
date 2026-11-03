package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum CredType {
    @XmlEnumValue("AADHAAR") AADHAAR,
    @XmlEnumValue("PostCredit") POST_CREDIT,
    @XmlEnumValue("PreApproved") PRE_APPROVED
}
