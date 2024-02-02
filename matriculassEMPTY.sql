-- Crear base de datos y uso
CREATE DATABASE IF NOT EXISTS matriculasTest2;
USE matriculasTest2;
-- Crear tabla `distriitoalum`
CREATE TABLE IF NOT EXISTS `distriitoalum` (
  `id_distritoAlum` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para distritos de alumnos
  `distritoA` varchar(30) NOT NULL, -- Nombre del distrito de alumnos
  PRIMARY KEY (`id_distritoAlum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `distritorepre`
CREATE TABLE IF NOT EXISTS `distritorepre` (
  `id_distritoR` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para distritos de representantes
  `distritoR` varchar(30) NOT NULL, -- Nombre del distrito de representantes
  PRIMARY KEY (`id_distritoR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `telefono`
CREATE TABLE IF NOT EXISTS `telefono` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para teléfonos
  `telefono` int(9) NOT NULL, -- Número de teléfono
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `habilidad`
CREATE TABLE IF NOT EXISTS `habilidad` (
  `id_habilidad` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para habilidades
  `habilidad` varchar(30) NOT NULL, -- Nombre de la habilidad
  PRIMARY KEY (`id_habilidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `representante`
CREATE TABLE IF NOT EXISTS `representante` (
  `id_Repre` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para representantes
  `dni_Repre` int(15) NOT NULL, -- DNI del representante
  `nom_Repre` varchar(30) NOT NULL, -- Nombre del representante
  `ape_PRe` varchar(30) NOT NULL, -- Apellido paterno del representante
  `ape_MRe` varchar(30) NOT NULL, -- Apellido materno del representante
  `sexo` varchar(30) NOT NULL, -- Género del representante
  `id_distritoR` int(15) NOT NULL, -- Identificador del distrito del representante
  `domicilio` varchar(30) NOT NULL, -- Domicilio del representante
  `ocupacion` varchar(30) NOT NULL, -- Ocupación del representante
  `lugar_traba` varchar(30) NOT NULL, -- Lugar de trabajo del representante
  `correo` varchar(30) NOT NULL, -- Correo electrónico del representante
  `id_telefono` int(15) NOT NULL, -- Identificador del teléfono del representante
  PRIMARY KEY (`id_Repre`),
  KEY `tele` (`id_telefono`),
  KEY `distriRe` (`id_distritoR`),
  CONSTRAINT `distriRe` FOREIGN KEY (`id_distritoR`) REFERENCES `distritorepre` (`id_distritoR`),
  CONSTRAINT `tele` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `alumno`
CREATE TABLE IF NOT EXISTS `alumno` (
  `id_Alumno` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para alumnos
  `dni_Alumno` int(15) NOT NULL, -- DNI del alumno
  `nom_Alu` varchar(30) NOT NULL, -- Nombre del alumno
  `ape_PAl` varchar(30) NOT NULL, -- Apellido paterno del alumno
  `ape_MAl` varchar(30) NOT NULL, -- Apellido materno del alumno
  `fec_Nac` date NOT NULL, -- Fecha de nacimiento del alumno
  `sexo` varchar(30) NOT NULL, -- Género del alumno
  `id_distritoAlum` int(15) NOT NULL, -- Identificador del distrito del alumno
  `domicilio` varchar(30) NOT NULL, -- Domicilio del alumno
  `nivel_ing` varchar(30) NOT NULL, -- Nivel de ingreso del alumno
  `grado_ing` int(15) NOT NULL, -- Grado de ingreso del alumno
  `colegio_ant` varchar(30) NOT NULL, -- Colegio anterior del alumno
  `id_habilidad` int(15) NOT NULL, -- Identificador de habilidad del alumno
  `id_Repre` int(15) NOT NULL, -- Identificador del representante del alumno
  `relacion` varchar(30) NOT NULL, -- Relación con el representante del alumno
  PRIMARY KEY (`id_Alumno`),
  KEY `habilidad` (`id_habilidad`),
  KEY `distriA` (`id_distritoAlum`),
  KEY `repre` (`id_Repre`),
  CONSTRAINT `distriA` FOREIGN KEY (`id_distritoAlum`) REFERENCES `distriitoalum` (`id_distritoAlum`),
  CONSTRAINT `habilidad` FOREIGN KEY (`id_habilidad`) REFERENCES `habilidad` (`id_habilidad`),
  CONSTRAINT `repre` FOREIGN KEY (`id_Repre`) REFERENCES `representante` (`id_Repre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `administrador`
CREATE TABLE IF NOT EXISTS `administrador` (
  `id_admini` int(11) NOT NULL AUTO_INCREMENT, -- Identificador único para administradores
  `nombre_Admini` varchar(30) NOT NULL, -- Nombre del administrador
  PRIMARY KEY (`id_admini`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `iniciosesion`
CREATE TABLE IF NOT EXISTS `iniciosesion` (
  `id_Usuario` varchar(30) NOT NULL, -- Identificador único para usuarios de inicio de sesión
  `contra` varchar(30) NOT NULL, -- Contraseña del usuario
  `id_admini` int(15) NOT NULL, -- Identificador del administrador asociado
  PRIMARY KEY (`id_Usuario`),
  KEY `administrador` (`id_admini`),
  CONSTRAINT `administrador` FOREIGN KEY (`id_admini`) REFERENCES `administrador` (`id_admini`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Crear tabla `matricula`
CREATE TABLE IF NOT EXISTS `matricula` (
  `id_Matricula` int(15) NOT NULL AUTO_INCREMENT, -- Identificador único para matrículas
  `id_Alumno` int(15) NOT NULL, -- Identificador del alumno asociado a la matrícula
  `nivel_m` varchar(30) NOT NULL, -- Nivel de la matrícula
  `grado_m` int(15) NOT NULL, -- Grado de la matrícula
  `estado_m` varchar(30) NOT NULL, -- Estado de la matrícula
  `metodo_Pago` varchar(30) NOT NULL, -- Método de pago de la matrícula
  `monto_Pago` double NOT NULL, -- Monto pagado en la matrícula
  `observaciones` varchar(30) NOT NULL, -- Observaciones de la matrícula
  `id_Usuario` varchar(30) NOT NULL, -- Identificador del usuario asociado a la matrícula
  PRIMARY KEY (`id_Matricula`),
  KEY `alumno` (`id_Alumno`),
  KEY `usuario` (`id_Usuario`),
  CONSTRAINT `alumno` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id_Alumno`),
  CONSTRAINT `usuario` FOREIGN KEY (`id_Usuario`) REFERENCES `iniciosesion` (`id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;