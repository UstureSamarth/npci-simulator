package com.sarvatra.sim.npci.xml.pojo;


import com.sarvatra.sim.npci.xml.pojo.enums.ProductType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Head {

    @XmlAttribute
    @Builder.Default
    private String ver = "2.0";

    @XmlAttribute
    private String ts;

    @XmlAttribute
    private String orgId;

    @XmlAttribute
    private String msgId;

    @XmlAttribute
    @Builder.Default
    private ProductType productType = ProductType.AEPS;

}
