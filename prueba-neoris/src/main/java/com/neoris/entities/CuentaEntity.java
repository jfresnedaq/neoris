package com.neoris.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CuentaEntity {
	
	@Id
	@Column(name="numero_cuenta",length = 20)
	private int numeroCuenta;
	
	@Column(name="tipo_cuenta", length = 30)
	private String tipoCuenta;
	
	@Column(name="saldo_inicial")
	private double saldoInicial;
	
	@Column(name="Estado")
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "identificacion")
	private ClienteEntity cliente;
}
