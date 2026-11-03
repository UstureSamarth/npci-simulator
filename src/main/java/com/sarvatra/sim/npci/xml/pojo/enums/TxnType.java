package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TxnType {
    @XmlEnumValue("PAY") PAY,
    @XmlEnumValue("DEBIT") DEBIT,
    @XmlEnumValue("CREDIT") CREDIT,
    @XmlEnumValue("REVERSAL") REVERSAL,
    @XmlEnumValue("ADVICE") ADVICE,
    @XmlEnumValue("BalEnq") BAL_ENQ,
    @XmlEnumValue("BalChk") BAL_CHK,
    @XmlEnumValue("MiniStmt") MINI_STMT,
    @XmlEnumValue("BFD") BFD,
    @XmlEnumValue("BIO-AUTH") BIO_AUTH,
    @XmlEnumValue("DEMO-AUTH") DEMO_AUTH,
    @XmlEnumValue("OTP-AUTH-UPDATE") OTP_AUTH_UPDATE,
    @XmlEnumValue("Otp") OTP,
    @XmlEnumValue("EKYC") EKYC,
    @XmlEnumValue("TKN") TKN,
    @XmlEnumValue("Hbt") HBT,
    @XmlEnumValue("UNKNOWN") UNKNOWN
}
