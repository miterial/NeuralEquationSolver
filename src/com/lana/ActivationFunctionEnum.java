package com.lana;

enum ActivationFunctionEnum {
    EQUATION("="),
    INEQUATION(">=");

    private String val;
    ActivationFunctionEnum(String val) {
        this.val = val;
    }
    public String value() {
        return val;
    }
}
