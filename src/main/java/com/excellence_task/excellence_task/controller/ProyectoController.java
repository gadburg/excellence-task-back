package com.excellence_task.excellence_task.controller;

import com.excellence_task.excellence_task.model.Proyecto;
import com.excellence_task.excellence_task.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    // Crear un nuevo proyecto
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoService.crearProyecto(proyecto);
        return ResponseEntity.ok(nuevoProyecto);
    }

    // Obtener todos los proyectos de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Proyecto>> obtenerProyectosPorUsuario(@PathVariable Long usuarioId) {
        List<Proyecto> proyectos = proyectoService.obtenerProyectosPorUsuario(usuarioId);
        if (!proyectos.isEmpty()) {
            return ResponseEntity.ok(proyectos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Obtener proyecto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Optional<Proyecto> proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto.isPresent()) {
            return ResponseEntity.ok(proyecto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar proyecto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}