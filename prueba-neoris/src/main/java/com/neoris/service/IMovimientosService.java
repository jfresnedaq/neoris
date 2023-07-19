package com.neoris.service;

import java.util.List;

import com.neoris.entities.MovimientoEntity;

public interface IMovimientosService {
	
	public MovimientoEntity save (MovimientoEntity movimiento);
	public MovimientoEntity findById (int movimiento);
	public List<MovimientoEntity> findAll ();
	public MovimientoEntity update (MovimientoEntity movimiento, int id);
	public void delete(int movimiento);

}
