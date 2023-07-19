package com.neoris.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import com.neoris.dto.MovimientoDTO;
import com.neoris.entities.CuentaEntity;
import com.neoris.entities.MovimientoEntity;
import com.neoris.service.ICuentaService;
import com.neoris.service.IMovimientosService;

/**
 * Clase controladora que expone los metodos correspondientes al servicio
 * prueba-neoris
 * 
 * @author Paola Fresneda
 */

@RestController
@RequestMapping(value = "/movimientos")
public class MovimientosController {

	private IMovimientosService movimientoService;
	private ICuentaService cuentaService;

	public MovimientosController(IMovimientosService movimientoService, ICuentaService cuentaService) {
		this.movimientoService = movimientoService;
		this.cuentaService = cuentaService;
	}

	// Crear movimiento
	@PostMapping("/crear")
	public ResponseEntity<MovimientoEntity> create(@RequestBody MovimientoDTO movimiento) throws Exception {

		double result = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		// Buscar Cuenta
		CuentaEntity cuenta = cuentaService.findById(movimiento.getNumeroCuenta());

		if (cuenta == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No se encuentra el número de cuenta: " + movimiento.getNumeroCuenta());
		}

		// Validacion debito o credito
		if (movimiento.getTipoMovimiento().equalsIgnoreCase("Debito")) {
			if (cuenta.getSaldoInicial() > 0) {
				// Resta del retiro
				result = cuenta.getSaldoInicial() - movimiento.getValor();
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Saldo no disponible: " + cuenta.getSaldoInicial());
			}
		} else if (movimiento.getTipoMovimiento().equalsIgnoreCase("Credito")) {
			// Suma el credito agregado a la cuenta
			result = cuenta.getSaldoInicial() + movimiento.getValor();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No existe un movimiento de ese tipo: " + movimiento.getTipoMovimiento());
		}

		// Actualiza el saldo incial de la cuenta
		cuenta.setSaldoInicial(result);
		cuentaService.update(cuenta, movimiento.getNumeroCuenta());

		MovimientoEntity movimientoOb = new MovimientoEntity();
		movimientoOb.setCuenta(cuenta);
		movimientoOb.setFecha(simpleDateFormat.format(new Date()));
		movimientoOb.setTipoMovimiento(movimiento.getTipoMovimiento());
		movimientoOb.setValor(movimiento.getValor());
		movimientoOb.setSaldo(result);

		return new ResponseEntity<MovimientoEntity>(movimientoService.save(movimientoOb), HttpStatus.CREATED);
	}

	// Buscar todos
	@GetMapping("/todos")
	public List<MovimientoEntity> getAll() {
		return movimientoService.findAll();
	}

	// Buscar por movimiento
	@GetMapping("/{movimiento}")
	public MovimientoEntity getId(@PathVariable int movimiento) {
		return movimientoService.findById(movimiento);
	}

	// Actualizar el movimiento
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<MovimientoEntity> update(@RequestBody MovimientoDTO movimiento, @PathVariable int id) {

		double result = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		// Buscar Cuenta
		MovimientoEntity movimientoActual = movimientoService.findById(id);

		// Validacion debito o credito
		if (movimiento.getTipoMovimiento().equalsIgnoreCase("Debito")) {
			if (movimientoActual.getCuenta().getSaldoInicial() > 0) {
				// Resta del retiro
				result = movimientoActual.getCuenta().getSaldoInicial() - movimiento.getValor();
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Saldo no disponible: " + movimientoActual.getCuenta().getSaldoInicial());
			}
		} else if (movimiento.getTipoMovimiento().equalsIgnoreCase("Credito")) {
			// Suma el credito agregado a la cuenta
			result = movimientoActual.getCuenta().getSaldoInicial() + movimiento.getValor();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No existe un movimiento de ese tipo: " + movimiento.getTipoMovimiento());
		}

		MovimientoEntity movimientoOb = new MovimientoEntity();
		movimientoOb.setCuenta(movimientoActual.getCuenta());
		movimientoOb.setFecha(simpleDateFormat.format(new Date()));
		movimientoOb.setTipoMovimiento(movimiento.getTipoMovimiento());
		movimientoOb.setValor(movimiento.getValor());
		movimientoOb.setSaldo(result);

		return new ResponseEntity<MovimientoEntity>(movimientoService.update(movimientoOb, id), HttpStatus.ACCEPTED);
	}

	// Eliminar el movimiento
	@DeleteMapping("/{movimiento}")
	public void delete(@PathVariable int movimiento) {
		movimientoService.delete(movimiento);
	}
}
