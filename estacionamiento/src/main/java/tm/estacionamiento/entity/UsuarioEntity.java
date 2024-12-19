package tm.estacionamiento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

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
