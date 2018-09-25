package com.chhatrola.visitors.web.repository;

import com.chhatrola.visitors.web.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vendorRepository")
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
