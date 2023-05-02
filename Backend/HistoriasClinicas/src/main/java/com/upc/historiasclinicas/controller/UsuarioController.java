package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.Usuario;
import com.upc.historiasclinicas.negocio.IUsuarioNegocio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UsuarioController {

    private final IUsuarioNegocio usuarioNegocio;

    @GetMapping("/usuarioByEmail")
    public Usuario get(@RequestParam String email) throws Exception {
        return usuarioNegocio.buscarUsuario(email);
    }
}
