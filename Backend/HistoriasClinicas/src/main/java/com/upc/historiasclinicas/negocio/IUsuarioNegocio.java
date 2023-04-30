package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Usuario;

public interface IUsuarioNegocio {
    public Usuario buscarUsuario(String email) throws Exception;
}
