CREATE DATABASE  IF NOT EXISTS `bdarquetipo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdarquetipo`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bdarquetipo
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `id_avaliacao` int NOT NULL AUTO_INCREMENT,
  `nota` int DEFAULT NULL,
  `id_historia` int DEFAULT NULL,
  `id_editora` int DEFAULT NULL,
  PRIMARY KEY (`id_avaliacao`),
  KEY `fk_editora_avaliacao_idx` (`id_editora`),
  KEY `fk_historia_avaliacao_idx` (`id_historia`),
  CONSTRAINT `fk_editora_avaliacao` FOREIGN KEY (`id_editora`) REFERENCES `editora` (`id_editora`),
  CONSTRAINT `fk_historia_avaliacao` FOREIGN KEY (`id_historia`) REFERENCES `historia` (`id_historia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,4,1,1),(2,3,2,2),(3,5,3,3),(4,2,4,1),(5,4,5,2),(6,3,6,3),(8,2,8,2),(9,4,9,3),(10,3,10,1),(11,12,1,7);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `id_editora` int NOT NULL AUTO_INCREMENT,
  `numeroAutoresPublicados` int DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_editora`),
  KEY `fk_editora_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_editora_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (1,10,'Prime Books',21),(2,11,'Stellar Publishing',22),(3,12,'Universal Press',23),(4,13,'Bright Horizon Books',24),(5,14,'Evergreen Publications',25),(6,15,'Golden Pen Press',26),(7,16,'Crystal Clear Books',27),(8,17,'Starlight Publishing',28),(9,18,'Clearview Editions',29),(10,19,'Boundless Books',30);
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escritor`
--

