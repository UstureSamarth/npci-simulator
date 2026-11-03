package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AuthDataType {
    @XmlEnumValue("X") X,
    @XmlEnumValue("P") P
}
