CREATE TABLE uea
(
    Clave       VARCHAR(10) PRIMARY KEY,
    Nombre      VARCHAR(50),
    IdUnidad    INT,
    Creditos    INT,
    IdTronco    INT,
    IdTrimestre INT
);

CREATE TABLE unidad
(
    IdUnidad INT PRIMARY KEY,
    Nombre   VARCHAR(10)
);

CREATE TABLE tronco
(
    IdTronco INT PRIMARY KEY,
    Nombre   VARCHAR(30)
);

CREATE TABLE trimestre
(
    IdTrimestre INT PRIMARY KEY,
    Nombre      VARCHAR(10)
);

ALTER TABLE uea
    ADD FOREIGN KEY (IdUnidad) REFERENCES unidad (IdUnidad);
ALTER TABLE uea
    ADD FOREIGN KEY (IdTrimestre) REFERENCES trimestre (IdTrimestre);
ALTER TABLE uea
    ADD FOREIGN KEY (IdTronco) REFERENCES tronco (IdTronco);

CREATE TABLE profesores
(
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

CREATE TABLE departamento
(
                             IdDepartamento INT PRIMARY KEY,
                             Nombre VARCHAR(20)
);

CREATE TABLE division
(
                         IdDivision INT PRIMARY KEY,
                         Nombre VARCHAR(20)
);

ALTER TABLE profesores ADD FOREIGN KEY (IdUnidad) REFERENCES unidad (IDUNIDAD);
ALTER TABLE profesores ADD FOREIGN KEY (IdDepartamento) REFERENCES departamento (IdDepartamento);
ALTER TABLE profesores ADD FOREIGN KEY (IdDivision) REFERENCES division (IdDivision);

CREATE TABLE alumnos
(
                        Matricula VARCHAR(20) PRIMARY KEY,
                        Nombre VARCHAR(20),
                        ApellidoPaterno VARCHAR(20),
                        ApellidoMaterno VARCHAR(20),
                        IdUnidad INT,
                        IdDivision INT,
                        IdCarrera INT
);

CREATE TABLE carrera
(
                        IdCarrera INT PRIMARY KEY,
                        Nombre VARCHAR(50)
);

ALTER TABLE alumnos ADD FOREIGN KEY (IdCarrera) REFERENCES carrera (IdCarrera);
ALTER TABLE alumnos ADD FOREIGN KEY (IdDivision) REFERENCES division (IdDivision);
ALTER TABLE alumnos ADD FOREIGN KEY (IdUnidad) REFERENCES unidad (IdUnidad);

CREATE TABLE usuarios
(
                         Email VARCHAR(20) PRIMARY KEY,
                         Password VARCHAR(100),
                         Clave VARCHAR(100),
                         Tipo VARCHAR(100),
                         IdRol INT
);

CREATE TABLE roles
(
                      IdRol INT PRIMARY KEY,
                      Nombre VARCHAR(100)
);

ALTER TABLE usuarios ADD FOREIGN KEY (IdRol) REFERENCES roles (IdRol);

CREATE TABLE grupos
(
                       ClaveGrupo VARCHAR(10) PRIMARY KEY ,
                       ClaveUea VARCHAR(10),
                       Unidad INT,
                       Horario INT,
                       NoEconomico VARCHAR(10),
                       CupoUnidad INT,
                       Salon INT

);

CREATE TABLE salon
(
                      IdSalon INT PRIMARY KEY ,
                      Nombre VARCHAR(10),
                      Cupo INT,
                      Ubicacion VARCHAR(20)
);

CREATE TABLE horario(
                        IdHorario INT PRIMARY KEY ,
                        HoraInicio VARCHAR(20),
                        HoraTermino VARCHAR(20),
                        Dias VARCHAR(30)
);

ALTER TABLE grupos ADD FOREIGN KEY (ClaveUea) REFERENCES uea (Clave);
ALTER TABLE grupos ADD FOREIGN KEY (Unidad) REFERENCES unidad (IdUnidad);
ALTER TABLE grupos ADD FOREIGN KEY (Horario) REFERENCES horario (IdHorario);
ALTER TABLE grupos ADD FOREIGN KEY (NoEconomico) REFERENCES profesores (NoEconomico);
ALTER TABLE grupos ADD FOREIGN KEY (Salon) REFERENCES salon (IdSalon);