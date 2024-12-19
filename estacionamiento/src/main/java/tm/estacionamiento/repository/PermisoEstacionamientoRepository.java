package tm.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.estacionamiento.entity.PermisoEstacionamientoEntity;
@Repository
public interface PermisoEstacionamientoRepository extends JpaRepository<PermisoEstacionamientoEntity, Long> {
    boolean existsByUsuarioId(Long usuarioId);
}
