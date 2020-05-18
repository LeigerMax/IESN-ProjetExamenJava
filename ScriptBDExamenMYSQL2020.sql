/*CREATE DATABASE DbInstallations DEFAULT CHARACTER SET utf8 ;*/
use DBinstallations;
/*
drop table Installation ;
drop table UtilisationSoftware ;
drop table SoftwarePreinstalle ;
drop table Software ;
drop table AnneeEtude;
drop table Professeur ;
drop table Section;
drop table ResponsableReseaux ;
drop table Fournisseur ;
drop table FamilleSoftware;
drop table OS ;
drop table Editeur ;
drop table TypePC ;*/


create table Professeur (
     CodeProf varchar(5) not null,
     NomPrenom varchar(100) not null,
     CodeSection varchar(2) not null,
     constraint ID_Professeur_ID primary key (CodeProf)) ENGINE=InnoDB CHARSET=utf8;

create table Section (
     CodeSection varchar(2) not null,
     Libelle varchar(100) not null,
     constraint ID_Section_ID primary key (CodeSection)) ENGINE=InnoDB CHARSET=utf8;

create table ResponsableReseaux (
     Matricule varchar(10) not null,
     NomPrenom varchar(100) not null,
     constraint ID_ResponsableReseaux_ID primary key (Matricule)) ENGINE=InnoDB CHARSET=utf8;

create table Installation (
     IdInstallation integer not null,
     DateInstallation date not null,
     TypeInstallation tinyint(1) not null,
     Commentaires varchar(100),
     DureeInstallation integer,
     RefProcedureInstallation varchar(50),
     Validation varchar(10) not null,
     DateValidation date,
     CodeSoftware varchar(10) not null,
     Matricule varchar(10) not null,
     CodeOS varchar(10) not null,
     constraint ID_Installation_ID primary key (IdInstallation)) ENGINE=InnoDB CHARSET=utf8;

create table AnneeEtude (
     IdAnneeEtude integer not null,
     Annee integer  not null,
     CodeSection varchar(2) not null,
     constraint ID_AnneeEtude_ID primary key (IdAnneeEtude)) ENGINE=InnoDB CHARSET=utf8;

create table Fournisseur (
     CodeFourn varchar(5) not null,
     Designation varchar(100) not null,
     URL varchar(100) not null,
     NomContactTech varchar(100),
     EmailTech varchar(100),
     TelTech varchar(20),
     NomContactComm varchar(100),
     EmailComm varchar(100),
     TelComm varchar(20),
     constraint ID_Fournisseur_ID primary key (CodeFourn)) ENGINE=InnoDB CHARSET=utf8;

create table FamilleSoftware (
     IdFamSoft integer  not null,
     Libelle varchar(100) not null,
     constraint ID_FamilleSoftware_ID primary key (IdFamSoft)) ENGINE=InnoDB CHARSET=utf8;

create table OS (
     CodeOS varchar(10) not null,
     Libelle varchar(40) not null,
     Version varchar(20) not null,
     constraint ID_OS_ID primary key (CodeOS)) ENGINE=InnoDB CHARSET=utf8;

create table Software (
     CodeSoftware varchar(10) not null,
     Nom varchar(30) not null,
     Version varchar(20) not null,
     DateAcquisition date not null ,
     CoutAcquisition double not null,
     CodeInstallation varchar(200),
     CleInstallation varchar(100),
     CapaciteDisqueMin integer,
     MemoireViveMin integer,
     ProcesseurMin varchar(20),
     MemCarteVideoMin integer,
     CarteSonExigee bit not null,
     ReseauLocal bit not null,
     CodeEdit varchar(5) not null,
     IdFamSoft integer not null,
     CodeFourn varchar(5) not null,
     constraint ID_Software_ID primary key (CodeSoftware)) ENGINE=InnoDB CHARSET=utf8;

create table Editeur (
     CodeEdit varchar(5) not null,
     Designation varchar(100) not null,
     RueNumero varchar(100) not null,
     CodePostal integer  not null,
     Localite varchar(100) not null,
     URL varchar(100) not null,
     NomContactComm varchar(100),
     EmailComm varchar(100),
     TelComm varchar(20),
     constraint ID_Editeur_ID primary key (CodeEdit)) ENGINE=InnoDB CHARSET=utf8;

create table TypePC (
     IdTypePC integer not null,
     Description varchar(200) not null,
     constraint ID_TypePC_ID primary key (IdTypePC)) ENGINE=InnoDB CHARSET=utf8;

create table UtilisationSoftware (
     IdAnneeEtude integer not null,
     CodeSoftware varchar(10) not null,
     constraint ID_UtilisationSoftware_ID primary key (IdAnneeEtude, CodeSoftware)) ENGINE=InnoDB CHARSET=utf8;

