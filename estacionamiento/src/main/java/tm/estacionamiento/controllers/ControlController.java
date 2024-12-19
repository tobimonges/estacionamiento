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
    public ResponseEntity<ControlModel> entrada(@RequestParam String matriculaVehiculo) {
        try {
            ControlModel entrada = controlService.entrada(matriculaVehiculo);
            return ResponseEntity.ok(entrada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/salida")
    public ResponseEntity<ControlModel> salida(@RequestParam String matriculaVehiculo) {
        try {
            ControlModel salida = controlService.salida(matriculaVehiculo);
            return ResponseEntity.ok(salida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
