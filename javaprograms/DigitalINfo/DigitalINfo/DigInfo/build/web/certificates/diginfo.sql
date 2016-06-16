-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2015 at 06:31 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `diginfo`
--

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
-- Table structure for table `carddetails`
--

CREATE TABLE IF NOT EXISTS `carddetails` (
  `typeofcard` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `number` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `cardpath` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carddetails`
--

INSERT INTO `carddetails` (`typeofcard`, `email`, `name`, `number`, `location`, `cardpath`) VALUES
('Aadhar', 'abc@gmail.com', 'Sachin', '123', 'HYD', 'cards/Jellyfish.jpg'),
('Ration', 'abc@gmail.com', 'SYED JALEELUDDIN', '456', 'HYD', 'cards/Desert.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `companydata`
--

CREATE TABLE IF NOT EXISTS `companydata` (
  `cmail` varchar(50) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `psw` varchar(50) NOT NULL
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
  `dataid` int(25) NOT NULL,
  `typeofdata` varchar(50) NOT NULL,
  `orgname` varchar(50) NOT NULL,
  `yearofpassedout` varchar(50) NOT NULL,
  `htno` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `percentage` double NOT NULL,
  `certificateurl` varchar(50) NOT NULL,
  `stemail` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educationdata`
--

INSERT INTO `educationdata` (`dataid`, `typeofdata`, `orgname`, `yearofpassedout`, `htno`, `location`, `percentage`, `certificateurl`, `stemail`) VALUES
(1, 'Inter', 'sattvaq', '2012', '123', 'kothapet', 70, 'afterorglogin.jsp', 'student@sattvaq.com'),
(2, 'SSC', 'sattvaq', '2012', '123', 'kothapet', 70, 'certificates/delorg.jsp', 'student@sattvaq.com'),
(5, 'SSC', 'abc', '2013', '123456', 'kothapet', 65.66, 'certificates/Winter.jpg', 'abc@gmail.com'),
(6, 'B Tech', 'sattvaq', '2013', '123456', 'kothapet', 70, 'certificates/Water lilies.jpg', 'abc@gmail.com'),
(7, 'SSC', 'TEST', '2312', '123', 'HYD', 21, 'certificates/Hydrangeas.jpg', 'abc@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `studentdata`
--

CREATE TABLE IF NOT EXISTS `studentdata` (
  `stemail` varchar(50) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `psw` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdata`
--

INSERT INTO `studentdata` (`stemail`, `phone`, `psw`, `name`) VALUES
('abc@gmail.com', '1234567890', '123', 'abc'),
('azeem@gmail.com', '5465636787', '1234', 'ravikumar'),
('goru@gmail.com', '65874', '1234', 'goru');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carddetails`
--
ALTER TABLE `carddetails`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `companydata`
--
ALTER TABLE `companydata`
  ADD PRIMARY KEY (`cmail`);

--
-- Indexes for table `educationdata`
--
ALTER TABLE `educationdata`
  ADD PRIMARY KEY (`dataid`);

--
-- Indexes for table `studentdata`
--
ALTER TABLE `studentdata`
  ADD PRIMARY KEY (`stemail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `educationdata`
--
ALTER TABLE `educationdata`
  MODIFY `dataid` int(25) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
