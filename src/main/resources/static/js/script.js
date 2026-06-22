document.addEventListener("DOMContentLoaded", function() {
    // Fungsi untuk memunculkan konfirmasi sebelum PC dikembalikan
    const formsKembali = document.querySelectorAll('form[action^="/transaksi/kembali"]');
    
    formsKembali.forEach(form => {
        form.addEventListener('submit', function(event) {
            const konfirmasi = confirm("Apakah Anda yakin PC ini sudah dikembalikan dan dicek kelengkapannya?");
            if (!konfirmasi) {
                event.preventDefault(); // Batalkan submit jika user klik 'Cancel'
            }
        });
    });

    // Otomatis menghilangkan alert notifikasi setelah 3 detik
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.display = 'none';
        }, 3000);
    });
});
