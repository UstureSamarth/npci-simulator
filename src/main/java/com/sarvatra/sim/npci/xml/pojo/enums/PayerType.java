package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum PayerType {
    @XmlEnumValue("ENTITY") ENTITY,
    @XmlEnumValue("INDIVIDUAL") INDIVIDUAL
}
