package tm.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.entity.RegistroAccesoEntity;

import java.util.Optional;

@Repository
public interface RegistroAccesoRepository extends JpaRepository<RegistroAccesoEntity, Long> {
    Optional<RegistroAccesoEntity> findByMatriculaVehiculoAndFechaHoraSalidaIsNull(String matricula);

    String matriculaVehiculo(String matriculaVehiculo);
}
