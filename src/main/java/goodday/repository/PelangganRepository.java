package goodday.repository;

import goodday.model.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, Integer> {
    // Tambahan metode repository khusus jika diperlukan
}