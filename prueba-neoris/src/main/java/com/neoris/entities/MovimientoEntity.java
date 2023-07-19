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
@Table(name="movimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovimientoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="saldo")
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name = "cuenta")
	private CuentaEntity cuenta;
	
}
