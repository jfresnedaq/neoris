package com.neoris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neoris.dto.ClienteDTO;
import com.neoris.entities.ClienteEntity;
import com.neoris.entities.PersonaEntity;
import com.neoris.repository.ClienteRepository;
import com.neoris.repository.PersonaRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	private ClienteRepository clienteRepo;
	private PersonaRepository personaRepo;
	
	/**
	 * Constructor inyector de dependecias
	 */
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepo, PersonaRepository personaRepo) {
		this.clienteRepo = clienteRepo;
		this.personaRepo = personaRepo;
	}

	@Override
	@Transactional
	public ClienteDTO save(ClienteDTO cliente) {
		
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setDireccion(cliente.getDireccion());
		personaEntity.setEdad(cliente.getEdad());
		personaEntity.setGenero(cliente.getGenero());
		personaEntity.setIdentificacion(cliente.getIdentificacion());
		personaEntity.setNombre(cliente.getNombre());
		personaEntity.setTelefono(cliente.getTelefono());
		
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setContrasena(cliente.getContrasena());
		clienteEntity.setEstado(cliente.isEstado());
		clienteEntity.setPersona(personaEntity);
	
		personaRepo.save(personaEntity);
		clienteRepo.save(clienteEntity);

		return cliente;
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaEntity findById(int identificacion) {
		return personaRepo.findById(identificacion).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ClienteEntity findByIdClient(int identificacion) {
		return clienteRepo.getClientId(identificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonaEntity> findAll() {
		return (List<PersonaEntity>) personaRepo.findAll();
	}

	@Override
	public ClienteDTO update(ClienteDTO cliente, int id) {
		
		PersonaEntity personaActual = findById(id);
		personaActual.setNombre(cliente.getNombre());
		personaActual.setDireccion(cliente.getDireccion());
		personaActual.setTelefono(cliente.getTelefono());
		personaActual.setEdad(cliente.getEdad());
		
		ClienteEntity clienteActual = findByIdClient(id);
		clienteActual.setContrasena(cliente.getContrasena());
		clienteActual.setEstado(cliente.isEstado());
		clienteActual.setPersona(personaActual);
		
		personaRepo.save(personaActual);
		clienteRepo.save(clienteActual);
		
		return cliente;
	}

	@Override
	public void delete(int identificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
}
