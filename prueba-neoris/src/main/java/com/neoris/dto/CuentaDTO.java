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
public class CuentaDTO {

	private int numeroCuenta;
	private String tipoCuenta;
	private double saldoInicial;
	private boolean estado;
	private int identificacion;
}
