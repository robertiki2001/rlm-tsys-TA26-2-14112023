package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Proyecto;


public interface IProyectoService {
	
		//Listar todos
		public List<Proyecto> listarProyectos();
		
		//Listar por id
		public Optional<Proyecto> getProyectoXID(String id); 
		
		//Guardar
		public Proyecto guardarProyecto(Proyecto proyecto);
		
		//Actualizar
		public Proyecto actualizarProyecto(Proyecto proyecto);
		
		//Eliminar
		public void eliminarProyecto(String id);

}