package com.sarvatra.sim.npci.xml.util;

import com.sarvatra.sim.npci.xml.pojo.request.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SimulatorConstant {

    public static final String REQ_BIO_AUTH = "ReqBioAuth";
    public static final String REQ_PAY = "ReqPay";
    public static final String REQ_OTP = "ReqOtp";
    public static final String REQ_BAL_ENQ = "ReqBalEnq";
    public static final String REQ_CHK_TXN = "ReqChkTxn";
    public static final String RESP_BIO_AUTH = "RespBioAuth";
    public static final String RESP_BAL_ENQ = "RespBalEnq";
    public static final String RESP_PAY = "RespPay";
    public static final String RESP_CHK_TXN = "RespChkTxn";
    public static final String RESP_OTP = "RespOtp";
    public static final String MSG_ID = "MSG_ID";
    public static final String ACQUIRER = "ACQUIRER";
    public static final String TXN_ID = "TXN_ID";
    public static final String STAN = "STAN";
    public static final String RRN = "RRN";
    public static final String TXN_NAME = "TXN_NAME";
    public static final String TXN_TYPE = "TXN_TYPE";
    public static final String PURPOSE_CODE = "PURPOSE_CODE";
    public static final String DEPOSIT_ID = "DEPOSIT_ID";
    public static final String CLIENT_REQUEST = "CLIENT_REQUEST";
    public static final String REQUEST_NAME = "REQUEST_NAME";
    public static final String REQUEST_HEAD_TAG = "REQUEST_HEAD_TAG";
    public static final String REQUEST_TXN_TAG = "REQUEST_TXN_TAG";
    public static final String RESP_TAG = "RESP_TAG";
    public static final String PAYER_OF_RESP_BAL_ENQ_TAG = "PAYER_OF_RESP_BAL_ENQ_TAG";
    public static final String PREPARE_RESPONSE = "PREPARE_RESPONSE";
    public static final String AMOUNT = "AMOUNT";
    public static final String CW = "CW";
    public static final String BIO_AUTH = "BioAuth";
    public static final String BAV = "BAV";
    public static final String GEN_OTP = "GEN_OTP";
    public static final String CDA = "CDA";
    public static final String FT = "FT";
    public static final String BAL_ENQ = "BAL_ENQ";
    public static final String MINI_STAT = "MINI_STAT";
    public static final String UID = "UID";
    public static final String IIN = "IIN";
    public static final String VID = "VID";
    public static final String UID_TOKEN = "UID_TOKEN";
    public static final String UIDAI_DATA = "UIDAI_DATA";
    public static final String DELAY = "DELAY";
    public static final String CLIENT_URL = "CLIENT_URL";

    public static final Set<String> RESP_BAL_TXN = Set.of(BAL_ENQ, MINI_STAT, REQ_OTP);
    public static final Set<String> NO_REF_REQUIRED = Set.of(BAL_ENQ, MINI_STAT, GEN_OTP);

    public static final Map<String, Class<?>> REQUEST_MAP = Map.ofEntries(
            Map.entry(REQ_BIO_AUTH, ReqBioAuth.class),
            Map.entry(REQ_PAY, ReqPay.class),
            Map.entry(REQ_BAL_ENQ, ReqBalEnq.class),
            Map.entry(REQ_CHK_TXN, ReqChkTxn.class),
            Map.entry(REQ_OTP, ReqOtp.class)
    );

    public static final Map<String, String> REQUEST_RESPONSE_MAP = Map.ofEntries(
            Map.entry(REQ_BIO_AUTH, RESP_BIO_AUTH),
            Map.entry(REQ_PAY, RESP_PAY),
            Map.entry(REQ_BAL_ENQ, RESP_BAL_ENQ),
            Map.entry(REQ_CHK_TXN, RESP_CHK_TXN),
            Map.entry(REQ_OTP, RESP_OTP)
    );
}
