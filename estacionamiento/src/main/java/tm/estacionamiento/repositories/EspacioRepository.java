package tm.estacionamiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.models.EspacioModel;

import java.util.List;

@Repository
public interface EspacioRepository extends JpaRepository<EspacioModel, Long> {
    List<EspacioModel> findBySectorAndOcupadoFalse(String sector);
    long countBySectorAndOcupadoFalse(String sector);
    long countBySectorAndOcupadoTrue(String sector);
}
