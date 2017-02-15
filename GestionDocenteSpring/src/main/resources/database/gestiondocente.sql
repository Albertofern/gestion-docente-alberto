-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2017 a las 12:55:00
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestiondocente`
--
CREATE DATABASE IF NOT EXISTS `gestiondocente` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `gestiondocente`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `alumnoCreate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoCreate` (IN `papellidos` VARCHAR(250), IN `pcodigopostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnHermanos` INT(2), IN `pnombre` VARCHAR(50), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9), OUT `pcodigo` INT)  NO SQL
BEGIN 
INSERT INTO alumno(
nombre,
apellidos,
dni,
email,
direccion,
codigopostal,
poblacion,
fNacimiento,
telefono,
nHermanos) VALUES(LOWER(pnombre),
LOWER(papellidos),
LOWER(pdni),
LOWER(pemail),
LOWER(pdireccion),
pcodigopostal,
LOWER(ppoblacion),
pfNacimiento,
ptelefono,
pnHermanos);
SET pcodigo = LAST_INSERT_ID();
END$$

DROP PROCEDURE IF EXISTS `alumnoDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoDelete` (IN `pcodigo` INT)  NO SQL
BEGIN
   DELETE FROM alumno WHERE codigo = pcodigo;
END$$

DROP PROCEDURE IF EXISTS `alumnogetAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnogetAll` ()  NO SQL
BEGIN
	SELECT a.codigo,a.nombre,a.apellidos,a.fNacimiento,a.direccion,
    a.poblacion,a.codigopostal,a.telefono,a.email,a.dni,a.nHermanos,
    a.activo
    FROM alumno as a;
END$$

DROP PROCEDURE IF EXISTS `alumnogetById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnogetById` (IN `pcodigo` INT)  NO SQL
BEGIN
	SELECT a.codigo,a.nombre,a.apellidos,a.fNacimiento,a.direccion,
    a.poblacion,a.codigopostal,a.telefono,a.email,a.dni,a.nHermanos,
    a.activo
    FROM alumno as a
    WHERE codigo = pcodigo;  
END$$

DROP PROCEDURE IF EXISTS `alumnoUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoUpdate` (IN `papellidos` VARCHAR(250), IN `pcodigo` INT, IN `pcodigopostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pemail` VARCHAR(150), IN `pfNacimiento` DATE, IN `pnHermanos` INT(2), IN `pnombre` VARCHAR(50), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9))  NO SQL
BEGIN
UPDATE alumno 
SET nombre = LOWER(pnombre),apellidos = LOWER(papellidos), dni = LOWER(pdni),email = LOWER(pemail),direccion=LOWER(pdireccion),codigopostal=pcodigopostal,poblacion=LOWER(ppoblacion),fNacimiento=pfNacimiento,telefono=ptelefono,nHermanos=pnHermanos
WHERE codigo = pcodigo;
END$$

DROP PROCEDURE IF EXISTS `clienteCreate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clienteCreate` (IN `pcodigopostal` INT(5), IN `pdireccion` VARCHAR(250), IN `pidentificador` VARCHAR(15), IN `pemail` VARCHAR(150), IN `pnombre` VARCHAR(50), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9), OUT `pcodigo` INT)  BEGIN 
INSERT INTO cliente(
nombre,
identificador,
telefono,
email,
direccion,
codigopostal,
poblacion
) VALUES(LOWER(pnombre),
pidentificador,
ptelefono,
LOWER(pemail),
LOWER(pdireccion),
pcodigopostal,
LOWER(ppoblacion));
SET pcodigo = LAST_INSERT_ID();
END$$

DROP PROCEDURE IF EXISTS `clienteDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clienteDelete` (IN `pcodigo` INT)  NO SQL
BEGIN
   DELETE FROM cliente WHERE codigo = pcodigo;
END$$

DROP PROCEDURE IF EXISTS `clientegetAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientegetAll` ()  NO SQL
BEGIN
	SELECT c.codigo,c.nombre,c.identificador,c.telefono,c.email,c.direccion,c.codigopostal,c.poblacion,c.activo
    FROM cliente as c;
END$$

DROP PROCEDURE IF EXISTS `clientegetById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientegetById` (IN `pcodigo` INT)  NO SQL
BEGIN
	SELECT c.codigo,c.nombre,c.identificador,c.telefono,c.email,c.direccion,c.codigopostal,c.poblacion,c.activo
    FROM cliente as c
    WHERE codigo = pcodigo;  
END$$

DROP PROCEDURE IF EXISTS `clienteUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `clienteUpdate` (IN `pcodigo` INT, IN `pdireccion` VARCHAR(250), IN `pidentificador` INT(15), IN `pemail` VARCHAR(150), IN `pnombre` VARCHAR(50), IN `ppoblacion` VARCHAR(150), IN `ptelefono` INT(9), IN `pcodigopostal` INT(5))  NO SQL
BEGIN
UPDATE cliente 
SET nombre = LOWER(pnombre),identificador = papellidos, telefono =ptelefono,email = LOWER(pemail),direccion=LOWER(pdireccion),codigopostal=pcodigopostal,poblacion=LOWER(ppoblacion)
WHERE codigo = pcodigo;
END$$

