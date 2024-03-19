package com.refrifresh.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_empresa")
public class Enterprise {
	@Id
	private int idEmpresa;
	private String rucEmpresa;
	private String rzcEmpresa;
	private String ncoEmpresa;
	private String dirEmpresa;
	private String disEmpresa;
	private String actEmpresa;
}
