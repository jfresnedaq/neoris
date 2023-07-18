package com.neoris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.neoris.dto.ClienteDTO;
import com.neoris.entities.PersonaEntity;
import com.neoris.service.IClienteService;

/**
 * Clase controladora que expone los metodos correspondientes al servicio
 * prueba-neoris
 * 
 * @author Paola Fresneda
 */

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

	@Autowired
	IClienteService clienteService;

	// Crear un cliente
	@PostMapping("/crear")
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO cliente) throws Exception {
		ClienteDTO responseCliente = new ClienteDTO();
		// Validacion de si existe un id
		PersonaEntity idExist = clienteService.findById(cliente.getIdentificacion());

		if (!(idExist == null)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"El usuario ya existe con el número de identificación: " + cliente.getIdentificacion());
		} else {
			responseCliente = clienteService.save(cliente);
		}

		return new ResponseEntity<ClienteDTO>(responseCliente, HttpStatus.CREATED);
	}

	// Buscar todos
	@GetMapping("/todos")
	public List<PersonaEntity> getAll() {
		return clienteService.findAll();
	}

	// Buscar por identificación
	@GetMapping("/{id}")
	public PersonaEntity getId(@PathVariable int id) {
		return clienteService.findById(id);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO cliente, @PathVariable int id) {
		
		ClienteDTO responseCliente = clienteService.update(cliente, id);
		
		return new ResponseEntity<ClienteDTO>(responseCliente, HttpStatus.ACCEPTED);
	}

}
