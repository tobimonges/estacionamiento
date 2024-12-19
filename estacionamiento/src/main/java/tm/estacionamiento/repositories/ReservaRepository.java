package tm.estacionamiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.models.ReservaModel;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {
    List<ReservaModel> findBySector(String sector, LocalDateTime fechaActual, String estado);
}
