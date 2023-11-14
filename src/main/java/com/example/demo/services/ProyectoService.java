package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoService implements IProyectoService{
	
	@Autowired
	IProyectoDAO iProyectoDAO;

		//Listar todos
		public List<Proyecto> listarProyectos(){
			return iProyectoDAO.findAll();
		};
			
		//Listar por id
		public Optional<Proyecto> getProyectoXID(String id) {
		    return iProyectoDAO.findById(id);
		}
		
		//Guardar
		public Proyecto guardarProyecto(Proyecto proyecto) {
			return iProyectoDAO.save(proyecto);
		};
		
		//Actualizar
		public Proyecto actualizarProyecto(Proyecto proyecto) {
			return iProyectoDAO.save(proyecto);
		};
		
		//Eliminar
		public void eliminarProyecto(String id) {
			iProyectoDAO.deleteById(id);
		}		

}