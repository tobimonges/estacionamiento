package tm.estacionamiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.models.ControlModel;

import java.util.Optional;

@Repository
public interface ControlRepository extends JpaRepository<ControlModel, Long> {
    Optional<ControlModel> findByMatricula(String matricula);

    String matriculaVehiculo(String matriculaVehiculo);
}
