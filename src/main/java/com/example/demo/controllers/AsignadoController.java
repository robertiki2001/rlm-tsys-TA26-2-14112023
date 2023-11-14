package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Asignado;
import com.example.demo.services.AsignadoService;

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoService asignadoService;

	@GetMapping("/asignados")
	public List<Asignado> listarAsignados() {
		return asignadoService.listarAsignados();
	}

	@GetMapping("/asignado/{id}")
	public Asignado asignadoXID(@PathVariable(name = "id") Integer id) {
		return asignadoService.asignadoXID(id);
	}

	@PostMapping("/asignado")
	public Asignado guardarAsignado(@RequestBody Asignado asignado) {
		return asignadoService.guardarAsignado(asignado);
	}

	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name = "id") Integer id, @RequestBody Asignado asignado) {

		Asignado asignado_seleccionado = asignadoService.asignadoXID(id);
		Asignado asignado_actualizado = new Asignado();
		
		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getProyecto());

		asignado_actualizado = asignadoService.actualizarAsignado(asignado_seleccionado);

		return asignado_actualizado;
	}

	@DeleteMapping("/asignado/{id}")
	public void eliminarAsignado(@PathVariable Integer id) {
		asignadoService.eliminarAsignado(id);
	}

}
