-- MySQL dump 10.19  Distrib 10.3.29-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: publisher
-- ------------------------------------------------------
-- Server version	10.3.29-MariaDB-1:10.3.29+maria~bionic

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CaracteristicasProducto`
--

CREATE DATABASE publisher;
USE publisher;

DROP TABLE IF EXISTS `CaracteristicasProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CaracteristicasProducto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `descripcion` varchar(256) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CaracteristicasProducto`
--

LOCK TABLES `CaracteristicasProducto` WRITE;
/*!40000 ALTER TABLE `CaracteristicasProducto` DISABLE KEYS */;
INSERT INTO `CaracteristicasProducto` VALUES (1,1,'Su resolucion XY',1),(2,1,'Manejalo con la voz',1),(3,1,'Conecta tus dispositivos',1),(4,1,'Dimensiones',1),(5,1,'Entretenimiento',1),(6,2,'Incluye control',1),(7,2,'Resolucion en 3840 x 2160 px',1),(8,2,'Memoria ram de 16 gb',1),(9,2,'Horas de diversion garantizadas',1),(10,2,'Cuenta con: 1 dock, 1 cable de alimentacion, 1 cable hdmi, 1 cable usb, 1 material impreso',1),(11,2,'La duracion de la bateria de lo controles depende del uso del producto',1),(12,3,'2500 rpm',1),(13,3,'110 volts CA',1),(14,3,'950 watts',1),(15,4,'Posee 2 conectores de entrada y 2 de salida',1),(16,4,'Cuenta con una resolución de audio de 24bit',1),(17,4,'Software compatible: Live lite/Pro tools first/Garageband/Auria pro/FL studio',1),(18,4,'Complatible con MIDI',1),(19,4,'Tipo de alimentación: USB',1),(20,4,'Tiene una frecuencia de muestreo de 192kHz',1),(21,4,'Conectores: 1 XLR/1 phone TRS 6.3 mm/1 line TRS-TS L/R 6.3 mm out/1 USB-C 2.0',1),(22,4,'Sonido profesional y de calidad',1);
/*!40000 ALTER TABLE `CaracteristicasProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ImagenProducto`
--

DROP TABLE IF EXISTS `ImagenProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ImagenProducto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `nombre_imagen` varchar(256) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ImagenProducto`
--

LOCK TABLES `ImagenProducto` WRITE;
/*!40000 ALTER TABLE `ImagenProducto` DISABLE KEYS */;
INSERT INTO `ImagenProducto` VALUES (1,1,'D-1.jpg',1),(2,1,'D-2.jpg',1),(3,1,'D-3.jpg',1),(4,1,'D-4.jpg',1),(5,1,'D-5.jpg',1),(6,2,'02-01.jpg',1),(7,2,'02-02.jpg',1),(8,3,'03-01.jpg',1),(9,4,'04-01.jpg',1),(10,3,'03-02.jpg',1),(11,4,'04-02.jpg',1),(12,4,'04-03.jpg',1);
/*!40000 ALTER TABLE `ImagenProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mueble`
--

DROP TABLE IF EXISTS `Mueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mueble` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) DEFAULT NULL,
  `color` varchar(64) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `agotado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mueble`
--

LOCK TABLES `Mueble` WRITE;
/*!40000 ALTER TABLE `Mueble` DISABLE KEYS */;
INSERT INTO `Mueble` VALUES (1,'cama','roja',1246,1),(2,'mesa','verde',2246,0),(3,'silla','azul',3246,1),(4,'ropero','negra',4246,0),(5,'estufa','blanco',5246,1);
/*!40000 ALTER TABLE `Mueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) DEFAULT NULL,
  `apPat` varchar(64) DEFAULT NULL,
  `apMaterno` varchar(64) DEFAULT NULL,
  `sueldo` decimal(10,0) DEFAULT NULL,
  `genero` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'Gustavo','Arellano','Fox',111,1),(2,'Adolfo','Sandoval','Slim',222,0),(3,'Luis','Torres','perez',322,0),(4,'Pedro','Lopez','Rodriguez',422,0),(5,'Mario','Casa','Rios',522,0);
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE Mueble;
DROP TABLE Persona;


--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) DEFAULT NULL,
  `total_stars` decimal(10,0) DEFAULT NULL,
  `votos_totales` int(11) DEFAULT NULL,
  `vendidas` int(11) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `mensualidad` int(11) DEFAULT NULL,
  `minutos` int(11) DEFAULT NULL,
  `direccion` varchar(256) DEFAULT NULL,
  `num_ventas` int(11) DEFAULT NULL,
  `total_prod` int(11) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `tienda` varchar(128) DEFAULT NULL,
  `total_ventas` int(11) DEFAULT NULL,
  `meses` int(11) DEFAULT NULL,
  `espec_dia` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,'Pantalla JVC SI32H LCD HD 32 110V/240V',4,23,63,2916,917,57,'Cuernavaca Morelos',500,32,24,'Glogi',1000,3,'Martes'),(2,'Sony PlayStation 5 825GB color blanco y negro',5,500,500,13594,1359,180,'Jiutepec Morelos',7000,1,89,'Sony enterteiment',900,10,'Domingo'),(3,'Metabo Ge 950 G Plus Mototool/rectificador Recto 950w 110v',4,2,4,7978,664,180,'Tlaltizapan Morelos',5,10,1,'Metabo',40,12,'Jueves'),(4,'Interfaz de audio Focusrite Scarlett Solo 220V roja 3.ª gen',5,68,500,2756,275,250,'Tepoztlan Morelos',100,5,1,'Milan Inter',100,10,'Miercoles');
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-14 13:12:11
