package tm.estacionamiento.service;

import org.springframework.stereotype.Service;
import tm.estacionamiento.entity.EspacioEstacionamientoEntity;
import tm.estacionamiento.repository.EspacioEstacionamientoRepository;

import java.util.List;

@Service
public class EspacioEstacionamientoService {
    private final EspacioEstacionamientoRepository espacioEstacionamientoRepository;

    public EspacioEstacionamientoService(EspacioEstacionamientoRepository espacioEstacionamientoRepository) {
        this.espacioEstacionamientoRepository = espacioEstacionamientoRepository;
    }

    public List<EspacioEstacionamientoEntity> obtenerEspacioDisponiblePorSector(String sector) {
        return espacioEstacionamientoRepository.findBySectorAndOcupadoFalse(sector);
    }

    public long contarEspaciosDisponibles(String sector) {
        return espacioEstacionamientoRepository.countBySectorAndOcupadoFalse(sector);
    }

    public long contarEspaciosOcupados(String sector) {
        return espacioEstacionamientoRepository.countBySectorAndOcupadoTrue(sector);
    }

    public void ocuparEspacio(String matriculaVehiculo) {
        EspacioEstacionamientoEntity espacioDisponible = espacioEstacionamientoRepository.findBySectorAndOcupadoFalse("Sector A")
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No hay espacios en este sector."));
        espacioDisponible.setOcupado(true);
        espacioDisponible.setMatriculaVehiculo(matriculaVehiculo);
        espacioEstacionamientoRepository.save(espacioDisponible);
    }

    public void liberarEspacio(String matriculaVehiculo) {
        EspacioEstacionamientoEntity espacioOcupado = espacioEstacionamientoRepository.findAll().stream()
                .filter(espacio -> matriculaVehiculo.equals(espacio.getMatriculaVehiculo()) && espacio.isOcupado())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontro un espacio ocupado por este vehiculo."));
        espacioOcupado.setOcupado(false);
        espacioOcupado.setMatriculaVehiculo(null);
        espacioEstacionamientoRepository.save(espacioOcupado);
    }
}
