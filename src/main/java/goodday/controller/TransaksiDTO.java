package goodday.controller;
import goodday.model.Transaksi;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransaksiDTO {
    @JsonProperty("id_transaksi")
    private int idTransaksi;

    @JsonProperty("id_pelanggan")
    private int idPelanggan;

    @JsonProperty("id_produk")
    private int idProduk;

    @JsonProperty("tanggal_transaksi")
    private Date tanggalTransaksi;

    @JsonProperty("harga_transaksi")
    private double hargaTransaksi;

    @JsonProperty("metode_pembayaran")
    private String metodePembayaran;

    public TransaksiDTO(Transaksi transaksi) {
        this.idTransaksi = transaksi.getIdTransaksi();
        this.idPelanggan = transaksi.getPelanggan().getIdPelanggan();
        this.idProduk = transaksi.getProduk().getIdProduk();
        this.tanggalTransaksi = transaksi.getTanggalTransaksi();
        this.hargaTransaksi = transaksi.getHargaTransaksi();
        this.metodePembayaran = transaksi.getMetodePembayaran();
    }

    // Getter dan setter
}
