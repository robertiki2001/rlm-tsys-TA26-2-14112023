DROP TABLE IF EXISTS asignado_a;
DROP TABLE IF EXISTS proyectos;
DROP TABLE IF EXISTS cientificos;

CREATE TABLE cientificos (
    dni VARCHAR(8) PRIMARY KEY,
    nomApels VARCHAR(250)
);

INSERT INTO cientificos (dni, nomApels) VALUES 
    ('12345678', 'Juan Perez'),
    ('87654321', 'Maria Lopez'),
    ('23456789', 'Pedro Ramirez'),
    ('98765432', 'Luisa Martinez'),
    ('34567890', 'Ana Sanchez');


CREATE TABLE proyectos (
    id CHAR(4) PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    horas INT
);

INSERT INTO proyectos (id, nombre, horas) VALUES 
    ('P1', 'Proyecto A', 100),
    ('P2', 'Proyecto B', 150),
    ('P3', 'Proyecto C', 200),
    ('P4', 'Proyecto D', 120),
    ('P5', 'Proyecto E', 180);

CREATE TABLE asignado_a (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni_cientifico VARCHAR(8),
    id_proyecto CHAR(4),
    FOREIGN KEY (dni_cientifico) REFERENCES cientificos (dni) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_proyecto) REFERENCES proyectos (id) ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO asignado_a (dni_cientifico, id_proyecto) VALUES 
    ('12345678', 'P1'),
    ('87654321', 'P2'),
    ('23456789', 'P3'),
    ('98765432', 'P4'),
    ('34567890', 'P5');
