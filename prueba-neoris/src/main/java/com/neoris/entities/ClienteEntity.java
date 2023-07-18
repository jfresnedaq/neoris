package com.neoris.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Contrasena", length = 30)
	private String contrasena;
	
	@Column(name="Estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "identificacion")
	private PersonaEntity persona;
}
