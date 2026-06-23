# Sistem Peminjaman PC Lab

Proyek Tugas Mata Kuliah PBO (Pemrograman Berorientasi Objek) - Web Java (Spring Boot)

## Teknologi yang Digunakan
* **Backend:** Java 17, Spring Boot 3.x, Spring Data JPA
* **Database:** H2 (In-Memory Database) - *Otomatis reset saat server mati*
* **Frontend:** HTML5, Thymeleaf, Bootstrap 5 (CDN), CSS & Vanilla JS

## Cara Menjalankan Aplikasi
1. Buka project menggunakan IDE (IntelliJ IDEA / Eclipse / VSCode).
2. Pastikan Maven sudah me-load semua *dependency* yang ada di `pom.xml`.
3. Jalankan file `PcbookingApplication.java`.
4. Buka browser dan akses ke: `http://localhost:8080/`

## Fitur Utama
* Validasi lengkap (Kode unik, Durasi, Pencegahan *Double Booking*, Status PC).
* Pemisahan Layer *Model, Repository, Service, Exception*, dan *Controller*.
* *Dashboard* riwayat transaksi secara *real-time*.
* *Error Handling* menggunakan `@ControllerAdvice`.
