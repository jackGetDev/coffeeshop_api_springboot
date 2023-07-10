package goodday.controller;

import goodday.model.Produk;
import goodday.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {
    private final ProdukRepository produkRepository;

    @Autowired
    public ProdukController(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;
    }

    @GetMapping
    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produk getProdukById(@PathVariable int id) {
        return produkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk not found with id: " + id));
    }

    @PostMapping
    public Produk createProduk(@RequestBody Produk produk) {
        return produkRepository.save(produk);
    }

    @PutMapping("/{id}")
    public Produk updateProduk(@PathVariable int id, @RequestBody Produk produkDetails) {
        Produk produk = produkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk not found with id: " + id));

        produk.setNamaProduk(produkDetails.getNamaProduk());
        produk.setDeskripsiProduk(produkDetails.getDeskripsiProduk());
        produk.setHargaProduk(produkDetails.getHargaProduk());
        produk.setStokProduk(produkDetails.getStokProduk());

        return produkRepository.save(produk);
    }

    @DeleteMapping("/{id}")
    public void deleteProduk(@PathVariable int id) {
        Produk produk = produkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk not found with id: " + id));

        produkRepository.delete(produk);
    }
}
