package com.pcbooking.ui;

import com.pcbooking.service.TransaksiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    private final TransaksiService transaksiService;

    public TransaksiController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @PostMapping("/pinjam")
    public String prosesPinjam(@RequestParam String kodePC, @RequestParam String nim, 
                               @RequestParam String nama, @RequestParam int durasi, 
                               @RequestParam String keperluan, RedirectAttributes redirectAttrs) {
        transaksiService.pinjamPc(kodePC, nim, nama, durasi, keperluan);
        redirectAttrs.addFlashAttribute("successMessage", "Peminjaman berhasil dibuat!");
        return "redirect:/";
    }

    @PostMapping("/kembali/{id}")
    public String prosesKembali(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        transaksiService.kembalikanPc(id);
        redirectAttrs.addFlashAttribute("successMessage", "PC berhasil dikembalikan!");
        return "redirect:/";
    }
}
