package com.chhatrola.visitors.web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="vendor_id")
    private Long vendorId;

    @Column(name="vendor_name")
    private String vendorName;

    @Column(name = "vendor_desc")
    private String vendorDesc;

    @OneToMany(targetEntity = Vendor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private Set<Contractor> contractors;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorDesc() {
        return vendorDesc;
    }

    public void setVendorDesc(String vendorDesc) {
        this.vendorDesc = vendorDesc;
    }

    public Set<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(Set<Contractor> contractors) {
        this.contractors = contractors;
    }
}
