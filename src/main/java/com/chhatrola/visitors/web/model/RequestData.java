package com.chhatrola.visitors.web.model;

public class RequestData {
    private String branchCode;
    private String userName;
    private String password;
    private Long empId;
    private String authToken;
    private Long vendorId;
    private String contractorName;
    private Long jobCode;
    private String contractorIdNumber;
    private String contractorIdType;
    private String contractorIdExpIDDate;
    private Boolean hazardRegViewed;
    private Long contractorId;
    private Byte[] image;
    private Long documentId;

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public Long getJobCode() {
        return jobCode;
    }

    public void setJobCode(Long jobCode) {
        this.jobCode = jobCode;
    }

    public String getContractorIdNumber() {
        return contractorIdNumber;
    }

    public void setContractorIdNumber(String contractorIdNumber) {
        this.contractorIdNumber = contractorIdNumber;
    }

    public String getContractorIdType() {
        return contractorIdType;
    }

    public void setContractorIdType(String contractorIdType) {
        this.contractorIdType = contractorIdType;
    }

    public String getContractorIdExpIDDate() {
        return contractorIdExpIDDate;
    }

    public void setContractorIdExpIDDate(String contractorIdExpIDDate) {
        this.contractorIdExpIDDate = contractorIdExpIDDate;
    }

    public Boolean getHazardRegViewed() {
        return hazardRegViewed;
    }

    public void setHazardRegViewed(Boolean hazardRegViewed) {
        this.hazardRegViewed = hazardRegViewed;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
}
