package com.refrifresh.source.service.imple;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refrifresh.source.entity.Tecnic;
import com.refrifresh.source.repository.TecnicRepository;
import com.refrifresh.source.service.TecnicService;

@Service
public class TecnicServiceImple implements TecnicService{

	@Autowired
	private TecnicRepository tecnicRepository;
    
	@Override
	public List<Tecnic> getTecnic() {
		return tecnicRepository.findAll();
	}

	@Override
	public List<Tecnic> getActive() {
		return tecnicRepository.getActive().get();
	}

	@Override
	public List<Tecnic> getInactive() {
		return tecnicRepository.getInactive().get();
	}
	
	@Override
    public Tecnic save(Tecnic objTecnic) {
		return tecnicRepository.save(objTecnic);
    }
	
	@Override
	public Tecnic update(Tecnic objTecnic) {
		return tecnicRepository.save(objTecnic);
	}

	@Override
	public Tecnic findByIdTecnic(int idTecnic) {
		return tecnicRepository.findByIdTecnico(idTecnic).orElse(null);
	}

	@Override
	public void delete(Tecnic objTecnic) {
		tecnicRepository.delete(objTecnic);
	}

}
