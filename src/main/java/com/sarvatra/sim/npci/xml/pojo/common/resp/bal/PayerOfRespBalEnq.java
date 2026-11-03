package com.sarvatra.sim.npci.xml.pojo.common.resp.bal;


import com.sarvatra.sim.npci.xml.pojo.enums.PayerType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayerOfRespBalEnq {

    @XmlAttribute(name = "addr")
    private String addr;

    @XmlAttribute(name = "code")
    private String code;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "seqNum")
    private String seqNum;

    @XmlAttribute(name = "type")
    private PayerType type;

    @XmlElement(name = "MiniStatement")
    private MiniStatement miniStatement;

    @XmlElement(name = "Bal")
    private Bal bal;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Bal {

        @XmlElement(name = "Data")
        String data;

        public static Bal of(String data) {
            return new Bal(data);
        }
    }
}
