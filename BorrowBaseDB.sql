-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 17, 2020 at 01:34 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `BorrowBaseDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `ADMIN_DB_USERS`
--

CREATE TABLE `ADMIN_DB_USERS` (
  `USERNAME` varchar(30) NOT NULL DEFAULT 'admin',
  `PASSWORD` varchar(30) NOT NULL DEFAULT 'password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ADMIN_DB_USERS`
--

INSERT INTO `ADMIN_DB_USERS` (`USERNAME`, `PASSWORD`) VALUES
('Admin', 'admin'),
('hello', 'world');

-- --------------------------------------------------------

--
-- Table structure for table `CUSTOMER`
--

CREATE TABLE `CUSTOMER` (
  `c_id` varchar(5) NOT NULL,
  `c_name` varchar(30) NOT NULL,
  `c_add` varchar(50) NOT NULL,
  `c_phno` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `CUSTOMER`
--

INSERT INTO `CUSTOMER` (`c_id`, `c_name`, `c_add`, `c_phno`) VALUES
('1000', 'Abhishek', 'Jhansi', '123456789'),
('12', 'gdfg', 'fsdfgd', '6664655'),
('1234', 'Mayank', 'AMU Adfsd', '5436'),
('1235', 'dgh', 'fyhbhj', '655');

-- --------------------------------------------------------

--
-- Table structure for table `NAIVE_DB_USERS`
--

CREATE TABLE `NAIVE_DB_USERS` (
  `USERNAME` varchar(30) NOT NULL DEFAULT 'naiveuser',
  `PASSWORD` varchar(30) NOT NULL DEFAULT 'password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `NAIVE_DB_USERS`
--

INSERT INTO `NAIVE_DB_USERS` (`USERNAME`, `PASSWORD`) VALUES
('asfs', '4edgdh'),
('Kabh', 'zxcvbnm'),
('saurabh', 'zxcvbnm00');

-- --------------------------------------------------------

--
-- Table structure for table `TRANSACTION`
--

CREATE TABLE `TRANSACTION` (
  `c_id` varchar(5) NOT NULL,
  `rem_amt` int(6) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `TRANSACTION`
--

INSERT INTO `TRANSACTION` (`c_id`, `rem_amt`) VALUES
('1000', 12000),
('1234', 0),
('1235', 400);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ADMIN_DB_USERS`
--
ALTER TABLE `ADMIN_DB_USERS`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `CUSTOMER`
--
ALTER TABLE `CUSTOMER`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `NAIVE_DB_USERS`
--
ALTER TABLE `NAIVE_DB_USERS`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `TRANSACTION`
--
ALTER TABLE `TRANSACTION`
  ADD KEY `c_id` (`c_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `TRANSACTION`
--
ALTER TABLE `TRANSACTION`
  ADD CONSTRAINT `TRANSACTION_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `CUSTOMER` (`c_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
