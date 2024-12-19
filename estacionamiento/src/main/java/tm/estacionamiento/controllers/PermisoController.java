package tm.estacionamiento.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tm.estacionamiento.models.PermisoModel;
import tm.estacionamiento.services.PermisoService;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {
    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @PostMapping("/{usuarioId}")
    public ResponseEntity<PermisoModel> asignarPermiso(
            @PathVariable Long usuarioId, @RequestBody PermisoModel permiso
    ) {
        try {
            PermisoModel newPermiso = permisoService.asignarPermiso(usuarioId, permiso);
            return ResponseEntity.ok(newPermiso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<PermisoModel>> obtenerPermisos() {
        return ResponseEntity.ok(permisoService.obtenerPermisos());
    }
}

