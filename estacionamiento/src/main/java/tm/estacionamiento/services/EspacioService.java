package tm.estacionamiento.services;

import org.springframework.stereotype.Service;
import tm.estacionamiento.models.EspacioModel;
import tm.estacionamiento.repositories.EspacioRepository;

import java.util.List;

@Service
public class EspacioService {
    private final EspacioRepository espacioRepository;

    public EspacioService(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public List<EspacioModel> obtenerEspacioDisponiblePorSector(String sector) {
        return espacioRepository.findBySectorAndOcupadoFalse(sector);
    }

    public long contarEspaciosDisponibles(String sector) {
        return espacioRepository.countBySectorAndOcupadoFalse(sector);
    }

    public long contarEspaciosOcupados(String sector) {
        return espacioRepository.countBySectorAndOcupadoTrue(sector);
    }

    public void ocuparEspacio(String matriculaVehiculo) {
        EspacioModel espacioDisponible = espacioRepository.findBySectorAndOcupadoFalse("Sector A")
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No hay espacios en este sector."));
        espacioDisponible.setOcupado(true);
        espacioDisponible.setMatriculaVehiculo(matriculaVehiculo);
        espacioRepository.save(espacioDisponible);
    }

    public void liberarEspacio(String matriculaVehiculo) {
        EspacioModel espacioOcupado = espacioRepository.findAll().stream()
                .filter(espacio -> matriculaVehiculo.equals(espacio.getMatriculaVehiculo()) && espacio.isOcupado())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontro un espacio ocupado por este vehiculo."));
        espacioOcupado.setOcupado(false);
        espacioOcupado.setMatriculaVehiculo(null);
        espacioRepository.save(espacioOcupado);
    }
}
