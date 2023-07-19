package com.neoris.dto;

import java.sql.Date;

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
public class MovimientoDTO {

	private Date fecha;
	private String tipoMovimiento;
	private double valor;
	private double saldo;
	private int numeroCuenta;
	private String nombreCliente;
}
