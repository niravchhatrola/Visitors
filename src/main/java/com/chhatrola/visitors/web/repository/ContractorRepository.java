package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository("contractorRepository")
public interface ContractorRepository extends JpaRepository<Contractor, Long>{
//    List<Contractor> findByAuthoriserIdAndSignedOut(Long authoriserId, String signedOut);
//
//    Contractor findByAuthoriserIdAndContractorId(Long authoriserId, Long contractorId);

    Contractor findByContractorIdNumber(String contractorIdNumber);

    Contractor findByContractorName(String contractorName);

}
