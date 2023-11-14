package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Cientifico;
import com.example.demo.services.CientificoService;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoService cientificoService;

	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos() {
		return cientificoService.listarCientificos();
	}
	
	@GetMapping("/cientifico/{id}")
	public ResponseEntity<Cientifico> cientificoXID(@PathVariable(name = "dni") String dni) {
		Optional<Cientifico> cientifico = cientificoService.getCientificoXID(dni);
		if (cientifico.isPresent()) {
			return ResponseEntity.ok(cientifico.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/cientifico")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.guardarCientifico(cientifico);
	}
	
	@PutMapping("/cientifico/{id}")
	public ResponseEntity<Cientifico> actualizarCientifico(@PathVariable(name = "dni") String dni, @RequestBody Cientifico cientifico) {

		Optional<Cientifico> cientifico_seleccionado = cientificoService.getCientificoXID(dni);

	    if (cientifico_seleccionado.isPresent()) {
	    	Cientifico cientifico_existente = cientifico_seleccionado.get();
	    	 
	    	if (cientifico.getNomApels() != null) {
	    		cientifico_existente.setNomApels(cientifico.getNomApels());
		        }
	    	

	    	Cientifico cientifico_actualizado = cientificoService.actualizarCientifico(cientifico_existente);

	        return ResponseEntity.ok(cientifico_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/cientifico/{id}")
	public ResponseEntity<Void> eliminarCientifico(@PathVariable(name = "dni") String dni) {
		Optional<Cientifico> cientifico = cientificoService.getCientificoXID(dni);
		if (cientifico.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
