package com.neoris.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "identificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClienteEntity extends PersonaEntity {
	
	@Column(name="IdCliente",length = 10)
	private int idCliente;
	
	@Column(name="Contrasena", length = 30)
	private String contrasena;
	
	@Column(name="Estado", length = 30)
	private String estado;

}
