package com.refrifresh.source.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.refrifresh.source.entity.InfTecnic;

public interface InformTecnicRepository extends JpaRepository<InfTecnic, Integer>{
	
	Optional<InfTecnic> findByIdInfo(int idInfo);
	
	@Query(value = "SELECT * FROM tb_informetecnico WHERE act_maquina = 'Activo'", nativeQuery = true)
	Optional<List<InfTecnic>> getActive();
	@Query(value = "SELECT * FROM tb_informetecnico WHERE act_maquina = 'Inactivo'", nativeQuery = true)
	Optional<List<InfTecnic>> getInactive();

}
