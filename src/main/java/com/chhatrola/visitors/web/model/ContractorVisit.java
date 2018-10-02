package com.chhatrola.visitors.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contractor_visit")
public class ContractorVisit {

    @Id
    @Column(name = "contractor_visit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactorVisitId;

    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate;

    @Column(name = "visit_in_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitInTime;

    @Column(name = "visit_out_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitOutTime;

    @Column(name = "signature_path")
    private String signaturePath;

    @Column(name = "signed_out")
    private String signedOut;

    @Column(name = "hazard_reg_viewed")
    private Boolean hazardRegViewed;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Contractor.class)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    @ManyToOne(targetEntity = JobType.class)
    @JoinColumn(name = "job_code")
    private JobType jobType;

    @ManyToOne(targetEntity = DocumentType.class)
    @JoinColumn(name = "document_id")
    private DocumentType documentType;

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "branch_code")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Long getContactorVisitId() {
        return contactorVisitId;
    }

    public void setContactorVisitId(Long contactorVisitId) {
        this.contactorVisitId = contactorVisitId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitInTime() {
        return visitInTime;
    }

    public void setVisitInTime(Date visitInTime) {
        this.visitInTime = visitInTime;
    }

    public Date getVisitOutTime() {
        return visitOutTime;
    }

    public void setVisitOutTime(Date visitOutTime) {
        this.visitOutTime = visitOutTime;
    }

    public String getSignaturePath() {
        return signaturePath;
    }

    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }

    public String getSignedOut() {
        return signedOut;
    }

    public void setSignedOut(String signedOut) {
        this.signedOut = signedOut;
    }

    public Boolean getHazardRegViewed() {
        return hazardRegViewed;
    }

    public void setHazardRegViewed(Boolean hazardRegViewed) {
        this.hazardRegViewed = hazardRegViewed;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
