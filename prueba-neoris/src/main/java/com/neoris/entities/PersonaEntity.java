package com.neoris.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonaEntity {
	
	@Id
	@Column(name="Identificacion",length = 10)
	private int identificacion;
	
	@Column(name="Nombre", length = 30)
	private String nombre;

	@Column(name="Genero", length = 10)
	private String genero;
	
	@Column(name="Edad", length = 2)
	private int edad;
	
	@Column(name="Direccion", length = 80)
	private String direccion;
	
	@Column(name="Telefono", length = 20)
	private int Telefono;
}
