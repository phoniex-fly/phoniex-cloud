package com.phoenix.common;

public enum LoginType {
    SYS_USER("0", "sysUser");

    private String code;
    private String msg;

    LoginType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
