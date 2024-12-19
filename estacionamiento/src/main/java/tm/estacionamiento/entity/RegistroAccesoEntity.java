package tm.estacionamiento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "registro_acceso")
public class RegistroAccesoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String matriculaVehiculo;

    @Column(nullable = false)
    private LocalDateTime fechaHoraEntrada;

    @Column(nullable = false)
    private LocalDateTime fechaHoraSalida;

    @Column(nullable = false)
    private String estado;
}
