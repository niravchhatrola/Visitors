package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.ContractorVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by niv214 on 23/9/18.
 */
@Repository("contractorVisitRepository")
public interface ContractorVisitRepository extends JpaRepository<ContractorVisit, Long> {
//    findByUserNameAndBranch_BranchCode

    List<String> findBranch_BranchCodeByEmployee_EmployeeId(Long employeeId);
}
