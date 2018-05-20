-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 bbs 的数据库结构
CREATE DATABASE IF NOT EXISTS `bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bbs`;


-- 导出  表 bbs.fans 结构
CREATE TABLE IF NOT EXISTS `fans` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(11) NOT NULL,
  `fansid` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `FK_fans_user` (`uid`),
  CONSTRAINT `FK_fans_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.fans 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `fans` DISABLE KEYS */;
/*!40000 ALTER TABLE `fans` ENABLE KEYS */;


-- 导出  表 bbs.img 结构
CREATE TABLE IF NOT EXISTS `img` (
  `imgid` int(2) NOT NULL,
  `img` varchar(100) NOT NULL,
  PRIMARY KEY (`imgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.img 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` (`imgid`, `img`) VALUES
	(1, 'img/img1.jpg'),
	(2, 'img/img1.jpg'),
	(3, 'img/logo.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;


-- 导出  表 bbs.reply 结构
CREATE TABLE IF NOT EXISTS `reply` (
  `replyno` int(10) NOT NULL AUTO_INCREMENT,
  `topicid` int(10) unsigned zerofill NOT NULL,
  `uid` varchar(11) NOT NULL,
  `replyuid` varchar(11) NOT NULL,
  `reply` varchar(1000) NOT NULL,
  `replytime` bigint(13) NOT NULL,
  `floor` int(10) NOT NULL,
  `isread` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`replyno`),
  KEY `FK_reply_user` (`uid`),
  KEY `FK_reply_topic` (`topicid`),
  CONSTRAINT `FK_reply_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.reply 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;


-- 导出  表 bbs.topic 结构
CREATE TABLE IF NOT EXISTS `topic` (
  `topicid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `uid` varchar(11) NOT NULL,
  `topicname` varchar(20) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `typeid` int(3) NOT NULL,
  `clicks` int(10) NOT NULL DEFAULT '0',
  `replys` int(10) NOT NULL DEFAULT '0',
  `istop` int(1) NOT NULL DEFAULT '0',
  `topictime` bigint(13) NOT NULL,
  `lasttime` bigint(13) DEFAULT NULL,
  `lastuid` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`topicid`),
  KEY `FK_article_type` (`typeid`),
  KEY `FK_talk_user` (`uid`),
  CONSTRAINT `FK_article_type` FOREIGN KEY (`typeid`) REFERENCES `type` (`typeid`),
  CONSTRAINT `FK_talk_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.topic 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;


-- 导出  表 bbs.type 结构
CREATE TABLE IF NOT EXISTS `type` (
  `typeid` int(3) NOT NULL AUTO_INCREMENT,
  `type` varchar(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.type 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`typeid`, `type`) VALUES
	(1, '生活'),
	(2, '游戏'),
	(3, '娱乐'),
	(4, '其他');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;


-- 导出  表 bbs.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `uid` varchar(11) NOT NULL,
  `uname` varchar(8) NOT NULL,
  `password` varchar(16) NOT NULL,
  `sex` int(1) NOT NULL,
  `imgid` int(2) NOT NULL DEFAULT '1',
  `email` varchar(19) NOT NULL,
  `level` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`),
  KEY `number` (`uid`),
  KEY `FK_user_img` (`imgid`),
  CONSTRAINT `FK_user_img` FOREIGN KEY (`imgid`) REFERENCES `img` (`imgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bbs.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
