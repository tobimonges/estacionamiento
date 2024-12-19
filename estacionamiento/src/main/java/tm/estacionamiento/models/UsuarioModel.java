package tm.estacionamiento.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(unique = true, nullable = false)
    private String matriculaVehiculo;

    @Column(nullable = false)
    private String marcaVehiculo;

    @Column(nullable = false)
    private String modeloVehiculo;

}
