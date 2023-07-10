package goodday.repository;

import goodday.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Integer> {
    // Tambahan metode repository khusus jika diperlukan
}