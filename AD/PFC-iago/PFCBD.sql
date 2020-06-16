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


-- Volcando estructura de base de datos para pfc
CREATE DATABASE IF NOT EXISTS `pfc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pfc`;

-- Volcando estructura para tabla pfc.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `titulo` varchar(50) NOT NULL,
  `id` int(11) NOT NULL DEFAULT 0,
  `descripcion` varchar(1000) NOT NULL,
  `login_restaurante` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_menu_registro_restaurante` (`login_restaurante`),
  CONSTRAINT `FK_menu_registro_restaurante` FOREIGN KEY (`login_restaurante`) REFERENCES `registro_restaurante` (`login`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla pfc.registro_cliente
CREATE TABLE IF NOT EXISTS `registro_cliente` (
  `login` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `contrasenha` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla pfc.registro_restaurante
CREATE TABLE IF NOT EXISTS `registro_restaurante` (
  `contrasenha` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `nombre_hosteleria` varchar(50) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
