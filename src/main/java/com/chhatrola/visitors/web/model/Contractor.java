package com.chhatrola.visitors.web.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractor_id")
    private Long contractorId;

    @Column(name = "contractor_name")
    private String contractorName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private List<ContractorVisit> contractorVisits = new ArrayList<>();

    @Column(name = "contractor_id_number")
    private String contractorIdNumber;

    @Column(name = "contractor_id_type")
    private String contractorIdType;

    @Column(name = "contractor_id_exp_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractorIdExpDate;

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public List<ContractorVisit> getContractorVisits() {
        return contractorVisits;
    }

    public void setContractorVisits(List<ContractorVisit> contractorVisits) {
        this.contractorVisits = contractorVisits;
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

    public Date getContractorIdExpDate() {
        return contractorIdExpDate;
    }

    public void setContractorIdExpDate(Date contractorIdExpDate) {
        this.contractorIdExpDate = contractorIdExpDate;
    }
}
