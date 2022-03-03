package com.example.demo02.servicio;

import com.example.demo02.modelo.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsuarioModel, Long>{
    
}
