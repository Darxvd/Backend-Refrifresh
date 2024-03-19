create database bd_refrifresh;

use bd_refrifresh;

create table tb_empresa(
	id_empresa int not null primary key auto_increment,
	ruc_empresa varchar(11) default null,
    rzc_empresa varchar(200) default null,
    nco_empresa varchar(200) default null,
    dir_empresa varchar(200) default null,
    dis_empresa varchar(200) default null,
    act_empresa varchar(200) default null
);

create table tb_tecnico(
	id_tecnico int not null primary key auto_increment,
    tec_tecnico varchar(500) default null,
    act_tecnico varchar(500) default null
);

create table tb_informetecnico(
	id_info int not null primary key auto_increment,
    id_empresa int not null,
    falla_info varchar(1000) default null,
    obser_info varchar(1000) default null,
    reco_info varchar(1000) default null,
    id_tecnico int not null,
    fecha_info varchar(200) default null,
    hora_infor varchar(200) default null,
    nserie_maquina varchar(20) not null,
    nom_maquina varchar(200) default null,
    mca_maquina varchar(200) null,
    mod_maquina varchar(200) null,
    arubi_maquina varchar(500)  null,
    volt_maquina varchar(50) null,
    amp_maquina varchar(50) null,
    pot_maquina varchar(50) null,
    tem_maquina varchar(50) null,
    pre_maquina varchar(50) null,
    gas_maquina varchar(50) null,
    otros_maquina varchar(500) null,
    act_maquina varchar(50) not null,
    foreign key(id_empresa) references tb_empresa(id_empresa),
    foreign key(id_tecnico) references tb_tecnico(id_tecnico)
)auto_increment=00000101;

insert into tb_tecnico values(null, 'Jose Lobar Luis Rodriguez', 'Activo');

insert into tb_empresa values(null, '20606060601', 'Resort Hotel Paracas S.A.C.', 'Resort Hotel Paracas', 'Av. Los aquijes 1258', 'Paracas', 'Activo'),
							 (null, '20606060602', 'Prueba Social Dos S.A.C.', 'Prueba Fast Lenta', 'Av. Quien sabe donde 123', 'SJL', 'Inactivo');

insert into tb_informetecnico value(null, 1, 'Mucho frio', 'Se calibrara', 'Dele un buen uso', 1, '28-02-2024', '22:07 p.m.', '789789852', 'Congeladora', 
									'X','X','X','X','X','85','X','89','X', 'Ave: 2000', 'Activo');

select * from tb_informetecnico;
select * from tb_empresa;
select * from tb_tecnico;