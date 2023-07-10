package goodday.controller;

import goodday.model.Penawaran;
import goodday.repository.PenawaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/penawaran")
public class PenawaranController {
    private final PenawaranRepository penawaranRepository;

    @Autowired
    public PenawaranController(PenawaranRepository penawaranRepository) {
        this.penawaranRepository = penawaranRepository;
    }

    @GetMapping
    public List<Penawaran> getAllPenawaran() {
        return penawaranRepository.findAll();
    }

    @GetMapping("/{id}")
    public Penawaran getPenawaranById(@PathVariable int id) {
        return penawaranRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penawaran not found with id: " + id));
    }

    @PostMapping
    public Penawaran createPenawaran(@RequestBody Penawaran penawaran) {
        return penawaranRepository.save(penawaran);
    }

    @PutMapping("/{id}")
    public Penawaran updatePenawaran(@PathVariable int id, @RequestBody Penawaran penawaranDetails) {
        Penawaran penawaran = penawaranRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penawaran not found with id: " + id));

        penawaran.setPelanggan(penawaranDetails.getPelanggan());
        penawaran.setProduk(penawaranDetails.getProduk());
        penawaran.setDiskon(penawaranDetails.getDiskon());
        penawaran.setHargaKhusus(penawaranDetails.getHargaKhusus());
        penawaran.setPromoLain(penawaranDetails.getPromoLain());

        return penawaranRepository.save(penawaran);
    }

    @DeleteMapping("/{id}")
    public void deletePenawaran(@PathVariable int id) {
        Penawaran penawaran = penawaranRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penawaran not found with id: " + id));

        penawaranRepository.delete(penawaran);
    }
}