create table SoftwarePreinstalle (
     CodeSoftware varchar(10) not null,
     IdTypePC integer not null,
     constraint ID_SoftwarePreinstalle_ID primary key (IdTypePC, CodeSoftware)) ENGINE=InnoDB CHARSET=utf8;



alter table Professeur add constraint REF_Profe_Secti_FK
     foreign key (CodeSection)
     references Section (CodeSection);

alter table Installation add constraint REF_Insta_Softw_FK
     foreign key (CodeSoftware)
     references Software (CodeSoftware);

alter table Installation add constraint REF_Insta_Respo_FK
     foreign key (Matricule)
     references ResponsableReseaux (Matricule);

alter table Installation add constraint REF_Insta_OS_FK
     foreign key (CodeOS)
     references OS (CodeOS);

alter table AnneeEtude add constraint REF_Annee_Secti_FK
     foreign key (CodeSection)
     references Section (CodeSection);

alter table Software add constraint REF_Softw_Edite_FK
     foreign key (CodeEdit)
     references Editeur (CodeEdit);

alter table Software add constraint REF_Softw_Famil_FK
     foreign key (IdFamSoft)
     references FamilleSoftware (IdFamSoft);

alter table Software add constraint REF_Softw_Fourn_FK
     foreign key (CodeFourn)
     references Fournisseur (CodeFourn);

alter table UtilisationSoftware add constraint REF_Utili_Softw_FK
     foreign key (CodeSoftware)
     references Software (CodeSoftware);

alter table UtilisationSoftware add constraint REF_Utili_Annee
     foreign key (IdAnneeEtude)
     references AnneeEtude (IdAnneeEtude);

alter table SoftwarePreinstalle add constraint REF_Softw_TypeP
     foreign key (IdTypePC)
     references TypePC (IdTypePC);

alter table SoftwarePreinstalle add constraint REF_Softw_Softw_FK
     foreign key (CodeSoftware)
     references Software (CodeSoftware);


insert into Section values ('TI','Technologie informatique');
insert into Section values ('IG','Informatique de gestion');
insert into Section values ('CP','Comptabilité');
insert into Section values ('DR','Droit');
insert into Section values ('MK','Marketing');
insert into Section values ('AU','Automatique');
insert into Section values ('IR','Sécurité des systèmes');

insert into AnneeEtude values (1,1,'TI');
insert into AnneeEtude values (2,2,'TI');
insert into AnneeEtude values (3,3,'TI');
insert into AnneeEtude values (4,1,'IG');
insert into AnneeEtude values (5,2,'IG');
insert into AnneeEtude values (6,3,'IG');
insert into AnneeEtude values (7,1,'CP');
insert into AnneeEtude values (8,2,'CP');
insert into AnneeEtude values (9,3,'CP');
insert into AnneeEtude values (10,1,'MK');
insert into AnneeEtude values (11,2,'MK');
insert into AnneeEtude values (12,3,'MK');
insert into AnneeEtude values (13,1,'IR');
insert into AnneeEtude values (14,2,'IR');
insert into AnneeEtude values (15,3,'IR');

insert into Professeur values ('fb1','Jonathan Van Geel','TI');
insert into Professeur values ('ch2','Isabelle Charlier','IG');
insert into Professeur values ('tf3','Didier Valentin','TI');
insert into Professeur values ('g5c','Corinne Derwa','IG');
insert into Professeur values ('gw6','Anthony Grevisse','CP');
insert into Professeur values ('a4g','Alain Tancré','MK');
insert into Professeur values ('a9d','Philippe Van Goetem','IR');

insert into OS values ('Fedora','Fedora 2012','2012');
insert into OS values ('Mint','Linux Mint','2011');
insert into OS values ('RedHat8','Red Hat 8 Linux EN','2011');
insert into OS values ('Ubuntu','Ubuntu 2012','12,04');
insert into OS values ('W7ProfEn','Windows 7 Professional English','v7');
insert into OS values ('W8ProfEn','Windows 10 Professional English','v8.1');
insert into OS values ('W8ProfFr','Windows 8 Prof Français','v8');

insert into FamilleSoftware values (1,'Logiciel Comptable');
insert into FamilleSoftware values (2,'Atelier génie logiciel');
insert into FamilleSoftware values (3,'Atelier Dévelop logiciel');
insert into FamilleSoftware values (4,'Gestion BD end user');
insert into FamilleSoftware values (5,'Gestion BD professionnel');
insert into FamilleSoftware values (6,'Compilateur');
insert into FamilleSoftware values (7,'Envir. dévelop. Java');
insert into FamilleSoftware values (8,'Monitoring réseaux');
insert into FamilleSoftware values (9,'Design Electronique');
insert into FamilleSoftware values (10,'Bureautique');

