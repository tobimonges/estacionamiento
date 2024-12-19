package tm.estacionamiento.service;

import org.springframework.stereotype.Service;
import tm.estacionamiento.entity.PermisoEstacionamientoEntity;
import tm.estacionamiento.entity.UsuarioEntity;
import tm.estacionamiento.repository.PermisoEstacionamientoRepository;
import tm.estacionamiento.repository.UsuarioRepository;

import java.util.List;

@Service
public class PermisoEstacionamientoService {
    private final PermisoEstacionamientoRepository permisoEstacionamientoRepository;
    private final UsuarioRepository usuarioRepository;
    public PermisoEstacionamientoService (PermisoEstacionamientoRepository permisoEstacionamientoRepository, UsuarioRepository usuarioRepository) {
        this.permisoEstacionamientoRepository = permisoEstacionamientoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PermisoEstacionamientoEntity asignarPermiso(Long usuarioId, PermisoEstacionamientoEntity permiso) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        if (permisoEstacionamientoRepository.existsByUsuarioId(usuarioId)) {
            throw new IllegalArgumentException("El usuario ya tiene un permiso asignado.");
        }
        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return permisoEstacionamientoRepository.save(permiso);
    }
    public List<PermisoEstacionamientoEntity> obtenerPermisos() {
        return permisoEstacionamientoRepository.findAll();
    }

}
