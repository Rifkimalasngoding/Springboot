package com.pcbooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pc pc;

    @ManyToOne
    private Peminjam peminjam;

    private LocalDateTime waktuMulai;
    private int durasiJam;
    private String keperluan;
    private boolean statusAktif; // true = sedang dipinjam, false = sudah dikembalikan

    // Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Pc getPc() { return pc; }
    public void setPc(Pc pc) { this.pc = pc; }
    public Peminjam getPeminjam() { return peminjam; }
    public void setPeminjam(Peminjam peminjam) { this.peminjam = peminjam; }
    public LocalDateTime getWaktuMulai() { return waktuMulai; }
    public void setWaktuMulai(LocalDateTime waktuMulai) { this.waktuMulai = waktuMulai; }
    public int getDurasiJam() { return durasiJam; }
    public void setDurasiJam(int durasiJam) { this.durasiJam = durasiJam; }
    public String getKeperluan() { return keperluan; }
    public void setKeperluan(String keperluan) { this.keperluan = keperluan; }
    public boolean isStatusAktif() { return statusAktif; }
    public void setStatusAktif(boolean statusAktif) { this.statusAktif = statusAktif; }
}
