package com.pcbooking.repository;

import com.pcbooking.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    List<Transaksi> findByStatusAktif(boolean statusAktif);
}
