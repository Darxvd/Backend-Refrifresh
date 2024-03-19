package com.refrifresh.source.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.refrifresh.source.entity.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>{
	
	Optional<Enterprise> findByIdEmpresa(int idEnterprise);
	
	@Query(value = "SELECT * FROM tb_empresa WHERE act_empresa = 'Activo'", nativeQuery = true)
	Optional<List<Enterprise>> getActive();
	@Query(value = "SELECT * FROM tb_empresa WHERE act_empresa = 'Inactivo'", nativeQuery = true)
	Optional<List<Enterprise>> getInactive();
}
