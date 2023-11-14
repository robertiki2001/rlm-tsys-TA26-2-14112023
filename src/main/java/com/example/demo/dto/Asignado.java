package com.example.demo.dto;

import jakarta.persistence.*;

@Entity
@Table (name = "asignado_a")
public class Asignado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "dni_cientifico")
	private Cientifico cientifico;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	
	  public Asignado() {
	    }
	  
	    public Asignado(int id, Cientifico cientifico, Proyecto proyecto) {
	    	this.id = id;
	        this.cientifico = cientifico;
	        this.proyecto = proyecto;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Cientifico getCientifico() {
			return cientifico;
		}

		public void setCientifico(Cientifico cientifico) {
			this.cientifico = cientifico;
		}

		public Proyecto getProyecto() {
			return proyecto;
		}

		public void setProyecto(Proyecto proyecto) {
			this.proyecto = proyecto;
		}
	    
	   
}