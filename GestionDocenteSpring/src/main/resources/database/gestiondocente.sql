-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2017 a las 13:37:45
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
DROP DATABASE `gestiondocente`;
CREATE DATABASE IF NOT EXISTS `gestiondocente` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `gestiondocente`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `alumnodelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnodelete` (IN `codigo` INT)  NO SQL
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
(1, 'Sergio', 'Aparicio Vargas', '2017-02-01', NULL, NULL, NULL, 944, 'aaaa@aaaa.com', '44974398z', NULL, 1);

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
  `identificador` varchar(15) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `email`, `telefono`, `direccion`, `poblacion`, `codigopostal`, `identificador`) VALUES
(1, 'SERIKAT CONSULTORÍA E INFORMÁTICA, S.A.', 'info@serikat.es', 944250100, 'c/ Ercilla 19', 'Bilbao', 48009, 'A-48476006');

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
  `email` varchar(150) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`) VALUES
(1, 481234567840, 'Urko', 'Villanueva Alvarez', '1980-11-24', '30692126z', 'Travesia de Trauko 26 1D', 'Bilbao', NULL, 944, 'uvillanueva@ipartek.com');

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
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
