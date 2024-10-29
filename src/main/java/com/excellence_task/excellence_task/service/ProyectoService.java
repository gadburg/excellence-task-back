package com.excellence_task.excellence_task.service;

import com.excellence_task.excellence_task.model.Proyecto;
import com.excellence_task.excellence_task.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> obtenerProyectosPorUsuario(Long usuarioId) {
        return proyectoRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
