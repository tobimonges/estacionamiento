package tm.estacionamiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.models.PermisoModel;
@Repository
public interface PermisoRepository extends JpaRepository<PermisoModel, Long> {
    boolean existsByUsuarioId(Long usuarioId);
}
