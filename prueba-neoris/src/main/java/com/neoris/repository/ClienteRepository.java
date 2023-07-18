package com.neoris.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoris.entities.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity	, Integer>{
	
	@Query(value="select * from cliente where identificacion = identificacion ", nativeQuery = true)
	ClienteEntity getClientId (int identificacion);

}
	