-- http://www.phpmyadmin.net
  --
  -- Servidor: 127.0.0.1
 --- Tiempo de generación: 10-02-2017 a las 09:41:59
 -- Tiempo de generación: 11-02-2017 a las 12:17:10
  -- Versión del servidor: 5.7.9
  -- Versión de PHP: 5.6.16
  
 SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
 SET time_zone = "+01:00";
 
 
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
  DROP PROCEDURE IF EXISTS `alumnogetAll`$$
  CREATE DEFINER=`admin`@`%` PROCEDURE `alumnogetAll` ()  NO SQL
  BEGIN

 	SELECT `codigo`, `nombre`, `apellidos`, `fNacimiento`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `dni`, `nHermanos`, `activo` 
 	FROM `alumno`;
  END$$
  
  DROP PROCEDURE IF EXISTS `clientegetAll`$$
  CREATE DEFINER=`admin`@`%` PROCEDURE `clientegetAll` ()  NO SQL
  BEGIN

 	SELECT`codigo`, `nombre`, `email`, `telefono`, `direccion`, `poblacion`, `codigopostal`,`identificador` 
	FROM `cliente`;
 END$$
 
 DROP PROCEDURE IF EXISTS `profesorgetAll`$$
 CREATE DEFINER=`admin`@`%` PROCEDURE `profesorgetAll` ()  NO SQL
 BEGIN
 
 	SELECT `codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email` 
 	FROM `profesor`;
 
  END$$
  
  DELIMITER ;
 
 -- --------------------------------------------------------
 
 --
 -- Estructura de tabla para la tabla `alumno`
 --
 
 DROP TABLE IF EXISTS `alumno`;
 CREATE TABLE IF NOT EXISTS `alumno` (
   `codigo` int(11) NOT NULL AUTO_INCREMENT,
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
 
   `activo` tinyint(1) DEFAULT '1',
    PRIMARY KEY (`codigo`)
  ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
  
 --
 -- Volcado de datos para la tabla `alumno`
  --
  
  INSERT INTO `alumno` (`codigo`, `nombre`, `apellidos`, `fNacimiento`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `dni`, `nHermanos`, `activo`) VALUES
 
 (1, 'Sergio', 'Aparicio Vargas', '2017-02-01', NULL, NULL, NULL, 944, 'aaaa@aaaa.com', '44974398z', 0, 1);
  
  -- --------------------------------------------------------
  
 --
 -- Estructura de tabla para la tabla `cliente`
 --
 
 DROP TABLE IF EXISTS `cliente`;
 CREATE TABLE IF NOT EXISTS `cliente` (
    `codigo` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` text COLLATE utf8_bin NOT NULL,
    `email` varchar(150) COLLATE utf8_bin NOT NULL,
    `telefono` int(9) NOT NULL,
    `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
    `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
    `codigopostal` int(5) DEFAULT NULL,
    `identificador` varchar(15) COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`codigo`)
  ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
 
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
 CREATE TABLE IF NOT EXISTS `profesor` (
   `codigo` int(11) NOT NULL AUTO_INCREMENT,
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
   PRIMARY KEY (`codigo`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
 
 --
 -- Volcado de datos para la tabla `profesor`
  --
  
  INSERT INTO `profesor` (`codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`) VALUES
 (1, 481234567840, 'Urko', 'Villanueva Alvarez', '1976-11-24', '30693142x', 'Av. Mazustegi 9', 'Bilbao', 48009, 944, 'uvillanueva@ipartek.com');
  
  /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
  /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
  /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;