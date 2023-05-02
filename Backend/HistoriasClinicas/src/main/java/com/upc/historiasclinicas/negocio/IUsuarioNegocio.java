package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Usuario;

import java.util.Optional;

public interface IUsuarioNegocio {
    public Usuario buscarUsuario(String email) throws Exception;
    public Optional<Usuario> getId(int id);
}
