package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Proyecto;
import com.example.demo.services.ProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;

	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos() {
		return proyectoService.listarProyectos();
	}
	
	@GetMapping("/proyecto/{id}")
	public ResponseEntity<Proyecto> proyectoXID(@PathVariable(name = "id") String id) {
		Optional<Proyecto> proyecto = proyectoService.getProyectoXID(id);
		if (proyecto.isPresent()) {
			return ResponseEntity.ok(proyecto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/proyecto")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.guardarProyecto(proyecto);
	}
	
	@PutMapping("/proyecto/{id}")
	public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable(name = "id") String id, @RequestBody Proyecto proyecto) {

		Optional<Proyecto> proyecto_seleccionado = proyectoService.getProyectoXID(id);

	    if (proyecto_seleccionado.isPresent()) {
	    	Proyecto proyecto_existente = proyecto_seleccionado.get();
	    	 
	    	if (proyecto.getNombre() != null) {
	    		proyecto_existente.setNombre(proyecto.getNombre());
		        }
	    	if (proyecto.getHoras() != null) {
	    		proyecto_existente.setHoras(proyecto.getHoras());
		        }    	

	    	Proyecto proyecto_actualizado = proyectoService.actualizarProyecto(proyecto_existente);

	        return ResponseEntity.ok(proyecto_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/proyecto/{id}")
	public ResponseEntity<Void> eliminarProyecto(@PathVariable(name = "id") String id) {
		Optional<Proyecto> proyecto = proyectoService.getProyectoXID(id);
		if (proyecto.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
