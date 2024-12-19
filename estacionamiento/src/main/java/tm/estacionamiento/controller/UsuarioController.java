package tm.estacionamiento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.estacionamiento.entity.UsuarioEntity;
import tm.estacionamiento.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public ResponseEntity<UsuarioEntity> registrarUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity newUsuario = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok(newUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
