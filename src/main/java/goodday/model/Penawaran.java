package goodday.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Penawaran {
    @Id
    private int idPenawaran;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", foreignKey = @ForeignKey(name = "fk_penawaran_pelanggan"))
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_produk", foreignKey = @ForeignKey(name = "fk_penawaran_produk"))
    private Produk produk;

    private double diskon;
    private double hargaKhusus;
    private String promoLain;

    // Constructors, getters, and setters
}