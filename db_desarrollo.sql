CREATE TABLE UEA
(
    Clave       VARCHAR2(10) PRIMARY KEY,
    Nombre      VARCHAR2(50),
    IdUnidad    NUMBER,
    Creditos    NUMBER,
    IdTronco    NUMBER,
    IdTrimestre NUMBER
);

CREATE TABLE Unidad
(
    IdUnidad NUMBER PRIMARY KEY,
    Nombre   VARCHAR2(10)
);

CREATE TABLE Tronco
(
    IdTronco NUMBER PRIMARY KEY,
    Nombre   VARCHAR2(30)
);

CREATE TABLE Trimestre
(
    IdTrimestre NUMBER PRIMARY KEY,
    Nombre      VARCHAR2(10)
);

ALTER TABLE UEA
    ADD FOREIGN KEY (IdUnidad) REFERENCES Unidad (IdUnidad);
ALTER TABLE UEA
    ADD FOREIGN KEY (IdTrimestre) REFERENCES Trimestre (IdTrimestre);
ALTER TABLE UEA
    ADD FOREIGN KEY (IdTronco) REFERENCES Tronco (IdTronco);

CREATE TABLE PROFESORES(
  NoEconomico VARCHAR2(10) PRIMARY KEY,
  Nombre VARCHAR2(20),
  ApellidoPaterno VARCHAR2(20),
  ApellidoMaterno VARCHAR2(20),
  IdUnidad NUMBER,
  IdDepartamento NUMBER,
  IdDivision NUMBER,
  Email VARCHAR2(20),
  Password VARCHAR2(100)
);

CREATE TABLE DEPARTAMENTO(
    IdDepartamento NUMBER PRIMARY KEY,
    Nombre VARCHAR2(20)
);

CREATE TABLE DIVISION(
    IdDivision NUMBER PRIMARY KEY,
    Nombre VARCHAR2(20)
);

ALTER TABLE PROFESORES ADD FOREIGN KEY (IdUnidad) REFERENCES UNIDAD (IDUNIDAD);
ALTER TABLE PROFESORES ADD FOREIGN KEY (IdDepartamento) REFERENCES DEPARTAMENTO (IdDepartamento);
ALTER TABLE PROFESORES ADD FOREIGN KEY (IdDivision) REFERENCES DIVISON (IdDivision);

CREATE TABLE ALUMNOS(
    Matricula VARCHAR2(20) PRIMARY KEY,
    Nombre VARCHAR2(20),
    ApellidoPaterno VARCHAR2(20),
    ApellidoMaterno VARCHAR2(20),
    IdUnidad NUMBER,
    IdDivision NUMBER,
    IdCarrera NUMBER
);

CREATE TABLE CARRERA(
    IdCarrera NUMBER PRIMARY KEY,
    Nombre VARCHAR2(50),
);

ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdCarrera) REFERENCES CARRERA (IdCarrera);
ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdDivision) REFERENCES DIVISION (IdDivision);
ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdUnidad) REFERENCES UNIDAD (IdUnidad);

CREATE TABLE USUARIOS(
    Email VARCHAR2(20) PRIMARY KEY,
    Password VARCHAR2(100),
    Clave VARCHAR2(100),
    IdRol NUMERIC
);

CREATE TABLE ROLES(
    IdRol NUMERIC PRIMARY KEY,
    Nombre VARCHAR2(100)
);

ALTER TABLE USUARIOS ADD FOREIGN KEY (IdRol) REFERENCES ROLES (IdRol);

CREATE TABLE GRUPOS(
                       clave_grupo varchar2(10) PRIMARY KEY ,
                       clave_uea varchar2(10),
                       unidad number,
                       horario number,
                       no_economico varchar2(10),
                       cupo_unidad NUMBER,
                       salon NUMBER

);

CREATE TABLE SALON(
                      id_salon number primary key ,
                      nombre varchar2(10),
                      cupo number,
                      ubicacion varchar2(20)
);

CREATE TABLE HORARIO(
                        id_horario number primary key ,
                        hora_inicio varchar2(20),
                        hora_termino varchar2(20),
                        dias varchar2(30)
);

ALTER TABLE GRUPOS ADD FOREIGN KEY (CLAVE_UEA) REFERENCES UEA (CLAVE);
ALTER TABLE GRUPOS ADD FOREIGN KEY (UNIDAD) references UNIDAD (IDUNIDAD);
ALTER TABLE GRUPOS ADD FOREIGN KEY (HORARIO) REFERENCES HORARIO (ID_HORARIO);
ALTER TABLE GRUPOS ADD FOREIGN KEY (NO_ECONOMICO) REFERENCES PROFESORES(NOECONOMICO);
ALTER TABLE GRUPOS ADD FOREIGN KEY (SALON) REFERENCES SALON(ID_SALON);