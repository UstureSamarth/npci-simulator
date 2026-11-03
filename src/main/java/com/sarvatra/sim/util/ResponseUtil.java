package com.sarvatra.sim.util;

import com.sarvatra.sim.exception.SimulatorException;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jpos.qrest.Constants;
import org.jpos.qrest.Response;
import org.jpos.transaction.Context;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static com.sarvatra.sim.util.AssertionUtil.notNull;
import static com.sarvatra.sim.util.StmtGenerator.RANDOM;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseUtil {

    public static void putResponse(String response, Context ctx) {
        Response finalResponse = new Response(HttpResponseStatus.OK, response, "application/xml");
        ctx.put(Constants.RESPONSE, finalResponse);
    }

    public static String generateAuthCode() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void putRequired(Context ctx, String key, Object value) throws SimulatorException {
        notNull(value, "99", key + " is null");
        if (value != null) {
            ctx.put(key, value);
        }
    }

    public static String getRandomAmount() {
        int value = ThreadLocalRandom.current().nextInt(100, 1001); // 100–1000
        long scaled = value * 100L;
        return "1002356C" + String.format("%012d", scaled);
    }

    public static String generate12DigitNumber() {
        long number = 100_000_000_000L + (Math.abs(RANDOM.nextLong()) % 900_000_000_000L);
        return String.valueOf(number);
    }
}
