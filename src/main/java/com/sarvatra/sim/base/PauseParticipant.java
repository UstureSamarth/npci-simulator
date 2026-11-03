package com.sarvatra.sim.base;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

import static com.sarvatra.sim.base.Processor.execute;


@SuppressWarnings("unused")
public abstract class PauseParticipant implements TransactionParticipant, Configurable {

    protected Configuration cfg;

    protected abstract void doPauseAndPrepare(Context ctx) throws Exception;

    /**
     * Optional for abort flow.
     * Subclasses may override.
     */
    @SuppressWarnings("RedundantThrows")
    protected void doPrepareForAbort(Context ctx) throws Exception {

    }

    @Override
    public void setConfiguration(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public int prepare(long id, Serializable context) {
        Context ctx = (Context) context;
        return execute(ctx, this::doPauseAndPrepare, PAUSE);
    }

    public int prepareForAbort(long id, Serializable context) {
        Context ctx = (Context) context;
        return execute(ctx, this::doPrepareForAbort, ABORTED);
    }

}
