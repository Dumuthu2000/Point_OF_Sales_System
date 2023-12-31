-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2023 at 04:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pointofsales`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryID` int(20) NOT NULL,
  `categoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`) VALUES
(1, 'Snacks and Biscuits'),
(3, 'Fresh Produce'),
(4, 'Dairy and Eggs'),
(5, 'Meat and Seafood'),
(6, 'Bakery'),
(7, 'Beverages'),
(8, 'Household and Cleaning'),
(9, 'Health and Beauty');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `orderID` int(20) NOT NULL,
  `totalAmount` float NOT NULL,
  `recievedAmount` float NOT NULL,
  `balanceAmount` float NOT NULL,
  `orderDate` varchar(20) NOT NULL,
  `orderTime` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`orderID`, `totalAmount`, `recievedAmount`, `balanceAmount`, `orderDate`, `orderTime`) VALUES
(41, 1435, 1500, 65, '2023-11-27', '11:12:35 am'),
(42, 760, 1000, 240, '2023-12-27', '11:12:35 am'),
(43, 1060, 1500, 440, '2023-11-27', '11:16:54 am'),
(44, 1935, 2000, 65, '2023-12-28', '11:20:18 am'),
(46, 1210, 1500, 290, '2023-11-03', '11:22:12 am'),
(47, 1550, 1600, 50, '2023-12-28', '11:31:27 am'),
(48, 16060, 16500, 440, '2023-11-20', '11:37:36 am'),
(50, 2270, 2500, 230, '2023-12-28', '1:52:00 pm'),
(51, 5150, 5200, 50, '2023-12-28', '1:52:00 pm'),
(52, 2325, 2500, 175, '2023-12-28', '1:59:32 pm'),
(53, 550, 600, 50, '2023-12-28', '4:04:28 pm'),
(54, 460, 500, 40, '2023-12-28', '7:41:11 pm');

-- --------------------------------------------------------

--
-- Table structure for table `orderitem`
--