DROP TABLE IF EXISTS `escritor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escritor` (
  `id_escritor` int NOT NULL AUTO_INCREMENT,
  `generoEscrita` varchar(45) DEFAULT NULL,
  `numeroDeObras` int DEFAULT NULL,
  `livrosPublicados` int DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_escritor`),
  KEY `fk_escritor_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_escritor_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escritor`
--

LOCK TABLES `escritor` WRITE;
/*!40000 ALTER TABLE `escritor` DISABLE KEYS */;
INSERT INTO `escritor` VALUES (1,'Romance',3,5,'William Shakespeare',11),(2,'Terror',4,2,'Jane Austen',12),(3,'Comedia',5,6,'Charles Dickens',13),(4,'Drama',6,7,'Ernest Hemingway',14),(5,'Aventura',7,8,'Virginia Woolf',15),(6,'Romance',8,9,'Fyodor Dostoevsky',16),(7,'Terror',9,0,'J.R.R. Tolkien',17),(8,'Comedia',10,2,'Gabriel García Márquez',18),(9,'Drama',11,3,'Harper Lee',19),(10,'Aventura',12,1,'J.K. Rowling',20),(15,NULL,NULL,NULL,'123ES',48);
/*!40000 ALTER TABLE `escritor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia`
--

DROP TABLE IF EXISTS `historia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historia` (
  `id_historia` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `id_escritor` int DEFAULT NULL,
  PRIMARY KEY (`id_historia`),
  KEY `fk_escritor_historia_idx` (`id_escritor`),
  CONSTRAINT `fk_escritor_historia` FOREIGN KEY (`id_escritor`) REFERENCES `escritor` (`id_escritor`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia`
--

LOCK TABLES `historia` WRITE;
/*!40000 ALTER TABLE `historia` DISABLE KEYS */;
INSERT INTO `historia` VALUES (1,'O Segredo das Estrelas','Romance',2,1),(2,'A Jornada do Destino','Terror',0,2),(3,'Entre Dois Mundos','Romance',0,3),(4,'O Mistério da Mansão Abandonada','Drama',10,3),(5,'O Poder da','Roamnce',10,5),(6,'Além das Fronteiras','Romance',0,5),(8,'O Lado Oculto da Lua','Comedia',0,8),(9,'O Enigma do Espelho','Drama',0,10),(10,'O Suspiro do Vento','Aventura',4,10),(22,'Montanhas sombrias','Ficção',12,15),(31,'teste','Mistério',222,15),(32,'1231','Ficção',0,15),(33,'123','Ficção',0,15);
/*!40000 ALTER TABLE `historia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leitor`
--

DROP TABLE IF EXISTS `leitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leitor` (
  `id_Leitor` int NOT NULL AUTO_INCREMENT,
  `generoPreferido` varchar(45) DEFAULT NULL,
  `escritorPreferido` varchar(45) DEFAULT NULL,
  `numeroObrasLidas` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_Leitor`),
  KEY `fk_leitor_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_leitor_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leitor`
--

LOCK TABLES `leitor` WRITE;
/*!40000 ALTER TABLE `leitor` DISABLE KEYS */;
INSERT INTO `leitor` VALUES (1,'Romance','William Shakespeare','21','Sofia Martins',1),(2,'Terror','Jane Austen','32','Pedro Silva',2),(3,'Comedia','Charles Dickens','13','Ana Santos',3),(4,'Drama','Ernest Hemingway','4','Guilherme Costa',4),(5,'Aventura','Virginia Woolf','35','Beatriz Oliveira',5),(6,'Romance','Fyodor Dostoevsky','16','Miguel Pereira',6),(7,'Terror','J.R.R. Tolkien','7','Mariana Rodrigues',7),(8,'Comedia','Gabriel García Márquez','8','André Almeida',8),(9,'Drama','Harper Lee','29','Carolina Sousa',9),(10,'Aventura','J.K. Rowling','10','Tiago Fernandes',10);
/*!40000 ALTER TABLE `leitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leitura`
--

DROP TABLE IF EXISTS `leitura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leitura` (
  `id_leitura` int NOT NULL AUTO_INCREMENT,
  `paginasLidas` int DEFAULT NULL,
  `nota` int DEFAULT NULL,
  `id_historia` int DEFAULT NULL,
  `id_leitor` int DEFAULT NULL,
  PRIMARY KEY (`id_leitura`),
  KEY `fk_leitor_leitura_idx` (`id_leitor`),
  KEY `fk_historia_leitor_idx` (`id_historia`),
  CONSTRAINT `fk_historia_leitor` FOREIGN KEY (`id_historia`) REFERENCES `historia` (`id_historia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_leitor_leitura` FOREIGN KEY (`id_leitor`) REFERENCES `leitor` (`id_Leitor`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leitura`
--

LOCK TABLES `leitura` WRITE;
/*!40000 ALTER TABLE `leitura` DISABLE KEYS */;
INSERT INTO `leitura` VALUES (1,100,4,1,1),(2,150,3,2,2),(4,80,NULL,4,4),(5,250,4,5,5),(6,120,3,6,6),(8,90,NULL,8,8),(9,300,4,9,9),(10,300,10,9,2),(11,300,1,9,3),(12,300,20,9,4),(13,140,25,10,10),(22,22,1,2,3),(23,NULL,NULL,3,3);
/*!40000 ALTER TABLE `leitura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'user123','password123','Leitor'),(2,'password1','a12345678','Leitor'),(3,'hello123','qwerty123','Leitor'),(4,'a123456','letmein','Leitor'),(5,'abcdef','iloveyou','Leitor'),(6,'qwerty','a111111','Leitor'),(7,'sunshine','abc123','Leitor'),(8,'soccerfan','admin123','Leitor'),(9,'ilovecats','123abc','Leitor'),(10,'summer2022','football','Leitor'),(11,'happyday','sunshine','Escritor'),(12,'coolguy','welcome','Escritor'),(13,'smileyface','1234abcd','Escritor'),(14,'musiclover','monkey','Escritor'),(15,'beachbum','ilovecats','Escritor'),(16,'123abc','a12345','Escritor'),(17,'footballfan','password1','Escritor'),(18,'readingrocks','hello123','Escritor'),(19,'gamingguru','a987654321','Escritor'),(20,'chocolatelover','summer2022','Escritor'),(21,'helloworld','chocolate','Editora'),(22,'letmein','123abcxyz','Editora'),(23,'funtimes','1qaz2wsx','Editora'),(24,'starrynight','a555555','Editora'),(25,'a987654321','trustno1','Editora'),(26,'easylogin','baseball','Editora'),(27,'ilovepizza','letsgo','Editora'),(28,'partytime','princess','Editora'),(29,'happy123','happy123','Editora'),(30,'simplyme','soccer','Editora'),(48,'123ES','123ES','Escritor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 22:26:26
