package com.sarvatra.sim.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jpos.transaction.Context;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResultCodeUtil {
    public static final String RC = "RC";
    public static final String EXTRC = "EXTRC";

    public static void setResultCode(Context ctx, String rc) {
        setResultCode(ctx, rc, null);
    }

    public static void setResultCode(Context ctx, String rc, String detail) {
        ctx.put(RC, rc);
        if (detail != null)
            ctx.put(EXTRC, detail);
    }
}
