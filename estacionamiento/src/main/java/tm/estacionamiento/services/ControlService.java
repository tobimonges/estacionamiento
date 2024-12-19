package tm.estacionamiento.services;

import org.springframework.stereotype.Service;
import tm.estacionamiento.models.PermisoModel;
import tm.estacionamiento.models.ControlModel;
import tm.estacionamiento.repositories.PermisoRepository;
import tm.estacionamiento.repositories.ControlRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ControlService {
    private final PermisoRepository permisoRepository;
    private final ControlRepository controlRepository;

    public ControlService(PermisoRepository permisoRepository, ControlRepository controlRepository) {
        this.permisoRepository = permisoRepository;
        this.controlRepository = controlRepository;
    }

    public ControlModel entrada(String matriculaVehiculo) {
        Optional<PermisoModel> permiso = permisoRepository.findAll().stream()
                .filter(p -> p.getUsuario().getMatriculaVehiculo().equals(matriculaVehiculo))
                .findFirst();

        if (permiso.isEmpty()) {
            throw new IllegalArgumentException("El vehiculo no tiene un permiso de estacionamiento valido.");
        }

        ControlModel control = ControlModel.builder()
                .matriculaVehiculo(matriculaVehiculo)
                .fechaHoraEntrada(LocalDateTime.now())
                .estado("ENTRADA")
                .build();
        return controlRepository.save(control);
    }
    public ControlModel salida(String matriculaVehiculo) {
        ControlModel control = controlRepository.findByMatricula(matriculaVehiculo)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro un registro de entrada para este vehiculo"));
        control.setFechaHoraSalida(LocalDateTime.now());
        control.setEstado("SALIDA");;

        return controlRepository.save(control);
    }
}
