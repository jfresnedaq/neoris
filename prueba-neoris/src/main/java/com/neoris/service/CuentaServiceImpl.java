package com.neoris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neoris.entities.CuentaEntity;
import com.neoris.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {
	
	private CuentaRepository cuentaRepo;
	
	@Autowired
	public CuentaServiceImpl (CuentaRepository cuentaRepo) {
		this.cuentaRepo = cuentaRepo;
	}

	@Override
	@Transactional
	public CuentaEntity save(CuentaEntity cuenta) {
		return cuentaRepo.save(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public CuentaEntity findById(int cuenta) {
		return cuentaRepo.findById(cuenta).orElse(null);
	}

	@Override
	public List<CuentaEntity> findAll() {
		return (List<CuentaEntity>) cuentaRepo.findAll();
	}

	@Override
	public CuentaEntity update(CuentaEntity cuenta, int id) {
		CuentaEntity cuentaActual = findById(id);
		cuentaActual.setEstado(cuenta.isEstado());
		cuentaActual.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaActual.setTipoCuenta(cuenta.getTipoCuenta());
		
		return cuentaRepo.save(cuentaActual);
	}

	@Override
	public void delete(int numeroCuenta) {
		cuentaRepo.deleteById(numeroCuenta);
	}

}
