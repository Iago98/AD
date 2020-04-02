-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para acisedb
CREATE DATABASE IF NOT EXISTS `acisedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `acisedb`;

-- Volcando estructura para tabla acisedb.area
CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.enunciado
CREATE TABLE IF NOT EXISTS `enunciado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(400) NOT NULL DEFAULT '0',
  `id_area` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_enunciados_areas` (`id_area`),
  CONSTRAINT `FK_enunciados_areas` FOREIGN KEY (`id_area`) REFERENCES `area` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.enunciado_tag
CREATE TABLE IF NOT EXISTS `enunciado_tag` (
  `id_tag` int(11) NOT NULL,
  `id_enunciado` int(11) NOT NULL,
  PRIMARY KEY (`id_tag`,`id_enunciado`),
  KEY `FK__tags` (`id_tag`),
  KEY `FK__enunciados2` (`id_enunciado`),
  CONSTRAINT `FK__enunciados2` FOREIGN KEY (`id_enunciado`) REFERENCES `enunciado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__tags` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.examen
CREATE TABLE IF NOT EXISTS `examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nota` float DEFAULT NULL,
  `dni_usuario` varchar(9) NOT NULL,
  `incorrectas` int(11) DEFAULT NULL,
  `noRespondidas` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `tiempo` float DEFAULT NULL,
  `correctas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_examen_usuarios` (`dni_usuario`),
  CONSTRAINT `FK_examen_usuarios` FOREIGN KEY (`dni_usuario`) REFERENCES `usuario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.examen_enunciado
CREATE TABLE IF NOT EXISTS `examen_enunciado` (
  `id_enunciado` int(11) DEFAULT NULL,
  `id_examen` int(11) DEFAULT NULL,
  KEY `FK__enunciados` (`id_enunciado`),
  KEY `FK__examen` (`id_examen`),
  CONSTRAINT `FK__enunciados` FOREIGN KEY (`id_enunciado`) REFERENCES `enunciado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__examen` FOREIGN KEY (`id_examen`) REFERENCES `examen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKrryjm6prcl3oqioi0n261935a` FOREIGN KEY (`id_examen`) REFERENCES `examen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.respuesta
CREATE TABLE IF NOT EXISTS `respuesta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(50) NOT NULL DEFAULT '0',
  `id_enunciado` int(11) NOT NULL DEFAULT 0,
  `correcta` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_respuestas_enunciados` (`id_enunciado`),
  CONSTRAINT `FK_respuestas_enunciados` FOREIGN KEY (`id_enunciado`) REFERENCES `enunciado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla acisedb.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` varchar(9) NOT NULL,
  `clave` varchar(30) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
