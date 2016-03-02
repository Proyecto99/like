-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2016 at 03:20 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `datos`
--

-- --------------------------------------------------------

--
-- Table structure for table `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
  `idCiudad` int(123) NOT NULL AUTO_INCREMENT,
  `idEstado` int(123) DEFAULT NULL,
  `nombre` varchar(123) DEFAULT NULL,
  `descripcion` varchar(213) NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `idEstado` int(123) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(213) DEFAULT NULL,
  `descripcion` varchar(213) NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`idEstado`, `nombre`, `descripcion`) VALUES
(1, 'Chiapas', 'Pozol'),
(2, 'Mentirosa', 'No hay nada ahí');

-- --------------------------------------------------------

--
-- Table structure for table `lugar`
--

CREATE TABLE IF NOT EXISTS `lugar` (
  `idLugar` bigint(213) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(123) NOT NULL,
  `descripcion` varchar(232) NOT NULL,
  `poblacion` varchar(123) NOT NULL,
  `coordenada` varchar(123) NOT NULL,
  `idEstado` int(213) NOT NULL,
  PRIMARY KEY (`idLugar`),
  UNIQUE KEY `nombre` (`nombre`,`descripcion`,`poblacion`,`coordenada`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `lugar`
--

INSERT INTO `lugar` (`idLugar`, `nombre`, `descripcion`, `poblacion`, `coordenada`, `idEstado`) VALUES
(1, 'Tangamangapio', 'Mi pueblito natal con crepusculos arrebolados', '100', '-12312', 1);

-- --------------------------------------------------------

--
-- Table structure for table `recomendar`
--

CREATE TABLE IF NOT EXISTS `recomendar` (
  `idRecomendar` int(121) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(213) NOT NULL,
  `fecha` varchar(213) NOT NULL,
  `comentario` varchar(213) NOT NULL,
  `calificacion` int(123) NOT NULL,
  `idLugar` int(123) NOT NULL,
  `estado` varchar(212) NOT NULL,
  `idEstado` int(123) NOT NULL,
  PRIMARY KEY (`idRecomendar`),
  UNIQUE KEY `comentario` (`comentario`),
  UNIQUE KEY `fecha` (`fecha`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `recomendar`
--

INSERT INTO `recomendar` (`idRecomendar`, `nombre`, `fecha`, `comentario`, `calificacion`, `idLugar`, `estado`, `idEstado`) VALUES
(1, 'Lorena', '02/04/13', 'Mi lugar de nacimiento', 5, 1, 'Queretaro', 0),
(2, 'Karen', '05/06/16', 'La reunión del abuelo', 2, 2, 'Veracruz', 0);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `idRol` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`idRol`, `nombre`, `descripcion`) VALUES
(1, 'Lilly', 'Asistente');

-- --------------------------------------------------------

--
-- Table structure for table `usuariorol`
--

CREATE TABLE IF NOT EXISTS `usuariorol` (
  `idUsuario` bigint(20) NOT NULL,
  `idRol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` bigint(20) NOT NULL,
  `nombrePrefijo` varchar(255) DEFAULT NULL,
  `nombreNombre` varchar(255) DEFAULT NULL,
  `nombreApellidoPaterno` varchar(255) DEFAULT NULL,
  `nombreApellidoMaterno` varchar(255) DEFAULT NULL,
  `nombrePosfijo` varchar(255) DEFAULT NULL,
  `nombreIniciales` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `claveAcceso` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
