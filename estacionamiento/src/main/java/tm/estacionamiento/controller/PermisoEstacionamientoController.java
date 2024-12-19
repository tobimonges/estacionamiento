package tm.estacionamiento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tm.estacionamiento.entity.PermisoEstacionamientoEntity;
import tm.estacionamiento.service.PermisoEstacionamientoService;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoEstacionamientoController {
    private final PermisoEstacionamientoService permisoEstacionamientoService;

    public PermisoEstacionamientoController(PermisoEstacionamientoService permisoEstacionamientoService) {
        this.permisoEstacionamientoService = permisoEstacionamientoService;
    }

    @PostMapping("/{usuarioId}")
    public ResponseEntity<PermisoEstacionamientoEntity> asignarPermiso(
            @PathVariable Long usuarioId, @RequestBody PermisoEstacionamientoEntity permiso
    ) {
        try {
            PermisoEstacionamientoEntity newPermiso = permisoEstacionamientoService.asignarPermiso(usuarioId, permiso);
            return ResponseEntity.ok(newPermiso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<PermisoEstacionamientoEntity>> obtenerPermisos() {
        return ResponseEntity.ok(permisoEstacionamientoService.obtenerPermisos());
    }
}

