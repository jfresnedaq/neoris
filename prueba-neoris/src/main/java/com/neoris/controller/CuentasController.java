package com.neoris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.dto.CuentaDTO;
import com.neoris.entities.ClienteEntity;
import com.neoris.entities.CuentaEntity;
import com.neoris.service.IClienteService;
import com.neoris.service.ICuentaService;

/**
 * Clase controladora que expone los metodos correspondientes al servicio
 * prueba-neoris
 * 
 * @author Paola Fresneda
 */

@RestController
@RequestMapping(value = "/cuentas")
public class CuentasController {

	private ICuentaService cuentaService;
	private IClienteService clienteService;
	
	@Autowired
	public CuentasController (ICuentaService cuentaService, IClienteService clienteService) {
		this.cuentaService = cuentaService;
		this.clienteService = clienteService;
	}
	
	//Crear cuenta
	@PostMapping("/crear")
	public ResponseEntity<CuentaEntity> create(@RequestBody CuentaDTO cuenta) throws Exception {
		
		ClienteEntity cliente = clienteService.findByIdClient(cuenta.getIdentificacion());
		
		CuentaEntity cuentaOb = new CuentaEntity();
		cuentaOb.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaOb.setEstado(cuenta.isEstado());
		cuentaOb.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaOb.setTipoCuenta(cuenta.getTipoCuenta());
		cuentaOb.setCliente(cliente);
		
		return new ResponseEntity<CuentaEntity>(cuentaService.save(cuentaOb), HttpStatus.CREATED);
	}
	
	// Buscar todos
	@GetMapping("/todos")
	public List<CuentaEntity> getAll() {
		return cuentaService.findAll();
	}

	// Buscar por cuenta
	@GetMapping("/{cuenta}")
	public CuentaEntity getId(@PathVariable int cuenta) {
		return cuentaService.findById(cuenta);
	}
	
	// Actualizar la cuenta
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<CuentaEntity> update(@RequestBody CuentaEntity cuenta, @PathVariable int id) {
		return new ResponseEntity<CuentaEntity>(cuentaService.update(cuenta, id), HttpStatus.ACCEPTED);
	}
	
	//Eliminar la cuenta
	@DeleteMapping("/{cuenta}")
	public void delete (@PathVariable int cuenta) {
		cuentaService.delete(cuenta);
	}
}
