-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2017 at 10:48 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emd`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `id_num` int(11) NOT NULL,
  `date` date NOT NULL,
  `EUR no.` int(11) NOT NULL,
  `equipment_description` varchar(20) NOT NULL,
  `particulars` varchar(100) NOT NULL,
  `fuel` int(11) NOT NULL,
  `other_deduction` int(11) NOT NULL,
  `remark` varchar(20) NOT NULL,
  `kind_rate` varchar(20) NOT NULL,
  `billing_num` varchar(30) NOT NULL,
  `equipment code` varchar(20) NOT NULL,
  `project_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `date_billing`
--

CREATE TABLE `date_billing` (
  `id_num` int(11) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `description` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `date_billing`
--

INSERT INTO `date_billing` (`id_num`, `date_from`, `date_to`, `description`) VALUES
(1, '2017-09-01', '2017-09-08', 'Billing 9');

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id_num` int(11) NOT NULL,
  `description` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `Equipment_kind` varchar(20) NOT NULL,
  `Code` varchar(20) NOT NULL,
  `Year` int(11) NOT NULL,
  `Plate no.` varchar(20) NOT NULL,
  `Engine No.` varchar(20) NOT NULL,
  `Chassis` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id_num`, `description`, `model`, `Equipment_kind`, `Code`, `Year`, `Plate no.`, `Engine No.`, `Chassis`) VALUES
(1, 'Motor Grader, MG3', 'Mitsu,6DB1', 'Heavy', 'MG1', 2014, 'd131rea', '6DB1-183141', 'MG3-7666'),
(2, 'Motor Grader, MG3', 'Mitsu,6DB2', 'Heavy', 'MG2', 2014, 'adhasbd123', 'N/A', 'N/A'),
(3, 'Motor Grader,MG3', 'Mitsu, 6DB2', 'Heavy', 'MG 3', 2013, 'N/A', 'N/A', 'N/A'),
(4, 'Motor Grader,SDLG', 'SDLG, G9138', 'Heavy', 'MG4', 2013, 'N/A', 'N/A', 'N/A'),
(5, 'Motor Grader,SDLG', 'SDLG, G9138', 'Heavy', 'MG4', 2013, 'N/A', 'N/A', 'N/A'),
(6, 'Motor Grader,SDLG3', 'SDLG, G91383', 'Heavy', 'MG4', 2015, 'N/A', 'N/A', 'N/A'),
(7, 'Motor Grader, MG5', 'Mitsu,6DB2', 'Heavy', 'MG2', 2014, 'N/A', 'N/A', 'N/A'),
(8, 'Motor Grader,SDLG3', 'SDLG, G91383', 'Heavy', 'MG4', 2015, 'N/A', 'N/A', 'N/A'),
(9, 'Motor Grader,SDLG123', 'SDLG, G91381213', 'Light', 'MG41', 2013, 'N/A', 'N/A', 'N/A');

-- --------------------------------------------------------

--
-- Table structure for table `equipment_status`
--

CREATE TABLE `equipment_status` (
  `id_num` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `location` varchar(50) NOT NULL,
  `equipment_description` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `id_num` int(11) NOT NULL,
  `Project ID` varchar(20) NOT NULL,
  `MSK Project Code` varchar(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `Project Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id_num`, `Project ID`, `MSK Project Code`, `location`, `Project Name`) VALUES
(1, '17LG0001', '17DO-DP-Bitaogan Slp', 'Bitaogan', 'Bitaogan Slp'),
(2, '17LG0002', '17DO-DP-La-Union Slp', 'La Union', 'La Union Slp'),
(3, '17LG008', '17DO-DP-Govgen FC', 'Govgen', 'Govgen FC'),
(4, '17LG0009', '17DO-DP-Tagabebe Slp', 'Tagabebe', 'Tagabebe Slp'),
(5, '17LG0010', '17DO-Menzi RC', 'Menzi', 'Menzi RC'),
(6, '17LG0011', '17DO-Roxas RC', 'Roxas', 'Roxas RC'),
(7, '17LG0014', '17DO-Mon-Tam Slp', 'Mon Tam', 'Mon Tam Slp'),
(8, '17LG0015', '17DO-Dahican RC', 'Dahican', 'Dahican RC'),
(9, '17LG0018', '17DO-Nangan RC', 'Nangan', 'Nangan RC');

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

CREATE TABLE `rate` (
  `id_num` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `kind_rate` varchar(20) NOT NULL,
  `rate` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rate`
--

INSERT INTO `rate` (`id_num`, `description`, `kind_rate`, `rate`) VALUES
(1, 'Self loading Colvert 50 each', 'PC', 50),
(2, 'Self loading Colvert 50 each', 'PC', 50),
(3, 'Self loading Colvert 50 each\r ', 'Km', 55),
(4, 'Cocolumber and others', 'Km', 1000),
(5, 'DT#1', 'hour', 400);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`id_num`);

--
-- Indexes for table `date_billing`
--
ALTER TABLE `date_billing`
  ADD PRIMARY KEY (`id_num`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id_num`);

--
-- Indexes for table `equipment_status`
--
ALTER TABLE `equipment_status`
  ADD PRIMARY KEY (`id_num`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id_num`);

--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`id_num`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `date_billing`
--
ALTER TABLE `date_billing`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `equipment_status`
--
ALTER TABLE `equipment_status`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `rate`
--
ALTER TABLE `rate`
  MODIFY `id_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
