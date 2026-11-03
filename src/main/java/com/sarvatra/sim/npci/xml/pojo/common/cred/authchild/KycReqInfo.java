package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycReqInfo {

    @XmlElement
    private String ver;

    @XmlElement
    private String ra;

    @XmlElement
    private String rc;

    @XmlElement
    private String lr;

    @XmlElement
    private String de;

    @XmlElement
    private String pfr;

}
