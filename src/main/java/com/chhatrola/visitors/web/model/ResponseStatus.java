package com.chhatrola.visitors.web.model;

public enum ResponseStatus {

    LOGIN_SUCCESSFULL("2000", "Login Successful"),
    INVALID_USER("2001", "Invalid User"),
    INVALID_BRANCH("2002", "Invalid Branch"),
    LOGOUT_SUCCESSFULL("2003", "Logout Successful"),
    CONTRACTOR_VISIT_SUCCESSFULLY_CREATED("2004", "Contractor visit successfully created"),
    NO_SIGNED_IN_CONTRACTORS("2005", "no signed in contractors"),
    SUCCESSFULLY_FETCHED_SIGND_IN_CONTRACTORS("2006", "Successfully fetched signd in contractors"),
    SUCCESSFULLY_FETCHED_SIGND_OUT_CONTRACTORS("2007", "Successfully fetched signd out contractors"),
    NO_SIGNED_OUT_CONTRACTORS("2008", "no signed in contractors"),
    CONTRACTOR_SUCCESSFULLY_SIGNED_OUT("2009", "Contractor successfully signed out"),
    SIGNATURE_SUCCESSFULLY_UPLOADED("2010", "Signature successfully uploaded"),
    Document_SUCCESSFULLY_UPLOADED("2011", "Document successfully uploaded"),
    ERROR_IN_DOCUMENT_UPLOAD("2012", "Error in document upload"),
    ERROR_IN_SIGNATURE_UPLOAD("2013", "Error in signature upload");

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
