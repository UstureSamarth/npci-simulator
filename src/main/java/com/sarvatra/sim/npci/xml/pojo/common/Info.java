package com.sarvatra.sim.npci.xml.pojo.common;


import com.sarvatra.sim.npci.xml.pojo.enums.VerifiedAddressType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Info {

    @XmlElement(name = "Identity")
    private Identity identity;

    @XmlElement(name = "Rating")
    @Builder.Default
    private Rating rating = Rating.of(VerifiedAddressType.TRUE);

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Identity {

        @XmlAttribute
        private String verifiedName;

        @XmlAttribute
        private String type;

        public static Identity of(String verifiedName) {
            return new Identity(verifiedName, "BANK");
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Rating {
        @XmlAttribute(name = "VerifiedAddress")
        private VerifiedAddressType verifiedAddressType;

        public static Rating of(VerifiedAddressType verifiedAddressType) {
            return new Rating(verifiedAddressType);
        }
    }
}
