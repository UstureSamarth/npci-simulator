package com.sarvatra.sim.npci.xml.pojo.common.resp;


import com.sarvatra.sim.npci.xml.pojo.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resp {

    @XmlElement(name = "Ref")
    protected List<Ref> ref;

    @XmlAttribute(name = "reqMsgId")
    private String reqMsgId;

    @XmlAttribute(name = "result")
    private ResultType result;

    @XmlAttribute(name = "errCode")
    private String errCode;

    @XmlAttribute(name = "actn")
    private String actn;

    @XmlAttribute(name = "authCode")
    private String authCode;

    @XmlAttribute(name = "approvalNum")
    private String approvalNum;
}
