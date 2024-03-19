package com.refrifresh.source.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.refrifresh.source.entity.Tecnic;

public interface TecnicRepository extends JpaRepository<Tecnic, Integer>{
	
	Optional<Tecnic> findByIdTecnico (int idTecnico);
	@Query(value = "SELECT * FROM tb_tecnico WHERE act_tecnico = 'Activo'", nativeQuery = true)
	Optional<List<Tecnic>> getActive();
	@Query(value = "SELECT * FROM tb_tecnico WHERE act_tecnico = 'Inactivo'", nativeQuery = true)
	Optional<List<Tecnic>> getInactive();

}
