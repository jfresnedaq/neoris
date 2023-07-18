package com.neoris.service;

import java.util.List;

import com.neoris.dto.ClienteDTO;
import com.neoris.entities.ClienteEntity;
import com.neoris.entities.PersonaEntity;

public interface IClienteService {

	public ClienteDTO save (ClienteDTO cliente);
	public PersonaEntity findById (int identificacion);
	public List<PersonaEntity> findAll ();
	public ClienteDTO update (ClienteDTO cliente, int id);
	public void delete(int identificacion);
	public ClienteEntity findByIdClient(int identificacion);
	
}
