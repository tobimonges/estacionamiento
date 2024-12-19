package tm.estacionamiento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tm.estacionamiento.entity.EspacioEstacionamientoEntity;
import tm.estacionamiento.service.EspacioEstacionamientoService;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioEstacionamientoController {
    private final EspacioEstacionamientoService espacioEstacionamientoService;

    public EspacioEstacionamientoController (EspacioEstacionamientoService espacioEstacionamientoService) {
        this.espacioEstacionamientoService = espacioEstacionamientoService;
    }

    @GetMapping("/disponibles/{sector}")
    public ResponseEntity<List<EspacioEstacionamientoEntity>> obtenerEspaciosDisponibles (@PathVariable String sector) {
        return ResponseEntity.ok(espacioEstacionamientoService.obtenerEspacioDisponiblePorSector(sector));
    }

    @GetMapping("/conteo/{sector}")
    public ResponseEntity<String> contarEspacios(@PathVariable String sector) {
        long disponibles = espacioEstacionamientoService.contarEspaciosDisponibles(sector);
        long ocupados = espacioEstacionamientoService.contarEspaciosOcupados(sector);

        return ResponseEntity.ok(String.format("Sector: %s, Disponibles: %d, Ocupados: %d", sector, disponibles, ocupados));
    }

    @PostMapping("/ocupar")
    public ResponseEntity<String> ocuparEspacio (@RequestParam String matriculaVehiculo) {
        try {
            espacioEstacionamientoService.ocuparEspacio(matriculaVehiculo);
            return ResponseEntity.ok("Espacio ocupado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/liberar")
    public ResponseEntity<String> liberarEspacio (@RequestParam String matriculaVehiculo) {
        try {
            espacioEstacionamientoService.liberarEspacio(matriculaVehiculo);
            return ResponseEntity.ok("Espacio liberado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}