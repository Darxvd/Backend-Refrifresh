package com.refrifresh.source.service;

import java.util.List;

import com.refrifresh.source.entity.Tecnic;

public interface TecnicService {
	public List<Tecnic> getTecnic();
	public List<Tecnic> getActive();
	public List<Tecnic> getInactive();
	public Tecnic save (Tecnic objTecnic);
	public Tecnic update (Tecnic objTecnic);
	public Tecnic findByIdTecnic(int idTecnic);
	public void delete (Tecnic objTecnic);
}
