CREATE TABLE UEA
(
    Clave       VARCHAR(10) PRIMARY KEY,
    Nombre      VARCHAR(50),
    IdUnidad    INT,
    Creditos    INT,
    IdTronco    INT,
    IdTrimestre INT
);

CREATE TABLE Unidad
(
    IdUnidad INT PRIMARY KEY,
    Nombre   VARCHAR(10)
);

CREATE TABLE Tronco
(
    IdTronco INT PRIMARY KEY,
    Nombre   VARCHAR(30)
);

CREATE TABLE Trimestre
(
    IdTrimestre INT PRIMARY KEY,
    Nombre      VARCHAR(10)
);

ALTER TABLE UEA
    ADD FOREIGN KEY (IdUnidad) REFERENCES Unidad (IdUnidad);
ALTER TABLE UEA
    ADD FOREIGN KEY (IdTrimestre) REFERENCES Trimestre (IdTrimestre);
ALTER TABLE UEA
    ADD FOREIGN KEY (IdTronco) REFERENCES Tronco (IdTronco);

CREATE TABLE PROFESORES(
                           NoEconomico VARCHAR(10) PRIMARY KEY,
                           Nombre VARCHAR(20),
                           ApellidoPaterno VARCHAR(20),
                           ApellidoMaterno VARCHAR(20),
                           IdUnidad INT,
                           IdDepartamento INT,
                           IdDivision INT,
                           Email VARCHAR(20),
                           Password VARCHAR(100)
);

CREATE TABLE DEPARTAMENTO(
                             IdDepartamento INT PRIMARY KEY,
                             Nombre VARCHAR(20)
);

CREATE TABLE DIVISION(
                         IdDivision INT PRIMARY KEY,
                         Nombre VARCHAR(20)
);

ALTER TABLE PROFESORES ADD FOREIGN KEY (IdUnidad) REFERENCES UNIDAD (IDUNIDAD);
ALTER TABLE PROFESORES ADD FOREIGN KEY (IdDepartamento) REFERENCES DEPARTAMENTO (IdDepartamento);
ALTER TABLE PROFESORES ADD FOREIGN KEY (IdDivision) REFERENCES DIVISION (IdDivision);

CREATE TABLE ALUMNOS(
                        Matricula VARCHAR(20) PRIMARY KEY,
                        Nombre VARCHAR(20),
                        ApellidoPaterno VARCHAR(20),
                        ApellidoMaterno VARCHAR(20),
                        IdUnidad INT,
                        IdDivision INT,
                        IdCarrera INT
);

CREATE TABLE CARRERA(
                        IdCarrera INT PRIMARY KEY,
                        Nombre VARCHAR(50)
);

ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdCarrera) REFERENCES CARRERA (IdCarrera);
ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdDivision) REFERENCES DIVISION (IdDivision);
ALTER TABLE ALUMNOS ADD FOREIGN KEY (IdUnidad) REFERENCES UNIDAD (IdUnidad);

CREATE TABLE USUARIOS(
                         Email VARCHAR(20) PRIMARY KEY,
                         Password VARCHAR(100),
                         Clave VARCHAR(100),
                         Tipo VARCHAR(100),
                         IdRol INT
);

CREATE TABLE ROLES(
                      IdRol INT PRIMARY KEY,
                      Nombre VARCHAR(100)
);

ALTER TABLE USUARIOS ADD FOREIGN KEY (IdRol) REFERENCES ROLES (IdRol);

CREATE TABLE GRUPOS(
                       ClaveGrupo VARCHAR(10) PRIMARY KEY ,
                       ClaveUea VARCHAR(10),
                       Unidad INT,
                       Horario INT,
                       NoEconomico VARCHAR(10),
                       CupoUnidad INT,
                       Salon INT

);

CREATE TABLE SALON(
                      IdSalon INT PRIMARY KEY ,
                      Nombre VARCHAR(10),
                      Cupo INT,
                      Ubicacion VARCHAR(20)
);

CREATE TABLE HORARIO(
                        IdHorario INT PRIMARY KEY ,
                        HoraInicio VARCHAR(20),
                        HoraTermino VARCHAR(20),
                        Dias VARCHAR(30)
);

ALTER TABLE GRUPOS ADD FOREIGN KEY (ClaveUea) REFERENCES UEA (Clave);
ALTER TABLE GRUPOS ADD FOREIGN KEY (Unidad) REFERENCES UNIDAD (IdUnidad);
ALTER TABLE GRUPOS ADD FOREIGN KEY (Horario) REFERENCES HORARIO (IdHorario);
ALTER TABLE GRUPOS ADD FOREIGN KEY (NoEconomico) REFERENCES PROFESORES(NoEconomico);
ALTER TABLE GRUPOS ADD FOREIGN KEY (Salon) REFERENCES SALON(IdSalon);