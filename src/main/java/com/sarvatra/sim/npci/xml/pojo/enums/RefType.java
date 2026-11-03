package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum RefType {
    @XmlEnumValue("PAYER") PAYER,
    @XmlEnumValue("PAYEE") PAYEE,
    @XmlEnumValue("BENEFICIARY") BENEFICIARY,
    @XmlEnumValue("REMITTER") REMITTER
}
