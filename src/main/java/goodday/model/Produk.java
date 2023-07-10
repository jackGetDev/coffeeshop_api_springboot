package goodday.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produk {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduk;
    private String namaProduk;
    private String deskripsiProduk;
    private double hargaProduk;
    private int stokProduk;

    // Konstruktor, konstruktor tambahan, dan metode lain...
}