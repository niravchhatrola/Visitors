package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Branch;
import com.chhatrola.visitors.web.model.Contractor;
import com.chhatrola.visitors.web.model.ContractorVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractorVisitRepository")
public interface ContractorVisitRepository extends JpaRepository<ContractorVisit, Long> {
//    findByUserNameAndBranch_BranchCode

//    @Query("select contractor0_ from ContractorVisit contractor0_ left outer join Employee employee1_ on contractor0_.employeeId=employee1_.employeeId where employee1_.employeeId=:employeeId")
    @Query("select distinct(contractor0_.branch.branchCode) from ContractorVisit contractor0_ left outer join contractor0_.employee employee1_ where employee1_.employeeId=:employeeId")
    List<String> findBranchByEmployee_EmployeeId(@Param("employeeId") Long employeeId);

//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);


    List<ContractorVisit> findByEmployee_employeeIdAndSignedOutAndBranch_BranchCode(Long employeeId, String signedOut, String branchCode);

    List<ContractorVisit> findByContractor_ContractorIdAndEmployee_employeeIdAndSignedOutAndBranch_BranchCode(Long contractorId, Long employeeId, String signedOut, String branchCode);

    //    {authoriser_id, from_date, to_date, vendor_name, contractor_name, job_type, branch_code}

    @Query("select contractor0_.contractor from ContractorVisit contractor0_ left outer join contractor0_.employee employee1_ where employee1_.employeeId=:employeeId")
    List<String> searchContractor(@Param("employeeId") Long employeeId);

}
