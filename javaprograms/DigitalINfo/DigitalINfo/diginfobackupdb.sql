-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 02, 2013 at 10:33 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `diginfo`
--
CREATE DATABASE `diginfo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `diginfo`;

-- --------------------------------------------------------

--
-- Table structure for table `admindata`
--

CREATE TABLE IF NOT EXISTS `admindata` (
  `adminid` varchar(25) NOT NULL,
  `psw` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admindata`
--

INSERT INTO `admindata` (`adminid`, `psw`) VALUES
('a', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `companydata`
--

CREATE TABLE IF NOT EXISTS `companydata` (
  `cmail` varchar(50) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `psw` varchar(50) NOT NULL,
  PRIMARY KEY (`cmail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companydata`
--

INSERT INTO `companydata` (`cmail`, `cname`, `phone`, `psw`) VALUES
('sattvaq@sattvaq.com', 'sattvaq', '1234567890', 'c');

-- --------------------------------------------------------

--
-- Table structure for table `educationdata`
--

CREATE TABLE IF NOT EXISTS `educationdata` (
  `dataid` int(25) NOT NULL AUTO_INCREMENT,
  `typeofdata` varchar(50) NOT NULL,
  `orgname` varchar(50) NOT NULL,
  `yearofpassedout` varchar(50) NOT NULL,
  `htno` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `percentage` double NOT NULL,
  `certificateurl` varchar(50) NOT NULL,
  `stemail` varchar(50) NOT NULL,
  PRIMARY KEY (`dataid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `educationdata`
--

INSERT INTO `educationdata` (`dataid`, `typeofdata`, `orgname`, `yearofpassedout`, `htno`, `location`, `percentage`, `certificateurl`, `stemail`) VALUES
(1, 'Inter', 'sattvaq', '2012', '123', 'kothapet', 70, 'afterorglogin.jsp', 'student@sattvaq.com'),
(2, 'SSC', 'sattvaq', '2012', '123', 'kothapet', 70, 'certificates/delorg.jsp', 'student@sattvaq.com'),
(3, 'SSC', 'abc', '2012', '123456', 'kothapet', 65.66, 'certificates/', 'abc@gmail.com'),
(4, 'SSC', 'abc', '2012', '123456', 'dil', 65.66, 'certificates/', 'abc@gmail.com'),
(5, 'SSC', 'abc', '2013', '123456', 'kothapet', 65.66, 'certificates/Winter.jpg', 'abc@gmail.com'),
(6, 'B Tech', 'sattvaq', '2013', '123456', 'kothapet', 70, 'certificates/Water lilies.jpg', 'abc@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `studentdata`
--

CREATE TABLE IF NOT EXISTS `studentdata` (
  `stemail` varchar(50) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `psw` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`stemail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdata`
--

INSERT INTO `studentdata` (`stemail`, `phone`, `psw`, `name`) VALUES
('abc@gmail.com', '1234567890', '123', 'abc');
