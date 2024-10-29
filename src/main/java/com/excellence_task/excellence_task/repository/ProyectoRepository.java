package com.excellence_task.excellence_task.repository;

import com.excellence_task.excellence_task.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByUsuarioId(Long usuarioId);
}
