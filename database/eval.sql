-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2019 at 08:54 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eval`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `id` int(10) NOT NULL,
  `instruction` varchar(200) DEFAULT NULL,
  `deadline` date NOT NULL,
  `date` date NOT NULL,
  `uploadby` int(10) NOT NULL,
  `file` varchar(50) NOT NULL,
  `isdelete` enum('true','false') NOT NULL DEFAULT 'false',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `authuser`
--

CREATE TABLE `authuser` (
  `id` int(10) NOT NULL,
  `empid` int(20) NOT NULL,
  `roleid` int(10) NOT NULL,
  `isdelete` enum('true','false') NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authuser`
--

INSERT INTO `authuser` (`id`, `empid`, `roleid`, `isdelete`, `last_update`) VALUES
(4, 13, 8, 'false', '2019-06-12 04:46:16'),
(5, 14, 8, 'false', '2019-06-12 04:46:24'),
(6, 15, 7, 'false', '2019-06-12 04:46:31');

-- --------------------------------------------------------

--
-- Table structure for table `batch`
--

CREATE TABLE `batch` (
  `id` int(10) NOT NULL,
  `classid` int(10) NOT NULL,
  `batch` varchar(10) NOT NULL,
  `period` date NOT NULL,
  `trainer` int(10) NOT NULL,
  `isdelete` enum('true','false') NOT NULL,
  `lastupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch`
--

INSERT INTO `batch` (`id`, `classid`, `batch`, `period`, `trainer`, `isdelete`, `lastupdate`) VALUES
(56, 1, '25', '2019-01-09', 2, 'false', '2019-06-11 02:25:53'),
(57, 2, '26', '2019-06-30', 2, 'false', '2019-06-11 04:56:40'),
(58, 7, '29', '2019-06-02', 2, 'false', '2019-06-13 01:40:55');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `name`, `isdelete`) VALUES
(1, 'Java', 'false'),
(2, '.Net', 'false'),
(3, 'Cisco', 'true'),
(4, 'php', 'true'),
(5, 'cisco', 'false'),
(6, 'Spring', 'false'),
(7, 'Visual basic', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`, `isdelete`) VALUES
(1, 'ADD 1', 'false'),
(2, 'ADD 2', 'false'),
(3, 'MSBU', 'false'),
(4, 'HRD', 'true'),
(5, 'IT PROG', 'true'),
(6, 'ADD 4', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(10) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `phonenumber` varchar(12) NOT NULL,
  `birthdate` date NOT NULL,
  `hiredate` date NOT NULL,
  `jobid` varchar(20) NOT NULL,
  `departmentid` int(20) DEFAULT NULL,
  `batchclass` int(20) DEFAULT NULL,
  `isdelete` enum('true','false') NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `firstname`, `lastname`, `email`, `password`, `phonenumber`, `birthdate`, `hiredate`, `jobid`, `departmentid`, `batchclass`, `isdelete`, `last_update`) VALUES
(13, 'Muhamad ', 'Khulqi', 'khulqimuhamad@gmail.com', 'sarimisotokoya', '89694320475', '1997-09-09', '2019-10-10', 'IT-DEV', 1, 56, 'false', '2019-06-12 03:42:58'),
(14, 'Oka', 'Lanang ', 'okalanang13@gmail.com', 'sarimisotokoya', '89694320475', '1998-09-10', '2019-01-02', 'IT-DEV', 1, 57, 'false', '2019-06-12 04:00:17'),
(15, 'Rossa ', 'Hening ', 'rossahening@gmai.com', 'sarimisotokoya', '89694320475', '1985-02-09', '2019-10-10', 'IT-DEV', 1, NULL, 'false', '2019-06-12 04:02:35'),
(16, 'Regita ', 'Rachma ', 'gitarachma85@gmail.com', 'sarimisotokoya', '89694320475', '1999-10-10', '2019-10-10', 'IT-DEV', 2, 56, 'false', '2019-06-12 07:45:05');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(10) NOT NULL,
  `student` int(10) NOT NULL,
  `date` date NOT NULL,
  `batchclass` int(10) NOT NULL,
  `mark` float NOT NULL,
  `isdelete` enum('true','false') NOT NULL DEFAULT 'false',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` int(10) NOT NULL,
  `name` char(1) NOT NULL,
  `isdelete` enum('true','false') NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `name`, `isdelete`) VALUES
