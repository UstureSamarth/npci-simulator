package com.sarvatra.sim.npci.xml.pojo;


import com.sarvatra.sim.npci.xml.pojo.common.Account;
import com.sarvatra.sim.npci.xml.pojo.common.Amount;
import com.sarvatra.sim.npci.xml.pojo.common.Info;
import com.sarvatra.sim.npci.xml.pojo.common.Tag;
import com.sarvatra.sim.npci.xml.pojo.common.cred.Cred;
import com.sarvatra.sim.npci.xml.pojo.enums.PayerType;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payer {

    @XmlAttribute(name = "addr")
    private String addr;

    @XmlAttribute(name = "code")
    @Builder.Default
    private String code = "6012";

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "seqNum")
    @Builder.Default
    private String seqNum = "0";

    @XmlAttribute(name = "type")
    @Builder.Default
    private PayerType type = PayerType.ENTITY;

    @XmlElement(name = "Info")
    private Info info;

    @XmlElementWrapper(name = "Device")
    @XmlElement(name = "Tag")
    private List<Tag> tags;

    @XmlElement(name = "Ac")
    private Account ac;

    @XmlElementWrapper(name = "Creds")
    @XmlElement(name = "Cred")
    private List<Cred> cred;

    @XmlElement(name = "Amount")
    private Amount amount;

}
