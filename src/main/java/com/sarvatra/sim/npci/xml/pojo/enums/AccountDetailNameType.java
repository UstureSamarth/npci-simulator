package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AccountDetailNameType {

    @XmlEnumValue("IIN") IIN,
    @XmlEnumValue("UIDNUM") UIDNUM,
    @XmlEnumValue("VID") VID,
    @XmlEnumValue("UIDTOKEN") UIDTOKEN,

}
