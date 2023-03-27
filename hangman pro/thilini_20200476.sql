-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2021 at 11:32 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thilini_20200476`
--

-- --------------------------------------------------------

--
-- Table structure for table `game_play`
--

CREATE TABLE `game_play` (
  `player_name` varchar(50) DEFAULT NULL,
  `word` varchar(25) DEFAULT NULL,
  `turns_provided` int(11) DEFAULT NULL,
  `turns_used` int(11) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game_play`
--

INSERT INTO `game_play` (`player_name`, `word`, `turns_provided`, `turns_used`, `status`) VALUES
('Test 1', 'CHAIR', 5, 0, 'Loss'),
('Test 1', 'DOG', 3, 1, 'Win'),
('Test 2', 'RAT', 3, 0, 'Loss'),
('Test 2', 'CAT', 3, 3, 'Win'),
('Test 3', 'FROCK', 5, 2, 'Win'),
('Test 3', 'APPLE', 5, 3, 'Win'),
('Test 4', 'RADIO', 5, 0, 'Loss'),
('Test 4', 'TABLE', 5, 0, 'Loss'),
('df', 'DOOR', 4, 0, 'Loss');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
