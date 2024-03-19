package com.refrifresh.source.service;

import java.util.List;
import com.refrifresh.source.entity.InfTecnic;

public interface InfTecnicService {
	public List<InfTecnic> getInform();
	public List<InfTecnic> getActive();
	public List<InfTecnic> getInactive();
	public InfTecnic save (InfTecnic objInfTecnic);
	public InfTecnic update (InfTecnic objTecnic);
	public InfTecnic findByIdInfo(int idInfo);
	public void delete (InfTecnic objInfTecnic);
}
