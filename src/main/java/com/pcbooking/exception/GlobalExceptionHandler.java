package com.pcbooking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Menangkap error validasi dan mengirimkannya kembali ke UI
    @ExceptionHandler(ValidasiException.class)
    public String handleValidasiException(ValidasiException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/"; // Kembali ke halaman utama dengan pesan error
    }
}
