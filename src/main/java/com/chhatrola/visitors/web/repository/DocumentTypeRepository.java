package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("documentTypeRepository")
public interface DocumentTypeRepository extends JpaRepository<DocumentType, String>{
}
