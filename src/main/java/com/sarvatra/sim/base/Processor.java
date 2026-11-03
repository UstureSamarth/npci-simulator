package com.sarvatra.sim.base;

import com.sarvatra.sim.exception.SimulatorException;
import org.jpos.transaction.Context;

import static com.sarvatra.sim.util.ResultCodeUtil.setResultCode;
import static org.jpos.transaction.TransactionConstants.ABORTED;

public interface Processor {
    void process(Context ctx) throws Exception;

    static int execute(Context ctx, Processor processor, int successCode) {
        try {
            processor.process(ctx);
            return successCode;
        } catch (SimulatorException e) {
            setResultCode(ctx, e.getMessage(), e.getDetail());
        } catch (Exception e) {
            ctx.log("\n" + e + "\n");
            setResultCode(ctx, "9999", e.getMessage());
        }
        return ABORTED;
    }
}
