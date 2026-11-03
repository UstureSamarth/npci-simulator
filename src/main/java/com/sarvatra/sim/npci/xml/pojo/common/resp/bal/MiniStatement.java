package com.sarvatra.sim.npci.xml.pojo.common.resp.bal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiniStatement {

    @XmlAttribute(name = "beneMas")
    private String beneMas;

    @XmlAttribute(name = "stmtLineCount")
    private String stmtLineCount;

    @XmlElement(name = "StmtData")
    private List<StmtData> stmtDatas;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class StmtData {

        @XmlAttribute(name = "seqNum")
        private String seqNum;

        @XmlAttribute(name = "value")
        private String value;

        public static StmtData of(String seqNum, String value) {
            return new StmtData(seqNum, value);
        }
    }
}
