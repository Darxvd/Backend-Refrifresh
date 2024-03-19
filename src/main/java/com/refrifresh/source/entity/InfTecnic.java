package com.refrifresh.source.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_informetecnico")
public class InfTecnic {
	@Id
	private int idInfo;
	private String fallaInfo;
	private String obserInfo;
    private String recoInfo;
    private String fechaInfo;
    private String horaInfor;
    private String nserieMaquina;
    private String nomMaquina;
    private String mcaMaquina;
    private String modMaquina;
    private String arubiMaquina;
    private String voltMaquina;
    private String ampMaquina;
    private String potMaquina;
    private String temMaquina;
    private String preMaquina;
    private String gasMaquina;
    private String otrosMaquina;
    private String actMaquina;
    private int idTecnico;
    private int idEmpresa;
    
    @ManyToOne
    @JoinColumn(name = "idTecnico", insertable = false, updatable = false)
    private Tecnic objTecnic;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    private Enterprise objEnteprise;
    
}
