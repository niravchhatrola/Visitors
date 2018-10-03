package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Contractor;
import com.chhatrola.visitors.web.model.ContractorVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractorVisitRepository")
public interface ContractorVisitRepository extends JpaRepository<ContractorVisit, Long> {
//    findByUserNameAndBranch_BranchCode

    List<String> findBranch_BranchCodeByEmployee_EmployeeId(Long employeeId);

    List<ContractorVisit> findByEmployee_employeeIdAndSignedOutAndBranch_BranchCode(Long employeeId, String signedOut, String branchCode);

    List<ContractorVisit> findByContractor_ContractorIdAndEmployee_employeeIdAndSignedOutAndBranch_BranchCode(Long contractorId, Long employeeId, String signedOut, String branchCode);

}
