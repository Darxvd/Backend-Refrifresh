package com.refrifresh.source.service;

import java.util.List;

import com.refrifresh.source.entity.Enterprise;

public interface EnterpriseService {
	public List<Enterprise> getEnterprise();
	public List<Enterprise> getActive();
	public List<Enterprise> getInactive();
	public Enterprise save(Enterprise objEnterprise);
	public Enterprise update(Enterprise objEnterprise);
	public Enterprise findByIdEnterprise(int idEnterprise);
	public void delete(Enterprise objEnterprise);
}
