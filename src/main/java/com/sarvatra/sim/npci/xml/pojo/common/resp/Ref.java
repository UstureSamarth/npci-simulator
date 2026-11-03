package com.sarvatra.sim.npci.xml.pojo.common.resp;

import com.sarvatra.sim.npci.xml.pojo.enums.CurrencyType;
import com.sarvatra.sim.npci.xml.pojo.enums.RefType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ref {

    @XmlAttribute(name = "type")
    private RefType refType;

    @XmlAttribute
    @Builder.Default
    private String seqNum = "0";

    @XmlAttribute
    private String addr;

    @XmlAttribute
    private String regName;

    @XmlAttribute
    private String acNum;

    @XmlAttribute(name = "IFSC")
    private String ifsc;

    @XmlAttribute
    @Builder.Default
    private String code = "6012";

    @XmlAttribute
    private String accType;

    @XmlAttribute
    private String settAmount;

    @XmlAttribute
    private String orgAmount;

    @XmlAttribute
    private String approvalNum;

    @XmlAttribute
    private String respCode;

    @XmlAttribute
    private String respMsg;

    @XmlAttribute
    private String reversalRespCode;

    @XmlAttribute
    private String balAmt;

    @XmlAttribute
    @Builder.Default
    private CurrencyType settCurrency = CurrencyType.INR;

    @XmlAttribute
    private String iin;

    @XmlAttribute
    private String bankName;

    @XmlAttribute
    private String linkStatus;

    @XmlAttribute
    private CurrencyType lastUpdTs;

}
