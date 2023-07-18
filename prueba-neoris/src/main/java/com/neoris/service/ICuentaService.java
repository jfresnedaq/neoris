package com.neoris.service;

import java.util.List;

import com.neoris.entities.CuentaEntity;


public interface ICuentaService {
	
	public CuentaEntity save (CuentaEntity cuenta);
	public CuentaEntity findById (int identificacion);
	public List<CuentaEntity> findAll ();
	public CuentaEntity update (CuentaEntity cuenta, int id);
	public void delete(int numeroCuenta);

}
