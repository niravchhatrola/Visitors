package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.ContractorVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by niv214 on 23/9/18.
 */
@Repository("contractorVisitRepository")
public interface ContractorVisitRepository extends JpaRepository<ContractorVisit, Long> {
}
