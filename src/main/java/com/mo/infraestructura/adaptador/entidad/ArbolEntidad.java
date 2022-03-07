package com.mo.infraestructura.adaptador.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "arbol")
@Getter
@Setter
public class ArbolEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fila; 

	@Column
	private Integer id;
	
	@Column
	private Integer valor; 
	
	@Column
	private Integer padre;
	
}
