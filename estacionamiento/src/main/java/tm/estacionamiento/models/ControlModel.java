package tm.estacionamiento.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "registro_acceso")
public class ControlModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String matricula;

    @Column(nullable = false)
    private LocalDateTime fechaHoraEntrada;

    @Column(nullable = false)
    private LocalDateTime fechaHoraSalida;

    @Column(nullable = false)
    private String estado; // ENTRADA o SALIDA

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ControlModel(Long id, String matricula, LocalDateTime fechaHoraEntrada, LocalDateTime fechaHoraSalida, String estado) {
        this.id = id;
        this.matricula = matricula;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.estado = estado;
    }

    public ControlModel() {
    }


}
