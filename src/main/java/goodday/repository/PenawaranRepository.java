package goodday.repository;

import goodday.model.Penawaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenawaranRepository extends JpaRepository<Penawaran, Integer> {
    // Tambahan metode repository khusus jika diperlukan
}