package tm.estacionamiento.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class ReservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private LocalDateTime fechaHoraReserva;

    @Column(nullable = false)
    private int duracionHoras;

    @Column(nullable = false)
    private String estado; // ACTIVA, CANCELADA, VENCIDA

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(LocalDateTime fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ReservaModel(Long id, UsuarioModel usuario, String sector, String matricula, LocalDateTime fechaHoraReserva, int duracionHoras, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.sector = sector;
        this.matricula = matricula;
        this.fechaHoraReserva = fechaHoraReserva;
        this.duracionHoras = duracionHoras;
        this.estado = estado;
    }

    public ReservaModel() {
    }
}
