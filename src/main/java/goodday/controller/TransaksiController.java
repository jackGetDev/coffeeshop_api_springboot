package goodday.controller;
import goodday.model.Pelanggan;
import goodday.model.Produk;
import goodday.model.Transaksi;
import goodday.repository.TransaksiRepository;
import goodday.repository.PelangganRepository;
import goodday.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {
    private final TransaksiRepository transaksiRepository;
    private final PelangganRepository pelangganRepository;
    private final ProdukRepository produkRepository; // Tambahkan deklarasi repository Produk

    public TransaksiController(TransaksiRepository transaksiRepository, PelangganRepository pelangganRepository, ProdukRepository produkRepository) {
        this.transaksiRepository = transaksiRepository;
        this.pelangganRepository = pelangganRepository;
        this.produkRepository = produkRepository; // Inisialisasi repository Produk
    }
    @GetMapping
    public List<TransaksiDTO> getAllTransaksi() {
        List<Transaksi> transaksiList = transaksiRepository.findAll();
        return transaksiList.stream()
                .map(TransaksiDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Transaksi getTransaksiById(@PathVariable int id) {
        return transaksiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi not found with id: " + id));
    }

    @PostMapping
    public Transaksi createTransaksi(@RequestBody Transaksi transaksi) {
        if (transaksi.getPelanggan() == null || transaksi.getProduk() == null) {
            throw new RuntimeException("Pelanggan dan Produk tidak boleh kosong");
        }

        Pelanggan pelanggan = pelangganRepository.findById(transaksi.getPelanggan().getIdPelanggan())
                .orElseThrow(() -> new RuntimeException("Pelanggan dengan ID tersebut tidak ditemukan"));
        Produk produk = produkRepository.findById(transaksi.getProduk().getIdProduk())
                .orElseThrow(() -> new RuntimeException("Produk dengan ID tersebut tidak ditemukan"));

        transaksi.setPelanggan(pelanggan);
        transaksi.setProduk(produk);

        return transaksiRepository.save(transaksi);
    }



    @PutMapping("/{id}")
    public Transaksi updateTransaksi(@PathVariable int id, @RequestBody Transaksi transaksiDetails) {
        Transaksi transaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi not found with id: " + id));

        transaksi.setPelanggan(transaksiDetails.getPelanggan());
        transaksi.setProduk(transaksiDetails.getProduk());
        transaksi.setTanggalTransaksi(transaksiDetails.getTanggalTransaksi());
        transaksi.setHargaTransaksi(transaksiDetails.getHargaTransaksi());
        transaksi.setMetodePembayaran(transaksiDetails.getMetodePembayaran());

        return transaksiRepository.save(transaksi);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaksi(@PathVariable int id) {
        Transaksi transaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi not found with id: " + id));

        transaksiRepository.delete(transaksi);
    }
}