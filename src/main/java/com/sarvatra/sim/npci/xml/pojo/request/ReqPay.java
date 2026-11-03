package com.sarvatra.sim.npci.xml.pojo.request;


import com.sarvatra.sim.npci.xml.pojo.Head;
import com.sarvatra.sim.npci.xml.pojo.Payee;
import com.sarvatra.sim.npci.xml.pojo.Payer;
import com.sarvatra.sim.npci.xml.pojo.Txn;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "ReqPay", namespace = "http://npci.org/upi/schema/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqPay {

    @XmlElement(name = "Head")
    private Head head;

    @XmlElement(name = "Txn")
    private Txn txn;

    @XmlElement(name = "Payer")
    private Payer payer;

    @XmlElementWrapper(name = "Payees")
    @XmlElement(name = "Payee")
    private List<Payee> payee;
}
