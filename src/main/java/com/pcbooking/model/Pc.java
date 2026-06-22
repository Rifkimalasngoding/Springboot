package com.pcbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pc {
    @Id
    private String kodePC;
    private String status; // TERSEDIA, DIPINJAM, MAINTENANCE

    public Pc() {}
    public Pc(String kodePC, String status) {
        this.kodePC = kodePC;
        this.status = status;
    }

    public String getKodePC() { return kodePC; }
    public void setKodePC(String kodePC) { this.kodePC = kodePC; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
