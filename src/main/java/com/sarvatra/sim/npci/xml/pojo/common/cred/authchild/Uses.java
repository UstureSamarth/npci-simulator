package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Uses {

    @XmlElement
    private String pi;

    @XmlElement
    private String pa;

    @XmlElement
    private String pfa;

    @XmlElement
    private String bio;

    @XmlElement
    private String bt;

    @XmlElement
    private String pin;

    @XmlElement
    private String otp;
}
