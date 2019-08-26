-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: conferencemanager
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `adminattr`
--

DROP TABLE IF EXISTS `adminattr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminattr` (
  `UID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `AE-mail` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminattr`
--

LOCK TABLES `adminattr` WRITE;
/*!40000 ALTER TABLE `adminattr` DISABLE KEYS */;
INSERT INTO `adminattr` VALUES (1,'bjfu','bjfu.com','bjfu');
/*!40000 ALTER TABLE `adminattr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applydetailattr`
--

DROP TABLE IF EXISTS `applydetailattr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applydetailattr` (
  `UID` int(11) NOT NULL,
  `CID` int(11) NOT NULL,
  `TrainNum` int(11) NOT NULL,
  `InvHead` varchar(100) NOT NULL,
  `InvCon` text NOT NULL,
  `Hotel` char(1) NOT NULL,
  `Remark` text,
  PRIMARY KEY (`UID`,`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applydetailattr`
--

LOCK TABLES `applydetailattr` WRITE;
/*!40000 ALTER TABLE `applydetailattr` DISABLE KEYS */;
INSERT INTO `applydetailattr` VALUES (2,1,652,'北京林业大学','略','0','无'),(2,6,43,'北京林业大学','略','1','五人'),(2,7,13,'北京林业大学','略','0',NULL),(3,2,666,'北京语言大学','略','1','无'),(3,9,110,'北京语言大学','略','1',NULL),(3,10,9,'北京语言大学','略','1',NULL),(4,4,100,'上海交通大学','略','1','无'),(4,8,438,'北京语言大学','略','0',NULL),(5,3,654,'北京清华大学','略','1','无'),(5,5,15,'北京清华大学','略','1','无');
/*!40000 ALTER TABLE `applydetailattr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CID` int(11) NOT NULL,
  `Sort` varchar(45) NOT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `CID_UNIQUE` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'林业类'),(2,'经济与管理类'),(3,'林业类'),(4,'信息类'),(5,'经济与管理类'),(6,'信息类'),(7,'信息类'),(8,'信息类'),(9,'环境科学与工程'),(10,'土木水利类');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conferenceattr`
--

DROP TABLE IF EXISTS `conferenceattr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conferenceattr` (
  `CID` int(11) NOT NULL,
  `CName` varchar(45) NOT NULL,
  `StartTime` datetime NOT NULL,
  `City` varchar(100) NOT NULL,
  `Members` int(11) NOT NULL,
  `CTel` varchar(45) NOT NULL,
  `CE-mail` varchar(100) NOT NULL,
  `Organizer` varchar(100) NOT NULL,
  `Addr` varchar(100) NOT NULL,
  `Introduction` text NOT NULL,
  `EndOrNot` char(1) NOT NULL,
  `MemLimit` int(11) NOT NULL,
  `EndTime` datetime NOT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `CName_UNIQUE` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conferenceattr`
--

LOCK TABLES `conferenceattr` WRITE;
/*!40000 ALTER TABLE `conferenceattr` DISABLE KEYS */;
INSERT INTO `conferenceattr` VALUES (1,'中国林学会关于举办“大数据林业应用高级研讨班”的通知（第二轮）','2016-11-24 08:00:00','安徽省合肥市',1,'010-62889170','wwq@ifrit.ac.cn','中国林学会','两淮豪生大酒店','略','1',500,'2016-11-25 11:00:00'),(2,'第八届新结构国际发展论坛','2016-11-17 13:00:00','北京市海淀区',1,'13310229999','lunt@126.com','北京大学国家发展研究院','未确定','略','1',80,'2016-11-17 15:00:00'),(3,'2016绿色贸易国际会议','2016-12-06 08:00:00','北京市东城区',1,'86-10-58807812 ','cgep@mail.bnu.edu.cn','北京师范大学','北京雁栖湖国际会展中心','本次会议将邀请各经济体政府部门、企业、公益组织和专家学者共同讨论贸易对环境的潜在影响，促进绿色贸易发展的政策法规、国际标准和最佳实践，以及通过绿化供应链、建立绿色自贸试验区等促进绿色贸易的措施和途径。会议议题还将涉及绿色贸易发展过程中的性别平等和贫困问题。会议旨在提升各相关方的绿色贸易理念，提高各经济体在贸易自由化进程中的环境保护和可持续发展意识和能力，推动建立创新、协调、绿色、开放、共享发展的国际贸易新格局。','0',50,'2016-12-06 18:00:00'),(4,'2016国际数据自动化研讨会','2016-12-12 00:00:00','西班牙',1,'','Peter.Flach@bristol.ac.uk ','IEEE Computer Society','Barcelona, Spain ','It is well known that a great proportion of the time devoted to data mining and, especially, data science projects is devoted to data acquisition, integration, transformation, cleansing and other highly tedious tasks. These tasks are tedious basically because they are repetitive and, hence, automatable. As a consequence, progress in the automation of this process can lead to a dramatic reduction of the cost and duration of data-oriented projects. Recently, inductive programming in general (and the learning of declarative rules and programs from a few user interaction examples in particular) has shown a large potential for this automation. The release of FlashFill as a plug-in inductive programming tool for Microsoft Excel and ConvertFrom-String as a Powershell command on Windows 10 are impressive demonstrations that inductive programming research has matured in such a way that commercial applications become feasible.','0',100,'2016-12-12 00:00:00'),(5,'“社区治理的理论与经验”研讨会 ','2016-12-09 00:00:00','浙江省丽水地区',1,' 13858043742 ','  huangjy77@126.com ','浙江省中国乡村社会史研究会 ',' 丽水学院 ','为了进一步推动学术界对社区治理问题的研究与交流，浙江省中国乡村社会史研究会将举行2016学术年会暨“社区治理的理论与经验”研讨会。本次会议由浙江大学地方政府与社会治理研究中心、丽水学院思政部承办。特向诸位同仁征集论文，诚邀您不吝赐稿，拨冗与会。','0',45,'2016-12-10 00:00:00'),(6,'CCF YOCSEF上海：2016互联网+ 物流新技术虹桥论剑 ','2016-11-26 00:00:00','上海市青浦县',1,'18721492475','8848@dahantc.com','CCF YOCSEF上海','圆通新大楼1楼4号会议室','2015年以来，“互联网+”、“工业4.0”、“一带一路”早已成为了耳熟能详的核心热词。而针对国家的动脉——物流，李克强总理、十八届五中全会、十三五计划，都明确指出了物联网的移动信息化、大数据化乃至推动智慧物流的重要性。在“工业4.0”时代的大潮中，物流业迎来了转型升级的绝佳契机，帮助实体企业提高产品附加值、去除过剩产能。','1',60,'2016-11-26 00:00:00'),(7,'2017年智能机器人专题会议','2017-02-24 00:00:00','葡萄牙',1,'+351 265 520 184','icaart.secretariat@insticc.org','Institute for Systems and Technologies of Information, Control and Communication ',' Porto, Portugal ','Robotics, from the point of view of Agents and Artificial Intelligence (AI), has been a very important application field for many years. The dynamic and unforeseen nature of the environment, especially for mobile robots, has fostered research in these aspects for AI researchers. This special session will focus on the contributions of the AI and Agent research community for the field of Intelligent Robotics.','0',200,'2017-02-26 00:00:00'),(8,'2016（第七届）中国云计算学术大会 ','2016-11-18 00:00:00','湖南省长沙市',1,'010-68209088','cccc@csu.edu.cn','中国科学技术协会、科技部、工业和信息化部指导，中国通信学会 ','中南大学','略','1',50,'2016-11-19 00:00:00'),(9,'绿色“一带一路”与环境保护投融资机制创新论坛','2016-12-23 00:00:00',' 北京市东城区  ',1,'','lvsejronglun@163.com','环境保护部环境保护对外合作中心','北京国际会议中心','第一单元：绿色“一带一路”投融资机制创新','0',80,'2016-12-24 00:00:00'),(10,'变化环境下中美水安全面临的挑战和机遇论坛','2017-01-04 00:00:00','  湖北省武汉市  ',1,'(+86) 27-68773568','9thasceewri@whu.edu.cn','美国土木工程师学会环境与水资源分会','武汉洪山宾馆 ','EWRI-ASCE主办的全球水资源与环境大会已经在多个国家成功举办了8届，分别为2006年的印度新德里，2009年的泰国曼谷，2010年的印度金奈，2011年的新加坡，2012年的摩洛哥马拉喀什，2014年的土耳其伊斯坦布尔以及2016年的斯里兰卡。2017年1月4-6日将在中国武汉举办第九届。','0',100,'2017-01-06 00:00:00');
/*!40000 ALTER TABLE `conferenceattr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personattr`
--

DROP TABLE IF EXISTS `personattr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personattr` (
  `UID` int(11) NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Permission` char(1) DEFAULT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personattr`
--

LOCK TABLES `personattr` WRITE;
/*!40000 ALTER TABLE `personattr` DISABLE KEYS */;
INSERT INTO `personattr` VALUES (1,'bjfu','bjfu','1'),(2,'zy','123','0'),(3,'szy','123','0'),(4,'wx','123','0'),(5,'zhy','123','0');
/*!40000 ALTER TABLE `personattr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userattr`
--

DROP TABLE IF EXISTS `userattr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userattr` (
  `UID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Tel` varchar(45) NOT NULL,
  `E-mail` varchar(45) NOT NULL,
  `Sex` char(1) NOT NULL,
  `Age` int(11) NOT NULL,
  `TureName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userattr`
--

LOCK TABLES `userattr` WRITE;
/*!40000 ALTER TABLE `userattr` DISABLE KEYS */;
INSERT INTO `userattr` VALUES (2,'zy','123','zy.com','f',20,'zhangyue','123'),(3,'szy','234','szy.com','f',22,'shaozuoyu','123'),(4,'wx','456','wx.com','m',20,'wangxu','123'),(5,'zhy','345','zhy.com','m',20,'zanghongyu','123');
/*!40000 ALTER TABLE `userattr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-15 23:40:20
