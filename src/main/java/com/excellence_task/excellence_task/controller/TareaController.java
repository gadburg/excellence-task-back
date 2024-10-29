package com.excellence_task.excellence_task.controller;

import com.excellence_task.excellence_task.model.Tarea;
import com.excellence_task.excellence_task.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Crear nueva tarea
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return ResponseEntity.ok(nuevaTarea);
    }

    // Obtener todas las tareas de un proyecto
    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<List<Tarea>> obtenerTareasPorProyecto(@PathVariable Long proyectoId) {
        List<Tarea> tareas = tareaService.obtenerTareasPorProyecto(proyectoId);
        if (!tareas.isEmpty()) {
            return ResponseEntity.ok(tareas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Obtener tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.obtenerTareaPorId(id);
        if (tarea.isPresent()) {
            return ResponseEntity.ok(tarea.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar tarea por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}