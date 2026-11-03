package com.sarvatra.sim.util;

import com.sarvatra.sim.exception.SimulatorException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AssertionUtil {

    public static void isTrue(boolean condition, Object message) throws SimulatorException {
        check(condition, message, null);
    }

    public static void isTrue(boolean condition, Object message, String detail) throws SimulatorException {
        check(condition, message, detail);
    }

    public static void isFalse(boolean condition, Object message) throws SimulatorException {
        check(!condition, message, null);
    }

    public static void isFalse(boolean condition, Object message, String detail) throws SimulatorException {
        check(!condition, message, detail);
    }

    public static void notNull(Object obj, Object message) throws SimulatorException {
        check(obj != null, message, null);
    }

    public static void notNull(Object obj, Object message, String detail) throws SimulatorException {
        check(obj != null, message, detail);
    }

    public static void isNull(Object obj, Object message) throws SimulatorException {
        check(obj == null, message, null);
    }

    public static void isNull(Object obj, Object message, String detail) throws SimulatorException {
        check(obj == null, message, detail);
    }

    public static void notBlank(String str, Object message) throws SimulatorException {
        check(StringUtils.isNotBlank(str), message, null);
    }

    public static void notBlank(String str, Object message, String detail) throws SimulatorException {
        check(StringUtils.isNotBlank(str), message, detail);
    }

    private static void check(boolean condition, Object message, String detail) throws SimulatorException {
        if (condition) return;
        if (message instanceof Integer) {
            throw detail == null
                    ? new SimulatorException(String.valueOf(message))
                    : new SimulatorException(String.valueOf(message), detail);
        } else {
            throw detail == null
                    ? new SimulatorException((String) message)
                    : new SimulatorException((String) message, detail);
        }
    }
}
