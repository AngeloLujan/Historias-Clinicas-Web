package com.upc.historiasclinicas.security;

import com.upc.historiasclinicas.model.Usuario;
import com.upc.historiasclinicas.negocio.IUsuarioNegocio;
import com.upc.historiasclinicas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioNegocio usuarioNegocio;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = null;
        try {
            usuario = usuarioNegocio.buscarUsuario(email);
            return new UserDetailsImpl(usuario);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}