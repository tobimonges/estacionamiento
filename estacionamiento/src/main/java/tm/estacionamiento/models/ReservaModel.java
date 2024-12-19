package tm.estacionamiento.models;

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
    private String matriculaVehiculo;

    @Column(nullable = false)
    private LocalDateTime fechaHoraReserva;

    @Column(nullable = false)
    private int duracionHoras;

    @Column(nullable = false)
    private String estado; // ACTIVA, CANCELADA, VENCIDA
}
