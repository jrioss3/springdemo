package com.example.demo02.servicio;

import java.util.List;

import com.example.demo02.modelo.UsuarioModel;

public interface UserServicio {

    List<UsuarioModel> obtenerUsuarios();
    
}
