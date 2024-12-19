package tm.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.entity.EspacioEstacionamientoEntity;

import java.util.List;

@Repository
public interface EspacioEstacionamientoRepository extends JpaRepository<EspacioEstacionamientoEntity, Long> {
    List<EspacioEstacionamientoEntity> findBySectorAndOcupadoFalse(String sector);
    long countBySectorAndOcupadoFalse(String sector);
    long countBySectorAndOcupadoTrue(String sector);
}
