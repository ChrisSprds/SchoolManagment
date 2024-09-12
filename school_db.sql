-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2023 at 12:07 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `title`) VALUES
(1, 'PHP'),
(2, 'Java'),
(3, 'Javascript'),
(4, 'Wordpress'),
(5, 'Databases');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `grade` enum('1','2','3','4','5','6','7','8','9','10') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`id`, `student_id`, `course_id`, `grade`) VALUES
(2, 10, 1, '8'),
(3, 11, 4, '9'),
(4, 15, 4, '9'),
(5, 15, 2, '9'),
(7, 27, 3, '9'),
(8, 29, 2, '5'),
(9, 30, 1, '7'),
(10, 30, 2, '4'),
(11, 30, 3, '10'),
(13, 32, 1, '10'),
(14, 32, 2, '9'),
(15, 32, 3, '10');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` enum('Αρσενικο','Θηλυκο') NOT NULL,
  `home_address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `first_name`, `last_name`, `date_of_birth`, `gender`, `home_address`) VALUES
(10, 'θανασης', 'κωνσταντακης', '1983-09-07', 'Αρσενικο', 'σαμος'),
(11, 'uadad', 'ADFASF', '1983-09-07', 'Αρσενικο', 'σδασφδ'),
(12, 'θανασης ', 'ξαοξσα', '1983-07-09', 'Αρσενικο', 'σαμος'),
(13, 'δσγσσασαφ', 'σδγδσ', '1979-08-06', 'Θηλυκο', 'ασφα'),
(14, 'ihasfionaw', 'a\'lskf ', '1983-01-02', 'Αρσενικο', 'δασφωσ'),
(15, 'oanfsn', 'lsKFN', '1980-09-07', 'Αρσενικο', 'ασφας'),
(16, 'jsafihasf', 'hjfsahbf', '1983-02-03', 'Αρσενικο', 'σαμος'),
(17, 'δβχχδφβ', 'δχβδσφβ', '1983-07-09', 'Αρσενικο', 'σαμος'),
(18, 'sfasdfsd', 'safsdf', NULL, 'Αρσενικο', 'σδγδσ'),
(19, 'gsgd', 'dsgds', NULL, 'Αρσενικο', 'σαμος'),
(20, 'egd', 'sfvds', NULL, 'Αρσενικο', 'σαμος'),
(21, 'uzdrhdrh', 'tjfjtyjdyk', '1983-07-09', 'Αρσενικο', 'σαμος'),
(22, 'rstutru', 'hhfhfg', NULL, 'Αρσενικο', 'σαμος'),
(24, 'σδδσ', 'δσφφδσ', NULL, 'Αρσενικο', 'Σαμος'),
(25, 'θθθλξ', 'θογγθ', '1983-05-21', 'Αρσενικο', 'σαμος'),
(26, 'weklveknwl', 'knenvk', '1983-04-05', 'Αρσενικο', 'δασσαδ'),
(27, 'γυθλθγ', 'ξκβξβκ', '1983-09-09', 'Αρσενικο', 'σαμος'),
(28, 'thanasis', 'konstantakis', '1983-07-09', 'Αρσενικο', 'σαμος'),
(29, 'θανασης', 'υθφφυθθφυ', '1986-06-06', 'Αρσενικο', 'σαμος'),
(30, 'ηςσδγφ', 'ζσδγσγ', '1999-09-09', 'Αρσενικο', 'σαμος'),
(31, 'θανασης ', 'κωνσταντακης ', '1988-07-09', 'Αρσενικο', 'σμυρνης 6 σαμος'),
(32, 'χρηστος', 'Σπυριδης', '1994-09-02', 'Αρσενικο', 'Θεσσαλονικη');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grades`
--
ALTER TABLE `grades`
  ADD CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  ADD CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
