package com.sarvatra.sim.npci.xml.pojo.common.resp.bio;

import com.sarvatra.sim.npci.xml.pojo.common.cred.authchild.Skey;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UidaiData {

    @XmlAttribute
    private String err;

    @XmlAttribute
    private String txn;

    @XmlAttribute
    private String info;

    @XmlElement
    private KycRes kycRes;

    @XmlElement
    private TokenizeRes tokenizeRes;

    @XmlElementWrapper(name = "Ranks")
    @XmlElement(name = "Rank")
    private List<Rank> ranks;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    public static class KycRes {

        @XmlAttribute
        private String ko;

        @XmlElement(name = "Data")
        private String data;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    public static class TokenizeRes {

        @XmlElement(name = "Skey")
        private Skey skey;

        @XmlElement(name = "Data")
        private String data;

        @XmlElement(name = "Hmac")
        private String hmac;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rank {

        @XmlAttribute
        private String pos;

        @XmlAttribute
        private String val;

        public static Rank of(String pos, String val) {
            return new Rank(pos, val);
        }

    }

}
