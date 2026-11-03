package com.sarvatra.sim.exception;

import lombok.Getter;

@Getter
public class SimulatorException extends Exception {
    private String detail;

    public SimulatorException(String s) {
        super(s);
    }

    public SimulatorException(String s, String detail) {
        super(s);
        this.detail = detail;
    }
}
