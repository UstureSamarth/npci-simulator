package com.sarvatra.sim.npci.xml.pojo.common;

import com.sarvatra.sim.npci.xml.pojo.enums.CurrencyType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount {

    @XmlAttribute
    private BigDecimal value;

    @XmlAttribute(name = "curr")
    private CurrencyType currency;

    public static Amount of(BigDecimal value) {
        return new Amount(value, CurrencyType.INR);
    }

}
