package goodday.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Transaksi {
    @Id
    private int idTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", foreignKey = @ForeignKey(name = "fk_transaksi_pelanggan"))
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_produk", foreignKey = @ForeignKey(name = "fk_transaksi_produk"))
    private Produk produk;

    private Date tanggalTransaksi;
    private double hargaTransaksi;
    private String metodePembayaran;

    // Constructors, getters, and setters

    public Integer getIdPelanggan() {
        if (pelanggan != null) {
            return pelanggan.getIdPelanggan();
        }
        return null;
    }
    public Integer getIdProduk() {
        if (produk != null) {
            return produk.getIdProduk();
        }
        return null;
    }
}