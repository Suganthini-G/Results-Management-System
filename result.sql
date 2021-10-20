-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 01, 2021 at 05:57 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `result`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('Admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `cst2`
--

DROP TABLE IF EXISTS `cst2`;
CREATE TABLE IF NOT EXISTS `cst2` (
  `stuno` varchar(10) NOT NULL,
  `SystemAnalysisandDesign` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Programming` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Network2` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `StaticalMethod` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `SoftwareEngineering` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `AestheticStudies` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `gpa` varchar(10) NOT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cst2`
--

INSERT INTO `cst2` (`stuno`, `SystemAnalysisandDesign`, `Programming`, `Network2`, `StaticalMethod`, `SoftwareEngineering`, `AestheticStudies`, `gpa`) VALUES
('CST18002', 'A', 'A', 'A', 'B+', 'B+', 'B', '3.72'),
('CST18001', 'A', 'A', 'A+', 'A', 'A', 'A-', '3.91'),
('CST18003', 'A-', 'B-', 'A', 'B', 'B', 'B', '2.89'),
('CST18004', 'A', 'B+', 'A-', 'B-', 'B-', 'B+', '3.29'),
('CST18005', 'B+', 'B+', 'A-', 'A+', 'A+', 'B+', '3.01'),
('CST18006', 'A+', 'C+', 'C-', 'D+', 'B-', 'D+', '2.00'),
('CST18007', 'B+', 'A+', 'A', 'C-', 'C-', 'B+', '2.65'),
('CST18008', 'A-', 'D', 'C+', 'E', 'A-', 'E', '1.72'),
('CST18009', 'A+', 'C+', 'C-', 'B', 'B', 'C+', '2.41'),
('CST18010', 'A', 'B', 'A+', 'B-', 'B+', 'A+', '3.14'),
('CST18011', 'A', 'A-', 'B+', 'A-', 'B', 'A-', '3.57');

-- --------------------------------------------------------

--
-- Table structure for table `data_encoder`
--

DROP TABLE IF EXISTS `data_encoder`;
CREATE TABLE IF NOT EXISTS `data_encoder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `department` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_encoder`
--

INSERT INTO `data_encoder` (`id`, `username`, `password`, `department`) VALUES
(2, 'ab', '00', 'CSI');

-- --------------------------------------------------------

--
-- Table structure for table `iit2`
--

DROP TABLE IF EXISTS `iit2`;
CREATE TABLE IF NOT EXISTS `iit2` (
  `stuno` varchar(10) NOT NULL,
  `SystemAnalysisandDesign` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `SoftwareEngineering` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Network2` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Programming` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `FinancialAccounting` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `AestheticStudies` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `gpa` varchar(10) NOT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `iit2`
--

INSERT INTO `iit2` (`stuno`, `SystemAnalysisandDesign`, `SoftwareEngineering`, `Network2`, `Programming`, `FinancialAccounting`, `AestheticStudies`, `gpa`) VALUES
('IIT18001', 'A+', 'A', 'A-', 'B+', 'B', 'B-', '2.48'),
('IIT18002', 'A', 'A+', 'C-', 'D+', 'B', 'E', '1.42'),
('IIT18003', 'D+', 'A-', 'A+', 'B', 'B', 'B', '1.28'),
('IIT18004', 'A', 'A', 'A-', 'B', 'B+', 'C-', '2.65'),
('IIT18005', 'A-', 'A+', 'C+', 'D+', 'B+', 'C-', '2.41'),
('IIT18006', 'D', 'C-', 'C+', 'C-', 'B-', 'B-', '0.95'),
('IIT18007', 'A+', 'A+', 'A+', 'B-', 'B-', 'C+', '2.95'),
('IIT18008', 'A', 'A+', 'C-', 'C+', 'B-', 'C+', '1.45'),
('IIT18009', 'D', 'A', 'A+', 'A+', 'B', 'B+', '2.48'),
('IIT18010', 'A', 'A', 'A-', 'B+', 'C+', 'A-', '3.59');

-- --------------------------------------------------------

--
-- Table structure for table `mrt2`
--

DROP TABLE IF EXISTS `mrt2`;
CREATE TABLE IF NOT EXISTS `mrt2` (
  `stuno` varchar(10) NOT NULL,
  `PhysicalChemistry` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `ElectricityandMagnetisim` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Minerology` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Geology` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Hydrology` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `AestheticStudies` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `gpa` varchar(10) NOT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mrt2`
--

INSERT INTO `mrt2` (`stuno`, `PhysicalChemistry`, `ElectricityandMagnetisim`, `Minerology`, `Geology`, `Hydrology`, `AestheticStudies`, `gpa`) VALUES
('MRT18001', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.87'),
('MRT18002', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.87'),
('MRT18003', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.87'),
('MRT18004', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.87'),
('MRT18005', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.47'),
('MRT18006', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.87'),
('MRT18007', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '2.70'),
('MRT18008', 'A+', 'B', 'B+', 'B-', 'C+', 'D+', '3.44'),
('MRT18009', 'C+', 'B', 'B+', 'B-', 'C+', 'D+', '1.87'),
('MRT18010', 'B+', 'C-', 'C', 'C', 'A-', 'D+', '2.15');

-- --------------------------------------------------------

--
-- Table structure for table `sct2`
--

DROP TABLE IF EXISTS `sct2`;
CREATE TABLE IF NOT EXISTS `sct2` (
  `stuno` varchar(10) NOT NULL,
  `MicroBiology` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `PhysicalChemistry` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `AbstractAlgebra` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `StaticalMethod` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `Mechanics` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `BioChemistry` enum('A+','A','A-','B+','B','B-','C+','C','C-','D+','D','E') NOT NULL,
  `gpa` varchar(10) NOT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sct2`
--

INSERT INTO `sct2` (`stuno`, `MicroBiology`, `PhysicalChemistry`, `AbstractAlgebra`, `StaticalMethod`, `Mechanics`, `BioChemistry`, `gpa`) VALUES
('SCT18001', 'B+', 'A-', 'A-', 'B', 'B', 'C+', '2.54'),
('SCT18002', 'B-', 'A+', 'A+', 'C', 'B+', 'B+', '2.56'),
('SCT18003', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.45'),
('SCT18004', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.45'),
('SCT18005', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.45'),
('SCT18006', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.45'),
('SCT18007', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.01'),
('SCT18008', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '1.84'),
('SCT18009', 'B+', 'B-', 'B+', 'B', 'B', 'B+', '2.21'),
('SCT18010', 'B+', 'A-', 'A+', 'B', 'B', 'A+', '3.58');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
