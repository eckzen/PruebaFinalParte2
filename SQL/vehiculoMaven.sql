CREATE database vehiculoMaven;
USE vehiculoMaven;

CREATE TABLE vehiculos (
id INT AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(50),
marca VARCHAR(50),
potencia INT,
fecha_compra DATE
);