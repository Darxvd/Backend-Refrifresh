package com.refrifresh.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refrifresh.source.entity.Enterprise;
import com.refrifresh.source.repository.EnterpriseRepository;
import com.refrifresh.source.service.EnterpriseService;

@Service
public class EnterpriseServiceImple implements EnterpriseService{

	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Override
	public List<Enterprise> getEnterprise() {
		return enterpriseRepository.findAll();
	}

	@Override
	public Enterprise save(Enterprise objEnterprise) {
		return enterpriseRepository.save(objEnterprise);
	}

	@Override
	public Enterprise update(Enterprise objEnterprise) {
		return enterpriseRepository.save(objEnterprise);
	}

	@Override
	public Enterprise findByIdEnterprise(int idEnterprise) {
		return enterpriseRepository.findByIdEmpresa(idEnterprise).orElse(null);
	}

	@Override
	public void delete(Enterprise objEnterprise) {
		enterpriseRepository.delete(objEnterprise);
	}

	@Override
	public List<Enterprise> getActive() {
		return enterpriseRepository.getActive().get();
	}

	@Override
	public List<Enterprise> getInactive() {
		return enterpriseRepository.getInactive().get();
	}

	
}
