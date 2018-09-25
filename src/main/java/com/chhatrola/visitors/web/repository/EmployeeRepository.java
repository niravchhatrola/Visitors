package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByUserNameAndBranch_BranchCode(String userName, String branchCode);
//    public List<Employee> findByUserNameAndBranchCode(String userName, String branchCode);
}
