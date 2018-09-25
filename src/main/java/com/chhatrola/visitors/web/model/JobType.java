package com.chhatrola.visitors.web.model;

import javax.persistence.*;

@Entity
@Table(name = "job_type")
public class JobType {

    @Id
    @Column(name = "job_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobCode;

    @Column(name = "job_type_name")
    private String name;

    @Column(name = "job_desc")
    private String jobDesc;


    public Long getJobCode() {
        return jobCode;
    }

    public void setJobCode(Long jobCode) {
        this.jobCode = jobCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
}
