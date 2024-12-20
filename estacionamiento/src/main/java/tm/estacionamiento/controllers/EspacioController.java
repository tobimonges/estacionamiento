package tm.estacionamiento.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tm.estacionamiento.models.EspacioModel;
import tm.estacionamiento.services.EspacioService;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {
    private final EspacioService espacioService;

    public EspacioController(EspacioService espacioService) {
        this.espacioService = espacioService;
    }

    @GetMapping("/disponibles/{sector}")
    public ResponseEntity<List<EspacioModel>> obtenerEspaciosDisponibles (@PathVariable String sector) {
        return ResponseEntity.ok(espacioService.obtenerEspacioDisponiblePorSector(sector));
    }

    @GetMapping("/conteo/{sector}")
    public ResponseEntity<String> contarEspacios(@PathVariable String sector) {
        long disponibles = espacioService.contarEspaciosDisponibles(sector);
        long ocupados = espacioService.contarEspaciosOcupados(sector);

        return ResponseEntity.ok(String.format("Sector: %s, Disponibles: %d, Ocupados: %d", sector, disponibles, ocupados));
    }

    @PostMapping("/ocupar")
    public ResponseEntity<String> ocuparEspacio (@RequestParam String matricula) {
        try {
            espacioService.ocuparEspacio(matricula);
            return ResponseEntity.ok("Espacio ocupado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/liberar")
    public ResponseEntity<String> liberarEspacio (@RequestParam String matricula) {
        try {
            espacioService.liberarEspacio(matricula);
            return ResponseEntity.ok("Espacio liberado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}