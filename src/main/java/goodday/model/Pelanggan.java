package goodday.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pelanggan {
    @Id
    private int idPelanggan;
    private String namaPelanggan;
    private String alamatPelanggan;
    private String telpPelanggan;
    private String emailPelanggan;

    // Constructors, getters, and setters
}