package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoDAO;
import com.example.demo.dto.Asignado;

@Service
public class AsignadoService implements IAsignadoService{
	
	@Autowired
	IAsignadoDAO iAsignadoDAO;

		//Listar todos
		public List<Asignado> listarAsignados(){
			return iAsignadoDAO.findAll();
		};
		
		//Listar por id
		public Asignado asignadoXID(Integer id) {
			return iAsignadoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Asignado guardarAsignado(Asignado asignado) {
			return iAsignadoDAO.save(asignado);
		};
		
		//Actualizar
		public Asignado actualizarAsignado(Asignado asignado) {
			return iAsignadoDAO.save(asignado);
		};
		
		//Eliminar
		public void eliminarAsignado(Integer id) {
			iAsignadoDAO.deleteById(id);
		}	

}