(1, 'A', 'false'),
(2, 'B', 'false'),
(3, 'C', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `grade_emp`
--

CREATE TABLE `grade_emp` (
  `id` int(10) NOT NULL,
  `student` int(10) NOT NULL,
  `grade` int(10) DEFAULT NULL,
  `isdelete` enum('true','false') NOT NULL DEFAULT 'false',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`id`, `name`, `isdelete`) VALUES
('IT', 'Prog', 'true'),
('IT-DEP', 'IT Developer', 'true'),
('IT-DEV', 'IT Developer', 'false'),
('IT-SUPP', 'IT Support', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `isdelete`) VALUES
(7, 'student ', 'false'),
(8, 'trainer', 'false'),
(25, 'trainer 2', 'true'),
(26, 'HRD', 'true'),
(27, 'user', 'true'),
(28, 'CEO', 'true'),
(29, 'HRD', 'true'),
(30, 'HRD', 'true'),
(31, 'trainer 2', 'true'),
(32, 'admin', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int(10) NOT NULL,
  `student` int(10) NOT NULL,
  `date` date NOT NULL,
  `assignment` int(10) DEFAULT NULL,
  `mark` float NOT NULL,
  `isdelete` enum('true','false') NOT NULL DEFAULT 'false',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `uplo`
--

CREATE TABLE `uplo` (
  `id` int(11) NOT NULL,
  `file` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uplo`
--

INSERT INTO `uplo` (`id`, `file`) VALUES
(1, 'images.jpg'),
(2, 'IMG-20171010-WA0011.jpg'),
(3, 'Department');

-- --------------------------------------------------------

--
-- Table structure for table `validation`
--

CREATE TABLE `validation` (
  `id` int(20) NOT NULL,
  `token` varchar(230) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `isactive` enum('true','false') NOT NULL DEFAULT 'false',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_all_role`
-- (See below for the actual view)
--
CREATE TABLE `v_all_role` (
`id` int(10)
,`name` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure for view `v_all_role`
--
DROP TABLE IF EXISTS `v_all_role`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_all_role`  AS  select `role`.`id` AS `id`,`role`.`name` AS `name` from `role` where (`role`.`isdelete` = '0') ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `assignment_emp` (`uploadby`);

--
-- Indexes for table `authuser`
--
ALTER TABLE `authuser`
  ADD PRIMARY KEY (`id`),
  ADD KEY `auth_emp` (`empid`),
  ADD KEY `auth_role` (`roleid`);

--
-- Indexes for table `batch`
--
ALTER TABLE `batch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_batch` (`classid`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emp_job` (`jobid`),
  ADD KEY `emp_department` (`departmentid`),
  ADD KEY `emp_batch` (`batchclass`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `exam_student` (`student`),
  ADD KEY `exam_batch` (`batchclass`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grade_emp`
--
ALTER TABLE `grade_emp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `grade_emp_student` (`student`),
  ADD KEY `grade_emp_grade` (`grade`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_assignment_cons` (`assignment`),
  ADD KEY `task_student` (`student`);

--
-- Indexes for table `uplo`
--
ALTER TABLE `uplo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `validation`
--
ALTER TABLE `validation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `authuser`
--
ALTER TABLE `authuser`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `batch`
--
ALTER TABLE `batch`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `grade_emp`
--
ALTER TABLE `grade_emp`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `uplo`
--
ALTER TABLE `uplo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `validation`
--
ALTER TABLE `validation`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_emp` FOREIGN KEY (`uploadby`) REFERENCES `employees` (`id`);

--
-- Constraints for table `authuser`
--
ALTER TABLE `authuser`
  ADD CONSTRAINT `auth_emp` FOREIGN KEY (`empid`) REFERENCES `employees` (`id`),
  ADD CONSTRAINT `auth_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

--
-- Constraints for table `batch`
--
ALTER TABLE `batch`
  ADD CONSTRAINT `class_batch` FOREIGN KEY (`classid`) REFERENCES `class` (`id`);

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `emp_batch` FOREIGN KEY (`batchclass`) REFERENCES `batch` (`id`),
  ADD CONSTRAINT `emp_department` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `emp_job` FOREIGN KEY (`jobid`) REFERENCES `job` (`id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_batch` FOREIGN KEY (`batchclass`) REFERENCES `batch` (`id`),
  ADD CONSTRAINT `exam_student` FOREIGN KEY (`student`) REFERENCES `employees` (`id`);

--
-- Constraints for table `grade_emp`
--
ALTER TABLE `grade_emp`
  ADD CONSTRAINT `grade_emp_grade` FOREIGN KEY (`grade`) REFERENCES `grade` (`id`),
  ADD CONSTRAINT `grade_emp_student` FOREIGN KEY (`student`) REFERENCES `employees` (`id`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_assignment_cons` FOREIGN KEY (`assignment`) REFERENCES `assignment` (`id`),
  ADD CONSTRAINT `task_student` FOREIGN KEY (`student`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
