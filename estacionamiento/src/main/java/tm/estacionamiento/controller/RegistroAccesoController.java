package tm.estacionamiento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tm.estacionamiento.entity.RegistroAccesoEntity;
import tm.estacionamiento.service.RegistroAccesoService;

@RestController
@RequestMapping("/api/acceso")
public class RegistroAccesoController {
    private final RegistroAccesoService registroAccesoService;

    public RegistroAccesoController(RegistroAccesoService registroAccesoService) {
        this.registroAccesoService = registroAccesoService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<RegistroAccesoEntity> registrarEntrada(@RequestParam String matriculaVehiculo) {
        try {
            RegistroAccesoEntity registroEntrada = registroAccesoService.registroEntrada(matriculaVehiculo);
            return ResponseEntity.ok(registroEntrada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/salida")
    public ResponseEntity<RegistroAccesoEntity> registrarSalida(@RequestParam String matriculaVehiculo) {
        try {
            RegistroAccesoEntity registroSalida = registroAccesoService.registroSalida(matriculaVehiculo);
            return ResponseEntity.ok(registroSalida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
