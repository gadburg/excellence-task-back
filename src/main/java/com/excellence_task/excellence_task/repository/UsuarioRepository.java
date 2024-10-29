package com.excellence_task.excellence_task.repository;

import com.excellence_task.excellence_task.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}