DROP PROCEDURE IF EXISTS `profesorCreate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `profesorCreate` (IN `pnombre` VARCHAR(150), IN `papellidos` VARCHAR(250), IN `pdni` VARCHAR(9), IN `ptelefono` INT(9), IN `pemail` VARCHAR(150), IN `pnss` VARCHAR(12), IN `pfNacimiento` DATE, IN `pdireccion` VARCHAR(150), IN `pcodigopostal` INT(5), OUT `pcodigo` INT)  BEGIN
	INSERT INTO profesor(
    nombre,
    apellidos,
    dni,
    telefono,
    email,
    nss,
    fNacimiento,
    direccion,
    codigopostal
    ) VALUES(LOWER(pnombre),
    papellidos,
    pdni,
    ptelefono,
    pemail,
    pnss,
    pfNacimiento,
    pdireccion,
    pcodigopostal);
    SET pcodigo = LAST_INSERT_ID();
END$$

DROP PROCEDURE IF EXISTS `profesorDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `profesorDelete` (IN `pcodigo` INT)  NO SQL
BEGIN
   DELETE FROM profesor WHERE codigo = pcodigo;
END$$

DROP PROCEDURE IF EXISTS `profesorgetAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `profesorgetAll` ()  NO SQL
BEGIN
	SELECT p.codigo,p.nombre,p.apellidos,p.fNacimiento,p.direccion,
    p.poblacion,p.codigopostal,p.telefono,p.email,p.dni,
    p.activo,p.nss,p.dni
    FROM profesor as p;
END$$

DROP PROCEDURE IF EXISTS `profesorgetById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `profesorgetById` (IN `pcodigo` INT)  NO SQL
    DETERMINISTIC
BEGIN
	SELECT p.codigo,p.nombre,p.apellidos,p.fNacimiento,p.direccion,p.codigopostal,p.telefono,p.email,p.dni,p.nss,p.activo
    FROM profesor as p
    WHERE codigo = pcodigo;  
END$$

DROP PROCEDURE IF EXISTS `profesorUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `profesorUpdate` (IN `pnombre` VARCHAR(50), IN `papellidos` VARCHAR(250), IN `pdni` VARCHAR(9), IN `pnss` INT(12), IN `pemail` VARCHAR(150), IN `pdireccion` VARCHAR(250), IN `pcodigopostal` INT(5), IN `pfNacimiento` DATE, IN `ptelefono` INT(9), IN `pcodigo` INT)  NO SQL
BEGIN
UPDATE profesor
SET nombre = LOWER(pnombre),apellidos = LOWER(papellidos), dni = LOWER(pdni),nss=pnss,email = LOWER(pemail),direccion=pdireccion,codigopostal=pcodigopostal,fNacimiento=LOWER(pfNacimiento),telefono=ptelefono
WHERE codigo = pcodigo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `dni` varchar(9) COLLATE utf8_bin NOT NULL,
  `nHermanos` int(2) DEFAULT '0',
  `activo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `nombre`, `apellidos`, `fNacimiento`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `dni`, `nHermanos`, `activo`) VALUES
(3, 'alberto', 'fernandez', '1992-05-03', 'belostikalle 9', 'bilbao', 48005, 688810557, 'alberto@gmail.com', '45751515f', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL,
  `nombre` text COLLATE utf8_bin NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `telefono` int(9) NOT NULL,
  `direccion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(6) DEFAULT NULL,
  `identificador` varchar(15) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `email`, `telefono`, `direccion`, `poblacion`, `codigopostal`, `identificador`, `activo`) VALUES
(1, 'SERIKAT CONSULTORÍA E INFORMÁTICA, S.A.', 'info@serikat.es', 944250100, 'c/ Ercilla 19', 'Bilbao', 48009, 'A-48476006', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE `profesor` (
  `codigo` int(11) NOT NULL,
  `NSS` bigint(12) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `DNI` varchar(9) COLLATE utf8_bin NOT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `activo`) VALUES
(1, 481234567840, 'Urko', 'Villanueva Alvarez', '1980-11-24', '30692126z', 'Travesia de Trauko 26 1D', 'Bilbao', NULL, 944, 'uvillanueva@ipartek.com', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
