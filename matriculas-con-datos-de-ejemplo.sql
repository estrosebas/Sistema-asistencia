-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-10-2023 a las 04:18:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `matriculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_admini` int(11) NOT NULL,
  `nombre_Admini` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_admini`, `nombre_Admini`) VALUES
(1, 'Juan Perez'),
(2, 'Maria Gomez'),
(3, 'Luis Torres'),
(4, 'Ana Flores'),
(5, 'Carlos Diaz'),
(6, 'Miguel Ruiz'),
(7, 'Sandra Lopez'),
(8, 'Pablo Garcia'),
(9, 'Daniela Torres'),
(10, 'Jorge Perez'),
(11, 'Miguel Ruiz'),
(12, 'Sandra Lopez'),
(13, 'Pablo Garcia'),
(14, 'Daniela Torres'),
(15, 'Jorge Perez'),
(16, 'Laura Gomez'),
(17, 'David Flores'),
(18, 'Ana Diaz'),
(19, 'Mario Rodriguez'),
(20, 'Karla Martinez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id_Alumno` int(11) NOT NULL,
  `dni_Alumno` int(15) NOT NULL,
  `nom_Alu` varchar(30) NOT NULL,
  `ape_PAl` varchar(30) NOT NULL,
  `ape_MAl` varchar(30) NOT NULL,
  `fec_Nac` date NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `id_distritoAlum` int(15) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `nivel_ing` varchar(30) NOT NULL,
  `grado_ing` int(15) NOT NULL,
  `colegio_ant` varchar(30) NOT NULL,
  `id_habilidad` int(15) NOT NULL,
  `id_Repre` int(15) NOT NULL,
  `relacion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_Alumno`, `dni_Alumno`, `nom_Alu`, `ape_PAl`, `ape_MAl`, `fec_Nac`, `sexo`, `id_distritoAlum`, `domicilio`, `nivel_ing`, `grado_ing`, `colegio_ant`, `id_habilidad`, `id_Repre`, `relacion`) VALUES
