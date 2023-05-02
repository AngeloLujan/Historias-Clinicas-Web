package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Usuario;
import com.upc.historiasclinicas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioNegocio implements IUsuarioNegocio{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarUsuario(String email) throws Exception {
        return usuarioRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe"));
    }

    @Override
    public Optional<Usuario> getId(int id) {
        return usuarioRepository.findById(id);
    }
}
