package com.pcbooking.service;

import com.pcbooking.exception.ValidasiException;
import com.pcbooking.model.*;
import com.pcbooking.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransaksiService {

    // Menyambungkan service dengan repository (database)
    private final PcRepository pcRepo;
    private final PeminjamRepository peminjamRepo;
    private final TransaksiRepository transaksiRepo;

    public TransaksiService(PcRepository pcRepo, PeminjamRepository peminjamRepo, TransaksiRepository transaksiRepo) {
        this.pcRepo = pcRepo;
        this.peminjamRepo = peminjamRepo;
        this.transaksiRepo = transaksiRepo;
    }

    // Fungsi untuk membuat data PC bawaan saat aplikasi pertama kali jalan
    public void initDataAwal() {
        if(pcRepo.count() == 0) {
            pcRepo.save(new Pc("PC-01", "TERSEDIA"));
            pcRepo.save(new Pc("PC-02", "TERSEDIA"));
            pcRepo.save(new Pc("PC-03", "MAINTENANCE"));
        }
    }

    // FUNGSI UTAMA: Melakukan peminjaman beserta validasinya
    public Transaksi pinjamPc(String kodePC, String nim, String nama, int durasi, String keperluan) {
        
        // Validasi: Cek apakah PC ada di database
        Pc pc = pcRepo.findById(kodePC).orElseThrow(() -> new ValidasiException("PC tidak ditemukan"));
        
        // Validasi wajib: Tidak boleh pinjam jika PC tidak TERSEDIA
        if (!pc.getStatus().equals("TERSEDIA")) {
            throw new ValidasiException("PC sedang tidak tersedia.");
        }

        // Cek Peminjam: Kalau sudah ada pakai data lama, kalau belum buat baru
        Peminjam peminjam = peminjamRepo.findById(nim).orElse(new Peminjam(nim, nama));
        peminjam.setNama(nama);
        peminjamRepo.save(peminjam);

        // Ubah status PC jadi DIPINJAM
        pc.setStatus("DIPINJAM");
        pcRepo.save(pc);

        // Buat record Transaksi baru
        Transaksi t = new Transaksi();
        t.setPc(pc);
        t.setPeminjam(peminjam);
        t.setWaktuMulai(LocalDateTime.now());
        t.setDurasiJam(durasi);
        t.setKeperluan(keperluan);
        t.setStatusAktif(true);

        return transaksiRepo.save(t);
    }

    // FUNGSI UTAMA: Mengembalikan PC
    public void kembalikanPc(Long transaksiId) {
        Transaksi t = transaksiRepo.findById(transaksiId).orElseThrow(() -> new ValidasiException("Transaksi tidak ada"));
        
        // Validasi wajib: Pengembalian hanya untuk transaksi aktif
        if (!t.isStatusAktif()) {
            throw new ValidasiException("PC sudah dikembalikan sebelumnya.");
        }

        // Tutup transaksi
        t.setStatusAktif(false);
        transaksiRepo.save(t);

        // Kembalikan status PC jadi TERSEDIA
        Pc pc = t.getPc();
        pc.setStatus("TERSEDIA");
        pcRepo.save(pc);
    }

    // Fungsi untuk mengambil data yang akan ditampilkan di web
    public List<Transaksi> getSemuaTransaksi() {
        return transaksiRepo.findAll();
    }
    
    public List<Pc> getSemuaPc() {
        return pcRepo.findAll();
    }
}
