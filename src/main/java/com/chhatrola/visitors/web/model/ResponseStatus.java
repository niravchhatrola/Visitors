package com.chhatrola.visitors.web.model;

public enum ResponseStatus {

    LOGIN_SUCCESSFULL("2000", "Login Successful"),
    INVALID_USER("2001", "Invalid User"),
    INVALID_BRANCH("2002", "Invalid Branch"),
    LOGOUT_SUCCESSFULL("2003", "Logout Successful"),
    CONTRACTOR_VISIT_SUCCESSFULLY_CREATED("2004", "Contractor visit successfully created");

    ResponseStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
