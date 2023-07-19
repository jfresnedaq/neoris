package com.neoris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neoris.entities.MovimientoEntity;
import com.neoris.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements IMovimientosService {
	
	private MovimientoRepository movimientoRepo;
	
	@Autowired
	public MovimientoServiceImpl(MovimientoRepository movimientoRepo) {
		this.movimientoRepo = movimientoRepo;
	}

	@Override
	@Transactional
	public MovimientoEntity save(MovimientoEntity movimiento) {
		return movimientoRepo.save(movimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public MovimientoEntity findById(int movimiento) {
		return movimientoRepo.findById(movimiento).orElse(null);
	}

	@Override
	public List<MovimientoEntity> findAll() {
		return (List<MovimientoEntity>) movimientoRepo.findAll();
	}

	@Override
	public MovimientoEntity update(MovimientoEntity movimiento, int id) {
		MovimientoEntity movimientoActual = findById(id);
		movimientoActual.setFecha(movimiento.getFecha());
		movimientoActual.setSaldo(movimiento.getSaldo());
		movimientoActual.setValor(movimiento.getValor());
		movimientoActual.setTipoMovimiento(movimiento.getTipoMovimiento());
		
		return movimientoRepo.save(movimientoActual);
	}

	@Override
	public void delete(int movimiento) {
		movimientoRepo.deleteById(movimiento);
	}

}
