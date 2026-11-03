package com.sarvatra.sim.npci.xml.pojo;

import com.sarvatra.sim.npci.xml.pojo.common.Account;
import com.sarvatra.sim.npci.xml.pojo.common.Amount;
import com.sarvatra.sim.npci.xml.pojo.common.cred.Cred;
import com.sarvatra.sim.npci.xml.pojo.enums.PayeeType;
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
public class Payee {

    @XmlAttribute(name = "addr")
    private String addr;

    @XmlAttribute(name = "code")
    @Builder.Default
    private String code = "0000";

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "seqNum")
    @Builder.Default
    private String seqNum = "0";

    @XmlAttribute(name = "type")
    @Builder.Default
    private PayeeType type = PayeeType.PERSON;

    @XmlElement(name = "Ac")
    private Account account;

    @XmlElementWrapper(name = "Creds")
    @XmlElement(name = "Cred")
    private List<Cred> cred;

    @XmlElement(name = "Amount")
    private Amount amount;

}
