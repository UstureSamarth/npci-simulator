package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;

public enum TxnPurpose {
    @XmlEnumValue("21") P21,
    @XmlEnumValue("22") P22,
    @XmlEnumValue("23") P23,
    @XmlEnumValue("24") P24,
    @XmlEnumValue("00") P00,
}
