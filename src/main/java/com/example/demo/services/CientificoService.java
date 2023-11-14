package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoService implements ICientificoService{
	
	@Autowired
	ICientificoDAO iCientificoDAO;

		//Listar todos
		public List<Cientifico> listarCientificos(){
			return iCientificoDAO.findAll();
		};
			
		//Listar por id
		public Optional<Cientifico> getCientificoXID(String dni) {
		    return iCientificoDAO.findById(dni);
		}
		
		//Guardar
		public Cientifico guardarCientifico(Cientifico cientifico) {
			return iCientificoDAO.save(cientifico);
		};
		
		//Actualizar
		public Cientifico actualizarCientifico(Cientifico cientifico) {
			return iCientificoDAO.save(cientifico);
		};
		
		//Eliminar
		public void eliminarCientifico(String dni) {
			iCientificoDAO.deleteById(dni);
		}		

}