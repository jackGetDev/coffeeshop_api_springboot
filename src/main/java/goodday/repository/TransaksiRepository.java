package goodday.repository;

import goodday.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
    // Tambahan metode repository khusus jika diperlukan
}