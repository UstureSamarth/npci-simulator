package com.sarvatra.sim.npci.xml.pojo.common.cred.authchild;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Skey {

    @XmlAttribute
    private String ci;

    @XmlValue
    private String value;

    public static Skey of(String ci, String value) {
        return new Skey(ci, value);
    }
}