(1, 74589632, 'Pedro', 'Gomez', 'Perez', '2015-03-12', 'Masculino', 1, 'Calle 15 N° 25-36', 'Primaria', 2, 'San Felipe', 1, 1, 'Padre'),
(2, 75412369, 'Maria', 'Torres', 'Garcia', '2016-01-25', 'Femenino', 2, 'Av. Principal 589', 'Primaria', 1, 'Santa Rosa', 2, 2, 'Madre'),
(3, 78965412, 'Juana', 'Lopez', 'Diaz', '2015-07-30', 'Femenino', 3, 'Jr. Los Rosales 125', 'Primaria', 3, 'San Judas Tadeo', 3, 3, 'Tio'),
(4, 12365478, 'Carlos', 'Perez', 'Gonzales', '2014-11-15', 'Masculino', 4, 'Pasaje 3 N° 36-98', 'Primaria', 4, 'Santa Ana', 4, 4, 'Tia'),
(5, 45632178, 'Raul', 'Gomez', 'Flores', '2016-05-22', 'Masculino', 5, 'Av. Miraflores 763', 'Inicial', 2, 'Angelitos', 5, 5, 'Hermana'),
(6, 32145698, 'Luisa', 'Ramirez', 'Torres', '2015-08-15', 'Femenino', 6, 'Av. Tupac Amaru 1258', 'Primaria', 1, 'Angelitos', 6, 6, 'Padre'),
(7, 75123648, 'Rene', 'Perez', 'Gonzales', '2016-03-21', 'Masculino', 7, 'Jr. Huayna Cápac 369', 'Inicial', 2, 'Chiquititos', 7, 7, 'Madre'),
(8, 85231478, 'Paola', 'Garcia', 'Diaz', '2014-10-12', 'Femenino', 8, 'Av. Próceres 1245', 'Primaria', 5, 'Sagrado Corazon', 8, 8, 'Hermano'),
(9, 63258974, 'Alan', 'Flores', 'Lopez', '2013-12-02', 'Masculino', 9, 'Pasaje Santa Rosa 158', 'Secundaria', 1, 'San Felipe', 9, 9, 'Hermana'),
(10, 96325478, 'Luciana', 'Torres', 'Gomez', '2012-07-15', 'Femenino', 10, 'Jr. Union 654', 'Secundaria', 2, 'Nuestra Señora', 10, 10, 'Tio'),
(11, 32145698, 'Luisa', 'Ramirez', 'Torres', '2015-08-15', 'Femenino', 11, 'Av. Tupac Amaru 1258', 'Primaria', 1, 'Angelitos', 11, 11, 'Padre'),
(12, 75123648, 'Rene', 'Perez', 'Gonzales', '2016-03-21', 'Masculino', 12, 'Jr. Huayna Cápac 369', 'Inicial', 2, 'Chiquititos', 12, 12, 'Madre'),
(13, 85231478, 'Paola', 'Garcia', 'Diaz', '2014-10-12', 'Femenino', 13, 'Av. Próceres 1245', 'Primaria', 5, 'Sagrado Corazon', 13, 13, 'Hermano'),
(14, 63258974, 'Alan', 'Flores', 'Lopez', '2013-12-02', 'Masculino', 14, 'Pasaje Santa Rosa 158', 'Secundaria', 1, 'San Felipe', 14, 14, 'Hermana'),
(15, 96325478, 'Luciana', 'Torres', 'Gomez', '2012-07-15', 'Femenino', 15, 'Jr. Union 654', 'Secundaria', 2, 'Nuestra Señora', 15, 15, 'Tio'),
(16, 45632189, 'Ramon', 'Garcia', 'Perez', '2011-02-05', 'Masculino', 16, 'Av. La Paz 478', 'Secundaria', 4, 'San Marcos', 16, 16, 'Tia'),
(17, 32156489, 'Fernanda', 'Ruiz', 'Diaz', '2010-11-25', 'Femenino', 17, 'Jr. Cajamarca 256', 'Secundaria', 5, 'Santa Ursula', 17, 17, 'Prima'),
(18, 89652123, 'Raul', 'Flores', 'Gonzales', '2009-09-15', 'Masculino', 18, 'Pasaje Los Claveles 789', 'Secundaria', 3, 'San Judas Tadeo', 18, 18, 'Primo'),
(19, 65841232, 'Martina', 'Gomez', 'Lopez', '2008-08-30', 'Femenino', 19, 'Calle Libertadores 365', 'Secundaria', 2, 'Santa Rosa', 19, 19, 'Hermana'),
(20, 96308520, 'Matias', 'Perez', 'Torres', '2007-07-18', 'Masculino', 20, 'Jr. Ayacucho 963', 'Secundaria', 1, 'Santo Domingo', 20, 20, 'Hermano'),
(21, 72769512, 'Neftaly', 'Paco', 'Moscoso', '2003-10-29', 'masculino', 3, 'Bajo el puente 127', 'Secundaria', 4, 'Willian norris', 2, 3, 'padre'),
(22, 73352725, 'Carmen Romina', 'URQUIZO', 'TTITO', '1998-10-10', 'femenino', 2, 'Micasita123', 'Secundaria', 5, 'Santa teresita', 3, 8, 'Hermano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distriitoalum`
--

CREATE TABLE `distriitoalum` (
  `id_distritoAlum` int(11) NOT NULL,
  `distritoA` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distriitoalum`
--

INSERT INTO `distriitoalum` (`id_distritoAlum`, `distritoA`) VALUES
(1, 'San Isidro'),
(2, 'Miraflores'),
(3, 'San Miguel'),
(4, 'Pueblo Libre'),
(5, 'Magdalena'),
(6, 'Comas'),
(7, 'Villa El Salvador'),
(8, 'Villa Maria del Triunfo'),
(9, 'San Juan de Lurigancho'),
(10, 'El Agustino'),
(11, 'Comas'),
(12, 'Villa El Salvador'),
(13, 'Villa Maria del Triunfo'),
(14, 'San Juan de Lurigancho'),
(15, 'El Agustino'),
(16, 'Los Olivos'),
(17, 'Puente Piedra'),
(18, 'Carabayllo'),
(19, 'Independencia'),
(20, 'San Martin de Porres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distritorepre`
--

CREATE TABLE `distritorepre` (
  `id_distritoR` int(11) NOT NULL,
  `distritoR` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distritorepre`
--

INSERT INTO `distritorepre` (`id_distritoR`, `distritoR`) VALUES
(1, 'San Borja'),
(2, 'Surco'),
(3, 'La Molina'),
(4, 'Jesus Maria'),
(5, 'Lince'),
(6, 'Breña'),
(7, 'Pueblo Libre'),
(8, 'Jesús María'),
(9, 'Lima'),
(10, 'Rímac'),
(11, 'Breña'),
(12, 'Pueblo Libre'),
(13, 'Jesús María'),
(14, 'Lima'),
(15, 'Rímac'),
(16, 'Cercado de Lima'),
(17, 'La Victoria'),
(18, 'San Isidro'),
(19, 'Miraflores'),
(20, 'San Borja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidad`
--

CREATE TABLE `habilidad` (
  `id_habilidad` int(11) NOT NULL,
  `habilidad` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habilidad`
--

INSERT INTO `habilidad` (`id_habilidad`, `habilidad`) VALUES
(1, 'Matematicas'),
(2, 'Ciencias'),
(3, 'Literatura'),
(4, 'Historia'),
(5, 'Artes'),
(6, 'Deportes'),
(7, 'Música'),
(8, 'Danza'),
(9, 'Teatro'),
(10, 'Pintura'),
(11, 'Deportes'),
(12, 'Música'),
(13, 'Danza'),
(14, 'Teatro'),
(15, 'Pintura'),
(16, 'Escultura'),
(17, 'Artesanía'),
(18, 'Cocina'),
(19, 'Repostería'),
(20, 'Bordado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iniciosesion`
--

CREATE TABLE `iniciosesion` (
  `id_Usuario` varchar(30) NOT NULL,
  `contra` varchar(30) NOT NULL,
  `id_admini` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `iniciosesion`
--

INSERT INTO `iniciosesion` (`id_Usuario`, `contra`, `id_admini`) VALUES
('ana987', 'zxcvbn', 4),
('carlos654', '098765', 5),
('daniela987', '098765', 9),
('jorge654', 'abc123', 10),
('juan123', 'abc123', 1),
('luis789', 'qwerty', 3),
('maria456', '123456', 2),
('miguel123', 'asdfgh', 6),
('pablo789', '123456', 8),
('sandra456', 'qwerty', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `id_Matricula` int(15) NOT NULL,
  `id_Alumno` int(15) NOT NULL,
  `nivel_m` varchar(30) NOT NULL,
  `grado_m` int(15) NOT NULL,
  `estado_m` varchar(30) NOT NULL,
  `metodo_Pago` varchar(30) NOT NULL,
  `monto_Pago` double NOT NULL,
  `observaciones` varchar(30) NOT NULL,
  `id_Usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id_Matricula`, `id_Alumno`, `nivel_m`, `grado_m`, `estado_m`, `metodo_Pago`, `monto_Pago`, `observaciones`, `id_Usuario`) VALUES
(1, 1, 'Primaria', 3, 'Matriculado', 'Efectivo', 350, 'Ninguna', 'juan123'),
(2, 2, 'Primaria', 2, 'Matriculado', 'Tarjeta', 350, 'Ninguna', 'maria456'),
(3, 3, 'Primaria', 4, 'Matriculado', 'Efectivo', 380, 'Becado', 'luis789'),
(4, 4, 'Primaria', 5, 'Matriculado', 'Efectivo', 400, 'Ninguna', 'ana987'),
(5, 5, 'Inicial', 3, 'Matriculado', 'Tarjeta', 330, 'Ninguna', 'carlos654'),
(6, 6, 'Primaria', 2, 'Matriculado', 'Efectivo', 350, 'Ninguna', 'miguel123'),
(7, 7, 'Inicial', 3, 'Matriculado', 'Tarjeta', 320, 'Ninguna', 'sandra456'),
(8, 8, 'Primaria', 6, 'Matriculado', 'Efectivo', 420, 'Becado', 'pablo789'),
(9, 9, 'Secundaria', 2, 'Matriculado', 'Efectivo', 390, 'Ninguna', 'daniela987'),
(10, 10, 'Secundaria', 3, 'Matriculado', 'Tarjeta', 410, 'Ninguna', 'jorge654'),
(11, 11, 'Primaria', 2, 'Matriculado', 'Efectivo', 350, 'Ninguna', 'ana987');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
--

CREATE TABLE `representante` (
  `id_Repre` int(11) NOT NULL,
  `dni_Repre` int(15) NOT NULL,
  `nom_Repre` varchar(30) NOT NULL,
  `ape_PRe` varchar(30) NOT NULL,
  `ape_MRe` varchar(30) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `id_distritoR` int(15) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `ocupacion` varchar(30) NOT NULL,
  `lugar_traba` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `id_telefono` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `representante`
--

INSERT INTO `representante` (`id_Repre`, `dni_Repre`, `nom_Repre`, `ape_PRe`, `ape_MRe`, `sexo`, `id_distritoR`, `domicilio`, `ocupacion`, `lugar_traba`, `correo`, `id_telefono`) VALUES
(1, 45896325, 'Luis', 'Garcia', 'Torres', 'Masculino', 1, 'Av. Principal 123', 'Contador', 'Empresa SAC', 'lgarcia@email.com', 1),
(2, 45879632, 'Rosa', 'Flores', 'Perez', 'Femenino', 2, 'Av. Central 456', 'Enfermera', 'Hospital regional', 'rflores@email.com', 2),
(3, 75123649, 'Daniel', 'Rodriguez', 'Gonzales', 'Masculino', 3, 'Calle 15 N° 25-36', 'Profesor', 'Colegio San Marcos', 'drodriguez@email.com', 3),
(4, 85274196, 'Lucia', 'Martinez', 'Lopez', 'Femenino', 4, 'Av. Los Olivos 789', 'Secretaria', 'Clinica privada', 'lmartinez@email.com', 4),
(5, 96385274, 'Sofia', 'Gonzales', 'Diaz', 'Femenino', 5, 'Pasaje 10 N° 50-23', 'Vendedora', 'Tienda departamental', 'sgonzales@email.com', 5),
(6, 45621359, 'Mario', 'Rodriguez', 'Lopez', 'Masculino', 6, 'Jr. Union 456', 'Chofer', 'Empresa de transportes', 'mrodriguez@email.com', 6),
(7, 65487213, 'Laura', 'Gonzales', 'Perez', 'Femenino', 7, 'Pasaje 15 N° 36-85', 'Enfermera', 'Clínica local', 'lgonzales@email.com', 7),
(8, 32159874, 'Diego', 'Gomez', 'Diaz', 'Masculino', 8, 'Av. Tupac Amaru 963', 'Vendedor', 'Supermercado Plaza Vea', 'dgomez@email.com', 8),
(9, 75412358, 'Karla', 'Torres', 'Flores', 'Femenino', 9, 'Av. Universitaria 741', 'Estudiante', 'Universidad de Lima', 'ktorres@email.com', 9),
(10, 85236974, 'Oscar', 'Lopez', 'Garcia', 'Masculino', 10, 'Jr. Heroes Navales 785', 'Profesor', 'Colegio Innova Schools', 'olopez@email.com', 10),
(11, 45621359, 'Mario', 'Rodriguez', 'Lopez', 'Masculino', 6, 'Jr. Union 456', 'Chofer', 'Empresa transportes', 'mrodriguez@email.com', 6),
(12, 65487213, 'Laura', 'Gonzales', 'Perez', 'Femenino', 7, 'Pasaje 15 N° 36-85', 'Enfermera', 'Clínica local', 'lgonzales@email.com', 7),
(13, 32159874, 'Diego', 'Gomez', 'Diaz', 'Masculino', 8, 'Av. Tupac Amaru 963', 'Vendedor', 'Supermercado Plaza Vea', 'dgomez@email.com', 8),
(14, 75412358, 'Karla', 'Torres', 'Flores', 'Femenino', 9, 'Av. Universitaria 741', 'Estudiante', 'Universidad de Lima', 'ktorres@email.com', 9),
(15, 85236974, 'Oscar', 'Lopez', 'Garcia', 'Masculino', 10, 'Jr. Heroes Navales 785', 'Profesor', 'Colegio Innova Schools', 'olopez@email.com', 10),
(16, 96302410, 'Erika', 'Sanchez', 'Vargas', 'Femenino', 11, 'Calle Los Cedros 125', 'Secretaria', 'Empresa de seguros', 'esanchez@email.com', 11),
(17, 32010547, 'Henry', 'Cruz', 'Ramos', 'Masculino', 12, 'Jr. Progreso 852', 'Taxista', 'Empresa de taxis', 'hcruz@email.com', 12),
(18, 12045785, 'Fiorella', 'Aguilar', 'Villegas', 'Femenino', 13, 'Pasaje Talara 257', 'Enfermera', 'Clínica Internacional', 'faguilar@email.com', 13),
(19, 87541236, 'Roberto', 'Serrano', 'Reyes', 'Masculino', 14, 'Av. Javier Prado 852', 'Vigilante', 'Edificio corporativo', 'rserrano@email.com', 14),
(20, 23659871, 'Melissa', 'Benavides', 'Osorio', 'Femenino', 15, 'Jr. Libertad 526', 'Vendedora', 'Tienda por departamento', 'mbenavides@email.com', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono`
--

CREATE TABLE `telefono` (
  `id_telefono` int(11) NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `telefono`
--

INSERT INTO `telefono` (`id_telefono`, `telefono`) VALUES
(1, 987654321),
(2, 123456789),
(3, 912345678),
(4, 456789123),
(5, 789456123),
(6, 456123789),
(7, 258963147),
(8, 147258369),
(9, 369258147),
(10, 963258741),
(11, 456123789),
(12, 258963147),
(13, 147258369),
(14, 369258147),
(15, 963258741),
(16, 741258963),
(17, 852147896),
(18, 963852147),
(19, 258961470),
(20, 147025896);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_admini`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_Alumno`),
  ADD KEY `habilidad` (`id_habilidad`),
  ADD KEY `distriA` (`id_distritoAlum`),
  ADD KEY `repre` (`id_Repre`);

--
-- Indices de la tabla `distriitoalum`
--
ALTER TABLE `distriitoalum`
  ADD PRIMARY KEY (`id_distritoAlum`);

--
-- Indices de la tabla `distritorepre`
--
ALTER TABLE `distritorepre`
  ADD PRIMARY KEY (`id_distritoR`);

--
-- Indices de la tabla `habilidad`
--
ALTER TABLE `habilidad`
  ADD PRIMARY KEY (`id_habilidad`);

--
-- Indices de la tabla `iniciosesion`
--
ALTER TABLE `iniciosesion`
  ADD PRIMARY KEY (`id_Usuario`),
  ADD KEY `administrador` (`id_admini`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_Matricula`),
  ADD KEY `alumno` (`id_Alumno`),
  ADD KEY `usuario` (`id_Usuario`);

--
-- Indices de la tabla `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`id_Repre`),
  ADD KEY `tele` (`id_telefono`),
  ADD KEY `distriRe` (`id_distritoR`);

--
-- Indices de la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD PRIMARY KEY (`id_telefono`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_admini` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_Alumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `distriitoalum`
--
ALTER TABLE `distriitoalum`
  MODIFY `id_distritoAlum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `distritorepre`
--
ALTER TABLE `distritorepre`
  MODIFY `id_distritoR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `habilidad`
--
ALTER TABLE `habilidad`
  MODIFY `id_habilidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id_Matricula` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `representante`
--
ALTER TABLE `representante`
  MODIFY `id_Repre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `telefono`
--
ALTER TABLE `telefono`
  MODIFY `id_telefono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `distriA` FOREIGN KEY (`id_distritoAlum`) REFERENCES `distriitoalum` (`id_distritoAlum`),
  ADD CONSTRAINT `habilidad` FOREIGN KEY (`id_habilidad`) REFERENCES `habilidad` (`id_habilidad`),
  ADD CONSTRAINT `repre` FOREIGN KEY (`id_Repre`) REFERENCES `representante` (`id_Repre`);

--
-- Filtros para la tabla `iniciosesion`
--
ALTER TABLE `iniciosesion`
  ADD CONSTRAINT `administrador` FOREIGN KEY (`id_admini`) REFERENCES `administrador` (`id_admini`);

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `alumno` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id_Alumno`),
  ADD CONSTRAINT `usuario` FOREIGN KEY (`id_Usuario`) REFERENCES `iniciosesion` (`id_Usuario`);

--
-- Filtros para la tabla `representante`
--
ALTER TABLE `representante`
  ADD CONSTRAINT `distriRe` FOREIGN KEY (`id_distritoR`) REFERENCES `distritorepre` (`id_distritoR`),
  ADD CONSTRAINT `tele` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id_telefono`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
