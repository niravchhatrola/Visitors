package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
