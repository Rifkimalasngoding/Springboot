package com.pcbooking.repository;

import com.pcbooking.model.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcRepository extends JpaRepository<Pc, String> {
}