insert into Editeur values ('Ed01','Microsoft','rue haute, 32',1000, 'Bruxelles','Microsoft.be','Bill','emailBill','+322459876'); 
insert into Editeur values ('Ed02','Oracle','rue basse, 4569',4000, 'Liège','Oracle.be','James',null,null); 
insert into Editeur values ('Ed03','Bob Software','rue plane, 2332',1000, 'Bruxelles','Bob.be','Laurent',null, null); 
insert into Editeur values ('Ed04','Real Software','Kenedy street, 332',1000, 'New York','RealSoftware.us',null, null, null); 

insert into TypePC values (1,'Athlon II X3');
insert into TypePC values (2,'Core I7 2600');
insert into TypePC values (3,'Celeron 530');
insert into TypePC values (4,'Pentium 4 3GB');
insert into TypePC values (5,'Dual core 2x 1,8GB');

insert into Fournisseur values ('Fou1','Priminfo','Priminfo.be','Dupond','emailDupond','081458967',null, null, null);
insert into Fournisseur values ('Fou2','SHS','SHS.be','Durand','emailDurand','042569875','Albert','emailAlbert','0479698547');
insert into Fournisseur values ('Fou3','Open IT','OpenIT.be',null, null, null,'Jules','emailJules','02548796');

insert into Software values ('Bob001','Bob50','v1.1',STR_TO_DATE('07-02-2010','%d-%m-%Y'),1000,null, 'XZE4-O569-YT65', 1000,128,null,4,false,true,'Ed03',1,'Fou3');
insert into Software values ('NB02','NetBeans','v7.4',STR_TO_DATE('07-03-2014','%d-%m-%Y'),0,null, null, 400,500,'core I3',4,false,true,'Ed02',7,'Fou2');
insert into Software values ('Of13','Office 2013','v1.0',STR_TO_DATE('01-03-2014','%d-%m-%Y'),2000,null, 'BUI89-LOI6-KOP3-FR58', 800,2000,'dualcore',4,false,true,'Ed01',10,'Fou1');
insert into Software values ('Vs12','Visual Studio','v1.0',STR_TO_DATE('10-09-2012','%d-%m-%Y'),600,null, null, 500,500,'core I3',4,false,true,'Ed01',3,'Fou2');
insert into Software values ('Or11','Oracle 11g','11g',STR_TO_DATE('10-09-2011','%d-%m-%Y'),500,null, null, 100,500,'core I3',4,false,false,'Ed02',5,'Fou1');

insert into ResponsableReseaux values ('MarGob','Marvin Gobin');
insert into ResponsableReseaux values ('AVK','André Van Kerrebroeck');
insert into ResponsableReseaux values ('AlBa','Alexandre Baligant');

insert into SoftwarePreinstalle values ('Bob001',1);
insert into SoftwarePreinstalle values ('Bob001',3);
insert into SoftwarePreinstalle values ('NB02',3);
insert into SoftwarePreinstalle values ('NB02',5);
insert into SoftwarePreinstalle values ('NB02',4);
insert into SoftwarePreinstalle values ('Of13',4);
insert into SoftwarePreinstalle values ('Of13',1);
insert into SoftwarePreinstalle values ('Of13',2);
insert into SoftwarePreinstalle values ('Or11',2);
insert into SoftwarePreinstalle values ('Or11',5);
insert into SoftwarePreinstalle values ('Vs12',2);
insert into SoftwarePreinstalle values ('Vs12',3);
insert into SoftwarePreinstalle values ('Vs12',4);


insert into UtilisationSoftware values (1,'Of13');
insert into UtilisationSoftware values (2,'Of13');
insert into UtilisationSoftware values (3,'Of13');
insert into UtilisationSoftware values (7,'Bob001');
insert into UtilisationSoftware values (8,'Bob001');
insert into UtilisationSoftware values (5,'NB02');
insert into UtilisationSoftware values (6,'Vs12');
insert into UtilisationSoftware values (5,'Or11');
insert into UtilisationSoftware values (4,'Of13');
insert into UtilisationSoftware values (12,'Vs12');
insert into UtilisationSoftware values (13,'Or11');
insert into UtilisationSoftware values (14,'Of13');


insert into Installation values (1,'2016-03-01',true,'Sans problème',20,null,'A prevoir','2016-03-01', 'NB02','AVK','W7ProfEn');
insert into Installation values (2,'2015-12-12',false,'Trois essais',120,'Procedure num 125', 'Terminee', null, 'Or11','AlBa','W8ProfFr');
insert into Installation values (3,'2015-08-11',true,null,100, null, 'En cours',null, 'Vs12','MarGob','W8ProfEn');


