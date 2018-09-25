package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleTypeRepository")
public interface RoleTypeRepository extends JpaRepository<RoleType, String> {
}
