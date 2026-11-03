package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tokenize {

    @XmlAttribute
    private String ac;

    @XmlAttribute
    private String ver;

    @XmlAttribute
    private String txn;

    @XmlAttribute
    private String lk;

    @XmlAttribute
    private String ts;

}
