package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum BiometricType {

    @XmlEnumValue("FMR,FIR") FMR_FIR,
    @XmlEnumValue("FID") FID,
    @XmlEnumValue("FIR,FMR") FIR_FMR,
    @XmlEnumValue("IIR") IIR,

}
