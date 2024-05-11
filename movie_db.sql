-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2024 at 01:50 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `judul` varchar(30) NOT NULL,
  `alur` double NOT NULL,
  `penokohan` double NOT NULL,
  `akting` double NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES
('1', 4, 3, 3, 3.3333333333333335),
('2', 4, 3, 3, 3.3333333333333335),
('3', 5, 3, 3, 3.6666666666666665),
('4', 4, 3, 3, 3.3333333333333335),
('5', 4, 3, 2, 3),
('6', 4, 3, 3, 3.3333333333333335),
('7', 4, 3, 3, 3.3333333333333335),
('8', 4, 3, 3, 3.3333333333333335),
('9', 4, 3, 3, 3.3333333333333335),
('a', 0, 4, 4, 2.6666666666666665),
('aaa', 4, 3, 3, 3.3333333333333335),
('avc', 3, 4, 1, 2.6666666666666665),
('ccc', 5, 2, 2, 3),
('ddd', 5, 1, 2, 2.6666666666666665),
('dfgds', 3, 4, 1, 2.6666666666666665),
('fff', 4, 3, 2, 3),
('jhgfjhg', 3, 4, 3, 3.3333333333333335);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD UNIQUE KEY `judul` (`judul`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
