package com.sarvatra.sim.npci.xml.pojo;

import com.sarvatra.sim.npci.xml.pojo.enums.ScoreType;
import com.sarvatra.sim.npci.xml.pojo.enums.TxnPurpose;
import com.sarvatra.sim.npci.xml.pojo.enums.TxnType;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Txn {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String note;

    @XmlAttribute
    private String custRef;

    @XmlAttribute
    private String refId;

    @XmlAttribute
    @Builder.Default
    private String refUrl = "https://www.npci.org.in/";

    @XmlAttribute
    private String ts;

    @XmlAttribute
    private String crtnTs;

    @XmlAttribute
    private TxnType type;

    @XmlAttribute
    private TxnPurpose purpose;

    @XmlAttribute
    @Builder.Default
    private String initiationMode = "00";

    @XmlAttribute
    private TxnType subType;

    @XmlAttribute
    private String orgTxnId;

    @XmlAttribute
    private String orgMsgId;

    @XmlAttribute
    private String orgRrn;

    @XmlAttribute
    private String orgTxnDate;

    @XmlAttribute
    private String orgRespCode;

    @XmlAttribute
    private String orgRespMsg;

    @XmlAttribute
    private String depositId;

    @XmlElementWrapper(name = "RiskScores")
    @XmlElement(name = "Score")
    private List<RiskScore> riskScores;


    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RiskScore {

        @XmlAttribute
        private String provider;

        @XmlAttribute
        private ScoreType type;

        @XmlAttribute
        private String value;
    }

}
