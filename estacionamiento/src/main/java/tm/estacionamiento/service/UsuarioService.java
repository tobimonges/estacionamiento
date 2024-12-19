package tm.estacionamiento.service;

import org.springframework.stereotype.Service;
import tm.estacionamiento.entity.UsuarioEntity;
import tm.estacionamiento.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity registrarUsuario(UsuarioEntity usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        return usuarioRepository.save(usuario);
    }
}
