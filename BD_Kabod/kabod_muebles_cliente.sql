-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: kabod_muebles
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Id_Cliente` int NOT NULL,
  `Nombre_Cliente` varchar(100) NOT NULL,
  `Telefono_Cliente` varchar(15) DEFAULT NULL,
  `Email_Cliente` varchar(100) NOT NULL,
  `Direccion_Cliente` varchar(200) NOT NULL,
  `Id_Vendedor` int DEFAULT NULL,
  `Contraseña` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Cliente`),
  KEY `Id_Vendedor` (`Id_Vendedor`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`Id_Vendedor`) REFERENCES `vendedor` (`Id_Vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (12345,'Alberto Salas Act','3001112222','alberto_actualizado@gmail.com','Nueva dirección 456',1,'Salas**'),(12346,'María García','31055667','maria.garcia@gmail.com','Carrera 45 #12-34',3,'Maria**'),(12347,'Luis Fernández','31233456','luis.fernandez@gmail.com','carrera 5 # 11-50 apt 504',2,'Luis**'),(1087463,'Camila Morales','3213453456','Camila_mm@gmail.com','carrera 9 # 11-50 apt 1002',4,'Camila**'),(10080574,'Manuela Morales','3032234567','ManuelaMM@gamil.com','Calle 5 #10-29',NULL,'Manuela**'),(10875365,'Mauricio Lopez','3225467856','Mauro_Loz@gmail.com','Calle 8 #17-5',2,'Mauricio**'),(102873645,'Juan Pérez','3216549870','juan@gmail.com','calle 4#12-45',3,'Juan**'),(1024540097,'Kevin Andres Gonzalez','3052134567','KevinGonza@gmail.com','Calle 123#45-56',NULL,'Kevin**'),(1234456777,'Sebastián Mendez','3142345634','Sebasteo@gmail.com','cr 5 #2-33',NULL,'Sebas**');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-20  3:11:07
