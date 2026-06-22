package com.pcbooking.repository;

import com.pcbooking.model.Peminjam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamRepository extends JpaRepository<Peminjam, String> {
}
