package com.neoris.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
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

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
}
