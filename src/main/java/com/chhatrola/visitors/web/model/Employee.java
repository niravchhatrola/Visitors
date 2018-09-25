package com.chhatrola.visitors.web.model;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "employee_auth_token")
    private String empAuthToken;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToOne(targetEntity = RoleType.class)
    @JoinColumn(name = "role_type")
    private RoleType roleType;

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "branch_code")
    private Branch branch;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAuthToken() {
        return empAuthToken;
    }

    public void setEmpAuthToken(String empAuthToken) {
        this.empAuthToken = empAuthToken;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
