package com.sarvatra.sim.npci.xml.pojo.request;


import com.sarvatra.sim.npci.xml.pojo.Head;
import com.sarvatra.sim.npci.xml.pojo.Txn;
import com.sarvatra.sim.npci.xml.pojo.common.HbtMsg;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "ReqHbt", namespace = "http://npci.org/upi/schema/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqHbt {

    @XmlElement(name = "Head")
    private Head head;

    @XmlElement(name = "Txn")
    private Txn txn;

    @XmlElement(name = "HbtMsg")
    private HbtMsg hbtMsg;

}
