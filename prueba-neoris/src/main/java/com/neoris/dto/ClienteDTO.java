package com.neoris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClienteDTO {
	
	private int identificacion;
	private String nombre;
	private String genero;
	private int edad;
	private String direccion;
	private int telefono;
	private String contrasena;
	private boolean estado;

}
