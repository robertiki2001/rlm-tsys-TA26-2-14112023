package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table (name = "cientificos")
public class Cientifico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;
	private String nomApels;
	
	@OneToMany
    @JoinColumn(name="dni")
	private List<Asignado> asignado;
	
	  public Cientifico() {
	    }
	  
	    public Cientifico(String dni, String nomApels, List<Asignado> asignado) {
	    	this.dni = dni;
	        this.nomApels = nomApels;	 
	        this.asignado = asignado;
	    }

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNomApels() {
			return nomApels;
		}

		public void setNomApels(String nomApels) {
			this.nomApels = nomApels;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
		public List<Asignado> getAsignado() {
			return asignado;
		}

		public void setAsignado(List<Asignado> asignado) {
			this.asignado = asignado;
		}
	   
}