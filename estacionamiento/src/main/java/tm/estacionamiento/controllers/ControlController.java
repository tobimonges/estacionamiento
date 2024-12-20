package tm.estacionamiento.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tm.estacionamiento.models.ControlModel;
import tm.estacionamiento.services.ControlService;

@RestController
@RequestMapping("/api/acceso")
public class ControlController {
    private final ControlService controlService;

    public ControlController(ControlService controlService) {
        this.controlService = controlService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<ControlModel> entrada(@RequestParam String matricula) {
        try {
            ControlModel entrada = controlService.entrada(matricula);
            return ResponseEntity.ok(entrada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/salida")
    public ResponseEntity<ControlModel> salida(@RequestParam String matricula) {
        try {
            ControlModel salida = controlService.salida(matricula);
            return ResponseEntity.ok(salida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
