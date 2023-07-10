package goodday.controller;

import goodday.model.Pelanggan;
import goodday.repository.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    private final PelangganRepository pelangganRepository;

    @Autowired
    public PelangganController(PelangganRepository pelangganRepository) {
        this.pelangganRepository = pelangganRepository;
    }

    @GetMapping
    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pelanggan getPelangganById(@PathVariable int id) {
        return pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan not found with id: " + id));
    }

    @PostMapping
    public Pelanggan createPelanggan(@RequestBody Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    @PutMapping("/{id}")
    public Pelanggan updatePelanggan(@PathVariable int id, @RequestBody Pelanggan pelangganDetails) {
        Pelanggan pelanggan = pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan not found with id: " + id));

        pelanggan.setNamaPelanggan(pelangganDetails.getNamaPelanggan());
        pelanggan.setAlamatPelanggan(pelangganDetails.getAlamatPelanggan());
        pelanggan.setTelpPelanggan(pelangganDetails.getTelpPelanggan());
        pelanggan.setEmailPelanggan(pelangganDetails.getEmailPelanggan());

        return pelangganRepository.save(pelanggan);
    }

    @DeleteMapping("/{id}")
    public void deletePelanggan(@PathVariable int id) {
        Pelanggan pelanggan = pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan not found with id: " + id));

        pelangganRepository.delete(pelanggan);
    }
}