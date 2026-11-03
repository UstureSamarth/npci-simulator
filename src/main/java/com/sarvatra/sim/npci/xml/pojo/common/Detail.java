package com.sarvatra.sim.npci.xml.pojo.common;

import com.sarvatra.sim.npci.xml.pojo.enums.AccountDetailNameType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Detail {

    @XmlAttribute
    private AccountDetailNameType name;

    @XmlAttribute
    private String value;

    public static Detail of(AccountDetailNameType name, String value) {
        return new Detail(name, value);
    }
}
