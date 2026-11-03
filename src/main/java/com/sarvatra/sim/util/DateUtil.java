package com.sarvatra.sim.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtil {

    public static String getTimeStamp() {
        ZonedDateTime now = ZonedDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        return now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
