package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("branchRepository")
public interface BranchRepository extends JpaRepository<Branch, String> {
}
