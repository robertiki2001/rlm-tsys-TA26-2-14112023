package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Asignado;


public interface IAsignadoService {
	
		//Listar todos
		public List<Asignado> listarAsignados();
		
		//Listar por id
		public Asignado asignadoXID(Integer id); 
		
		//Guardar
		public Asignado guardarAsignado(Asignado asignado);
		
		//Actualizar
		public Asignado actualizarAsignado(Asignado asignado);
		
		//Eliminar
		public void eliminarAsignado(Integer id);

}