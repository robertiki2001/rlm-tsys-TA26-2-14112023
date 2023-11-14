package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table (name = "proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String nombre;
	private String horas;
	
	@OneToMany
    @JoinColumn(name="dni")
	private List<Asignado> asignado;
	
	  public Proyecto() {
	    }
	  
	    public Proyecto(String id, String nombre, String horas, List<Asignado> asignado) {
	    	this.id = id;
	        this.nombre = nombre;	
	        this.horas = horas;	
	        this.asignado = asignado;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getHoras() {
			return horas;
		}

		public void setHoras(String horas) {
			this.horas = horas;
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