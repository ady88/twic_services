package com.adrian.twic_services_commons.transferobjects;

public class StatusTO {

    private Integer code;
    private String description;

    public StatusTO() {
    }

    public StatusTO(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StatusTO{" + "code=" + code + ", description=" + description + '}';
    }
}
