package com.pcbooking.ui;

import com.pcbooking.service.TransaksiService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final TransaksiService transaksiService;

    public DashboardController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @PostConstruct
    public void init() {
        transaksiService.initDataAwal();
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("listTransaksi", transaksiService.getSemuaTransaksi());
        return "dashboard"; 
    }

    @GetMapping("/list-pc")
    public String tampilkanListPc(Model model) {
        model.addAttribute("listPc", transaksiService.getSemuaPc());
        return "list-pc"; 
    }

    @GetMapping("/form-peminjaman")
    public String tampilkanForm(Model model) {
        model.addAttribute("listPc", transaksiService.getSemuaPc());
        return "form-peminjaman"; 
    }
}
