package com.neoris.entities;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@Column(length=36)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="tipo_movimiento", length = 30)
	private String tipoMovimiento;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="saldo")
	private double saldo;
	
}
