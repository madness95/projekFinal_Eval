-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2019 at 10:05 AM
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
  `employee` int(10) NOT NULL,
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `batch`
--

CREATE TABLE `batch` (
  `id` int(10) NOT NULL,
  `period` date NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `batch_class`
--

CREATE TABLE `batch_class` (
  `id` int(10) NOT NULL,
  `class` int(10) NOT NULL,
  `batch` int(10) NOT NULL,
  `trainer` int(10) NOT NULL,
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone_number` int(12) NOT NULL,
  `birthdate` date NOT NULL,
  `job` varchar(20) NOT NULL,
  `department` int(20) NOT NULL,
  `batchclass` int(20) NOT NULL,
  `trainer` int(20) NOT NULL,
  `grade` int(20) NOT NULL,
  `role` int(20) NOT NULL,
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(10) NOT NULL,
  `student` int(10) NOT NULL,
  `date` date NOT NULL,
  `batch_class` int(10) NOT NULL,
  `mark` float NOT NULL,
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` int(10) NOT NULL,
  `name` char(1) NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `grade_emp`
--

CREATE TABLE `grade_emp` (
  `id` int(10) NOT NULL,
  `student` int(10) NOT NULL,
  `grade` int(10) DEFAULT NULL,
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `isdelete` char(1) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `assignment_emp` (`employee`);

--
-- Indexes for table `batch`
--
ALTER TABLE `batch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `batch_class`
--
ALTER TABLE `batch_class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `batch_class_cons` (`class`),
  ADD KEY `class_batch` (`batch`);

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
  ADD KEY `emp_job` (`job`),
  ADD KEY `emp_role` (`role`),
  ADD KEY `emp_department` (`department`),
  ADD KEY `emp_batch_class` (`batchclass`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `exam_student` (`student`),
  ADD KEY `exam_batchclass` (`batch_class`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `batch`
--
ALTER TABLE `batch`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `batch_class`
--
ALTER TABLE `batch_class`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grade_emp`
--
ALTER TABLE `grade_emp`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_emp` FOREIGN KEY (`employee`) REFERENCES `employees` (`id`);

--
-- Constraints for table `batch_class`
--
ALTER TABLE `batch_class`
  ADD CONSTRAINT `batch_class_cons` FOREIGN KEY (`class`) REFERENCES `class` (`id`),
  ADD CONSTRAINT `class_batch` FOREIGN KEY (`batch`) REFERENCES `batch` (`id`);

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `emp_batch_class` FOREIGN KEY (`batchclass`) REFERENCES `batch_class` (`id`),
  ADD CONSTRAINT `emp_department` FOREIGN KEY (`department`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `emp_job` FOREIGN KEY (`job`) REFERENCES `job` (`id`),
  ADD CONSTRAINT `emp_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_batchclass` FOREIGN KEY (`batch_class`) REFERENCES `batch_class` (`id`),
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
