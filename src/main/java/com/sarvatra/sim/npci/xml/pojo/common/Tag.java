package com.sarvatra.sim.npci.xml.pojo.common;

import com.sarvatra.sim.npci.xml.pojo.enums.DeviceTagNameType;
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
public class Tag {

    @XmlAttribute
    private DeviceTagNameType name;

    @XmlAttribute
    private String value;

    public static Tag of(DeviceTagNameType name, String value) {
        return new Tag(name, value);
    }
}
