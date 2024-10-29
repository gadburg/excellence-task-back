package com.excellence_task.excellence_task.service;

import com.excellence_task.excellence_task.model.Tarea;
import com.excellence_task.excellence_task.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> obtenerTareasPorProyecto(Long proyectoId) {
        return tareaRepository.findByProyectoId(proyectoId);
    }

    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}