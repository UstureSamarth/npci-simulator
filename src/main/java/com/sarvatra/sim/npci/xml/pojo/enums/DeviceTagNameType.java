package com.sarvatra.sim.npci.xml.pojo.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum DeviceTagNameType {

    @XmlEnumValue("LOCATION") LOCATION,
    @XmlEnumValue("TYPE") TYPE,
    @XmlEnumValue("cardAccpTrId") CARD_ACCP_TR_ID,
    @XmlEnumValue("cardAccIdCode") CARD_ACC_ID_CODE,
    @XmlEnumValue("posEntryCode") POS_ENTRY_CODE,
    @XmlEnumValue("posServCdnCode") POS_SERVE_CDN_CODE,
    @XmlEnumValue("AgentId") AGENT_ID,
    @XmlEnumValue("PinCode") PIN_CODE,

}
