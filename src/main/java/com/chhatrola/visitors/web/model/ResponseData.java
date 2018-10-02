package com.chhatrola.visitors.web.model;

import java.util.List;

public class ResponseData {

    private Long employeeId;
    private String authToken;
    private List<String> branchCodeList;
    private Long contractorVisitId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public List<String> getBranchCodeList() {
        return branchCodeList;
    }

    public void setBranchCodeList(List<String> branchCodeList) {
        this.branchCodeList = branchCodeList;
    }

    public Long getContractorVisitId() {
        return contractorVisitId;
    }

    public void setContractorVisitId(Long contractorVisitId) {
        this.contractorVisitId = contractorVisitId;
    }
}
