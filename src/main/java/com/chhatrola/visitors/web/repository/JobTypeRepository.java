package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jobTypeRepository")
public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
