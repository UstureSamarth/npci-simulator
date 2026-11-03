package com.sarvatra.sim.npci.xml.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HbtMsg {

    @XmlAttribute(name = "type")
    @Builder.Default
    private String type = "ALIVE";

    @XmlAttribute(name = "value")
    @Builder.Default
    private String value = "NA";
}
