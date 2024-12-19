package tm.estacionamiento.service;

import org.springframework.stereotype.Service;
import tm.estacionamiento.entity.PermisoEstacionamientoEntity;
import tm.estacionamiento.entity.RegistroAccesoEntity;
import tm.estacionamiento.repository.PermisoEstacionamientoRepository;
import tm.estacionamiento.repository.RegistroAccesoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistroAccesoService {
    private final PermisoEstacionamientoRepository permisoEstacionamientoRepository;
    private final RegistroAccesoRepository registroAccesoRepository;

    public RegistroAccesoService (PermisoEstacionamientoRepository permisoEstacionamientoRepository, RegistroAccesoRepository registroAccesoRepository) {
        this.permisoEstacionamientoRepository = permisoEstacionamientoRepository;
        this.registroAccesoRepository = registroAccesoRepository;
    }

    public RegistroAccesoEntity registroEntrada(String matriculaVehiculo) {
        Optional<PermisoEstacionamientoEntity> permiso = permisoEstacionamientoRepository.findAll().stream()
                .filter(p -> p.getUsuario().getMatriculaVehiculo().equals(matriculaVehiculo))
                .findFirst();

        if (permiso.isEmpty()) {
            throw new IllegalArgumentException("El vehiculo no tiene un permiso de estacionamiento valido.");
        }

        RegistroAccesoEntity registroAcceso = RegistroAccesoEntity.builder()
                .matriculaVehiculo(matriculaVehiculo)
                .fechaHoraEntrada(LocalDateTime.now())
                .estado("ENTRADA")
                .build();
        return registroAccesoRepository.save(registroAcceso);
    }
    public RegistroAccesoEntity registroSalida(String matriculaVehiculo) {
        RegistroAccesoEntity registroExistente = registroAccesoRepository.findByMatriculaVehiculoAndFechaHoraSalidaIsNull(matriculaVehiculo)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro un registro de entrada para este vehiculo"));
        registroExistente.setFechaHoraSalida(LocalDateTime.now());
        registroExistente.setEstado("SALIDA");;

        return registroAccesoRepository.save(registroExistente);
    }
}
