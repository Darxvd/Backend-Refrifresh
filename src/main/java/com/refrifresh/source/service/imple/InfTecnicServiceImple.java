package com.refrifresh.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.refrifresh.source.entity.InfTecnic;
import com.refrifresh.source.repository.InformTecnicRepository;
import com.refrifresh.source.service.InfTecnicService;

@Service
public class InfTecnicServiceImple implements InfTecnicService{

	@Autowired
	private InformTecnicRepository infRepository;
	
	
	@Override
	public List<InfTecnic> getInform() {
		return infRepository.findAll();
	}

	@Override
	public List<InfTecnic> getActive() {
		return infRepository.getActive().get();
	}

	@Override
	public List<InfTecnic> getInactive() {
		return infRepository.getInactive().get();
	}

	@Override
	public InfTecnic save(InfTecnic objInfTecnic) {
		return infRepository.save(objInfTecnic);
	}

	@Override
	public InfTecnic update(InfTecnic objTecnic) {
		return infRepository.save(objTecnic);
	}

	@Override
	public InfTecnic findByIdInfo(int idInfo) {
		return infRepository.findByIdInfo(idInfo).orElse(null);
	}

	@Override
	public void delete(InfTecnic objInfTecnic) {
		infRepository.delete(objInfTecnic);
	}

}
