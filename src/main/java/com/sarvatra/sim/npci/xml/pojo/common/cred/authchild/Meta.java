package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;


import com.sarvatra.sim.npci.xml.pojo.enums.LotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meta {

    @XmlElement
    private String udc;

    @XmlElement
    private LotType lot;

    @XmlElement
    private String lov;

    @XmlElement
    private String rdsId;

    @XmlElement
    private String rdsVer;

    @XmlElement
    private String dpId;

    @XmlElement
    private String dc;

    @XmlElement
    private String mi;

    @XmlElement
    private String mc;

}
