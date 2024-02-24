package com.msfmydream.constant;

public enum InterfaceInfoStatusEnum {
    ONLINE(1, "上线"),
    OFFLINE(0, "下线");

    private final Integer value;

    private final String message;

    InterfaceInfoStatusEnum(Integer value, String message){
        this.value = value;
        this.message = message;
    }

    public Integer getValue(){
        return value;
    }
}
