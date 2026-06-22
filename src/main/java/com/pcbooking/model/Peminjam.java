package com.pcbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Peminjam {
    @Id
    private String nim;
    private String nama;

    public Peminjam() {}
    public Peminjam(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}
