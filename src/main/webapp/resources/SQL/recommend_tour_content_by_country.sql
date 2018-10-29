-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recommend_tour
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `content_by_country`
--

DROP TABLE IF EXISTS `content_by_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_by_country` (
  `country` varchar(45) NOT NULL,
  `cases` int(11) NOT NULL,
  `tour` int(11) NOT NULL,
  `food` int(11) NOT NULL,
  `shopping` int(11) NOT NULL,
  `culture` int(11) NOT NULL,
  `festival` int(11) NOT NULL,
  `reports` int(11) NOT NULL,
  PRIMARY KEY (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_by_country`
--

LOCK TABLES `content_by_country` WRITE;
/*!40000 ALTER TABLE `content_by_country` DISABLE KEYS */;
INSERT INTO `content_by_country` VALUES ('기타',265,52,4,8,2,2,4),('대만',873,29,12,24,5,5,2),('독일',21,54,12,6,3,3,2),('러시아',141,39,4,11,1,1,1),('말레이시아',271,43,7,16,3,3,2),('미국',306,38,11,10,2,2,2),('베트남',176,61,4,12,3,3,2),('싱가포르',175,26,13,35,2,1,1),('영국',38,43,9,12,4,4,4),('인도',6,57,9,0,0,0,10),('인도네시아',139,45,3,15,4,4,3),('일본',1856,18,18,27,3,3,4),('중국',3137,24,7,41,4,4,2),('중동',89,31,4,12,1,1,1),('캐나다',76,38,9,11,2,2,1),('태국',457,31,8,25,4,4,2),('프랑스',31,56,5,4,7,7,4),('필리핀',234,47,4,10,3,3,2),('호주',78,38,11,17,3,3,2),('홍콩',614,26,16,28,4,4,2);
/*!40000 ALTER TABLE `content_by_country` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-09 15:57:50
