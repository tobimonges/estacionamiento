package tm.estacionamiento.models;

import jakarta.persistence.*;

@Entity
@Table(name = "espacio_estacionamiento")
public class EspacioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private boolean ocupado;

    private String matricula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public EspacioModel(Long id, String sector, boolean ocupado, String matricula) {
        this.id = id;
        this.sector = sector;
        this.ocupado = ocupado;
        this.matricula = matricula;
    }

    public EspacioModel() {
    }
}
