-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 25, 2013 at 02:11 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kbcss`
--
CREATE DATABASE `kbcss` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kbcss`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `loginid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`loginid`, `password`, `name`) VALUES
('admin', 'admin', 'adminadmin');

-- --------------------------------------------------------

--
-- Table structure for table `answeredquestions`
--

CREATE TABLE IF NOT EXISTS `answeredquestions` (
  `ansid` varchar(100) NOT NULL,
  `qid` varchar(25) NOT NULL,
  `whoaskid` varchar(25) NOT NULL,
  `whoanswered` varchar(25) NOT NULL,
  PRIMARY KEY (`ansid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deptdata`
--

CREATE TABLE IF NOT EXISTS `deptdata` (
  `deptid` varchar(25) NOT NULL,
  `deptname` varchar(25) NOT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE IF NOT EXISTS `education` (
  `headid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `collegename` varchar(35) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `emailid` varchar(35) NOT NULL,
  `collegeid` varchar(15) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `sq` varchar(25) NOT NULL,
  `sa` varchar(35) NOT NULL,
  PRIMARY KEY (`headid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`headid`, `password`, `name`, `collegename`, `phone`, `emailid`, `collegeid`, `designation`, `sq`, `sa`) VALUES
('sattvaq', '123', 'SattvaQ', 'College', '1234567890', 'sattvaq@gmail.com', '04521', 'Training Institute', 'Your Pet name', 'answer');

-- --------------------------------------------------------

--
-- Table structure for table `facultydata`
--

CREATE TABLE IF NOT EXISTS `facultydata` (
  `facid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `sq` varchar(25) NOT NULL,
  `sa` varchar(35) NOT NULL,
  `clgid` varchar(25) NOT NULL,
  `headid` varchar(25) NOT NULL,
  `depid` varchar(25) NOT NULL,
  PRIMARY KEY (`facid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `fid` int(25) NOT NULL AUTO_INCREMENT,
  `ansid` varchar(25) NOT NULL,
  `whoisgivingid` varchar(25) NOT NULL,
  `feedbackcontent` varchar(25) NOT NULL,
  `starcount` varchar(25) NOT NULL,
  `dateoffeedback` varchar(50) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `industry`
--

CREATE TABLE IF NOT EXISTS `industry` (
  `managerid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `company` varchar(25) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(35) NOT NULL,
  `companyid` varchar(25) NOT NULL,
  `sq` varchar(35) NOT NULL,
  `sa` varchar(40) NOT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `industry`
--

INSERT INTO `industry` (`managerid`, `password`, `name`, `company`, `phone`, `email`, `companyid`, `sq`, `sa`) VALUES
('bharath@sattvaq.com', '123', 'bharath', 'sattvaq', '1234567890', 'manager@sattvaq.com', 'sattvaq@sattvaq.com', 'Favorite Game', 'shuttle');

-- --------------------------------------------------------

--
-- Table structure for table `industryemployee`
--

CREATE TABLE IF NOT EXISTS `industryemployee` (
  `empid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `sq` varchar(25) NOT NULL,
  `sa` varchar(35) NOT NULL,
  `companyid` varchar(25) NOT NULL,
  `managerid` varchar(25) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `industryemployee`
--

INSERT INTO `industryemployee` (`empid`, `password`, `name`, `sq`, `sa`, `companyid`, `managerid`) VALUES
('sattvaq@gmail.com', '123', 'sattvaq', 'Favorite Color', 'red', 'sattvaq', 'bharath@sattvaq.com');

-- --------------------------------------------------------

--
-- Table structure for table `knowledgealert by employee`
--

CREATE TABLE IF NOT EXISTS `knowledgealert by employee` (
  `sno` varchar(25) NOT NULL,
  `userid` varchar(25) NOT NULL,
  `empid` varchar(25) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `knowledgebycategory`
--

CREATE TABLE IF NOT EXISTS `knowledgebycategory` (
  `sno` int(25) NOT NULL,
  `userid` varchar(25) NOT NULL,
  `catid` varchar(25) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mockscore`
--

CREATE TABLE IF NOT EXISTS `mockscore` (
  `sno` int(25) NOT NULL,
  `stdid` varchar(25) NOT NULL,
  `msno` int(25) NOT NULL,
  `totalmarks` int(25) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mocktestquestion`
--

CREATE TABLE IF NOT EXISTS `mocktestquestion` (
  `mockqid` int(25) NOT NULL AUTO_INCREMENT,
  `mocktestid` varchar(25) NOT NULL,
  `qtitle` varchar(25) NOT NULL,
  `optionA` varchar(25) NOT NULL,
  `optionB` varchar(25) NOT NULL,
  `optionC` varchar(25) NOT NULL,
  `optionD` varchar(25) NOT NULL,
  `cans` varchar(200) NOT NULL,
  `managerid` varchar(25) NOT NULL,
  `companyid` varchar(25) NOT NULL,
  PRIMARY KEY (`mockqid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `mocktestquestion`
--

INSERT INTO `mocktestquestion` (`mockqid`, `mocktestid`, `qtitle`, `optionA`, `optionB`, `optionC`, `optionD`, `cans`, `managerid`, `companyid`) VALUES
(8, 'mockid', 'what is java', 'platform independent', 'not platform', 'platform dependent', 'none', 'a', 'sattvaq@gmail.com', 'sattvaq@sattvaq.com');

-- --------------------------------------------------------

--
-- Table structure for table `mocktestresult`
--

CREATE TABLE IF NOT EXISTS `mocktestresult` (
  `msno` varchar(25) NOT NULL,
  `stdid` varchar(25) NOT NULL,
  `mocktestid` varchar(25) NOT NULL,
  `mockqid` varchar(25) NOT NULL,
  `answ` varchar(25) NOT NULL,
  `dateoftest` varchar(25) NOT NULL,
  PRIMARY KEY (`msno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `questiondata`
--

CREATE TABLE IF NOT EXISTS `questiondata` (
  `qid` varchar(25) NOT NULL,
  `whoaskedid` varchar(25) NOT NULL,
  `catid` varchar(25) NOT NULL,
  `qtitle` varchar(25) NOT NULL,
  `qdescry` varchar(25) NOT NULL,
  `doa` varchar(25) NOT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `questionsharing`
--

CREATE TABLE IF NOT EXISTS `questionsharing` (
  `sno` int(25) NOT NULL AUTO_INCREMENT,
  `whoissharingid` varchar(25) NOT NULL,
  `tosharingid` varchar(25) NOT NULL,
  `questionid` varchar(100) NOT NULL,
  `answid` varchar(100) NOT NULL,
  `dateofsharing` varchar(100) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE IF NOT EXISTS `reports` (
  `quid` int(20) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `uans` varchar(50) NOT NULL,
  `cans` varchar(50) NOT NULL,
  `marks` int(10) NOT NULL,
  `sno` int(10) NOT NULL AUTO_INCREMENT,
  `sess` int(50) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `studentdata`
--

CREATE TABLE IF NOT EXISTS `studentdata` (
  `studid` varchar(25) NOT NULL,
  `studentname` varchar(25) NOT NULL,
  `collegeid` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `sq` varchar(25) NOT NULL,
  `sa` varchar(35) NOT NULL,
  `htno` varchar(25) NOT NULL,
  `dept` varchar(25) NOT NULL,
  PRIMARY KEY (`studid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