CREATE TABLE `orderitem` (
  `orderItemID` int(10) NOT NULL,
  `orderItemCode` varchar(20) NOT NULL,
  `orderItemName` varchar(255) NOT NULL,
  `orderItemPrice` float NOT NULL,
  `orderItemQty` int(20) NOT NULL,
  `totalPrice` float NOT NULL,
  `productID` int(10) NOT NULL,
  `orderID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderitem`
--

INSERT INTO `orderitem` (`orderItemID`, `orderItemCode`, `orderItemName`, `orderItemPrice`, `orderItemQty`, `totalPrice`, `productID`, `orderID`) VALUES
(54, 'PB003', 'Munchee Chick Bytes 100g', 150, 5, 750, 3, 26),
(56, 'PB002', 'Munchee Tikiri Maree 100g', 120, 6, 720, 2, 26),
(58, 'PB002', 'Munchee Tikiri Maree 100g', 120, 3, 360, 2, 27),
(60, 'PB003', 'Munchee Chick Bytes 100g', 150, 10, 1500, 3, 28),
(62, 'PB001', 'Munchee Chocolate Mari 80g', 155, 3, 465, 1, 28),
(63, 'PB001', 'Munchee Chocolate Mari 80g', 155, 5, 775, 1, 41),
(64, 'PB002', 'Munchee Tikiri Maree 100g', 120, 3, 360, 2, 41),
(65, 'PB003', 'Munchee Chick Bytes 100g', 150, 2, 300, 3, 41),
(66, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 42),
(67, 'PB003', 'Munchee Chick Bytes 100g', 150, 3, 450, 3, 42),
(68, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 43),
(69, 'PB003', 'Munchee Chick Bytes 100g', 150, 5, 750, 3, 43),
(70, 'PB001', 'Munchee Chocolate Mari 80g', 155, 3, 465, 1, 44),
(71, 'PB003', 'Munchee Chick Bytes 100g', 150, 5, 750, 3, 44),
(72, 'PB002', 'Munchee Tikiri Maree 100g', 120, 6, 720, 2, 44),
(73, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 45),
(74, 'PB003', 'Munchee Chick Bytes 100g', 150, 6, 900, 3, 45),
(75, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 46),
(76, 'PB003', 'Munchee Chick Bytes 100g', 150, 6, 900, 3, 46),
(77, 'PB001', 'Munchee Chocolate Mari 80g', 155, 10, 1550, 1, 47),
(78, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 48),
(79, 'PB003', 'Munchee Chick Bytes 100g', 150, 25, 3750, 3, 48),
(80, 'PB002', 'Munchee Tikiri Maree 100g', 120, 100, 12000, 2, 48),
(81, 'PB001', 'Munchee Chocolate Mari 80g', 155, 10, 1550, 1, 50),
(82, 'PB002', 'Munchee Tikiri Maree 100g', 120, 6, 720, 2, 50),
(83, 'PB001', 'Munchee Chocolate Mari 80g', 155, 10, 1550, 1, 51),
(84, 'PB002', 'Munchee Tikiri Maree 100g', 120, 30, 3600, 2, 51),
(85, 'PB001', 'Munchee Chocolate Mari 80g', 155, 15, 2325, 1, 52),
(86, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 53),
(87, 'PB002', 'Munchee Tikiri Maree 100g', 120, 2, 240, 2, 53),
(88, 'PB001', 'Munchee Chocolate Mari 80g', 155, 2, 310, 1, 54),
(89, 'PB003', 'Munchee Chick Bytes 100g', 150, 1, 150, 3, 54);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` int(255) NOT NULL,
  `productCode` varchar(20) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `purchasePrice` float NOT NULL,
  `sellPrice` float NOT NULL,
  `stockQty` int(255) NOT NULL,
  `purchasedDate` date NOT NULL,
  `categoryID` int(100) NOT NULL,
  `supplierID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productCode`, `productName`, `purchasePrice`, `sellPrice`, `stockQty`, `purchasedDate`, `categoryID`, `supplierID`) VALUES
(1, 'PB001', 'Munchee Chocolate Mari 80g', 135, 155, 81, '2023-12-12', 1, 1),
(2, 'PB002', 'Munchee Tikiri Maree 100g', 105, 120, 54, '2023-12-25', 1, 1),
(3, 'PB003', 'Munchee Chick Bytes 100g', 130, 150, 249, '2023-12-25', 1, 1),
(6, 'PB004', 'Ancor Milk 400g', 750, 850, 25, '2023-12-28', 6, 4);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplierID` int(255) NOT NULL,
  `supplierCode` varchar(20) NOT NULL,
  `supplierName` varchar(255) NOT NULL,
  `supplierAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplierID`, `supplierCode`, `supplierName`, `supplierAddress`) VALUES
(1, 'SB001', 'Ceylon Biscuit Limited (CBL) (pvt) Ltd', '45/2, T.B Jaya Mw, Homagama'),
(2, 'SB002', 'Perera & Sons', 'Maradana, Colombo'),
(3, 'SB003', 'Malliban Biscuit  (pvt) Ltd', 'Maradana, Colombo'),
(4, 'SB004', 'Fontera Srilanka', 'Biyagama, Kaduwela'),
(7, 'SB005', 'Risbarry Chocalte (pvt) Ltd', 'Rajagiriya'),
(8, 'SB006', 'Unillivar Srilanka', 'Minuwangoda'),
(9, 'SB007', 'Ceylon tea (pvt) Ltd', 'Nuwara Eliya'),
(10, 'SB008', 'Nestlay Srilanka', 'Kaduwela');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_mobile`
--

CREATE TABLE `supplier_mobile` (
  `supplierID` int(20) NOT NULL,
  `mobile` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(10) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `email`, `password`, `role`) VALUES
(1, 'Dumuthu Jayaisnghe', 'admin.dumuthu@gmail.com', 'admin@5445', 'admin'),
(2, 'Malshan Jayasinghe', 'cashier.malshan@gmail.com', 'cashier@5445', 'cashier');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`orderID`);

--
-- Indexes for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`orderItemID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`),
  ADD UNIQUE KEY `productCode` (`productCode`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplierID`),
  ADD UNIQUE KEY `supplierCode` (`supplierCode`);

--
-- Indexes for table `supplier_mobile`
--
ALTER TABLE `supplier_mobile`
  ADD PRIMARY KEY (`supplierID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `orderID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `orderitem`
--
ALTER TABLE `orderitem`
  MODIFY `orderItemID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplierID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `supplier_mobile`
--
ALTER TABLE `supplier_mobile`
  MODIFY `supplierID` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
