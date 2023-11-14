package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Cientifico;


public interface ICientificoService {
	
		//Listar todos
		public List<Cientifico> listarCientificos();
		
		//Listar por id
		public Optional<Cientifico> getCientificoXID(String dni); 
		
		//Guardar
		public Cientifico guardarCientifico(Cientifico cientifico);
		
		//Actualizar
		public Cientifico actualizarCientifico(Cientifico cientifico);
		
		//Eliminar
		public void eliminarCientifico(String dni);

}