package com.refrifresh.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tecnico")
public class Tecnic {
	@Id
	private int idTecnico;
    private String tecTecnico;
    private String actTecnico;
}
