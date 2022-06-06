-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2022 at 03:54 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dropshipping`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` char(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerAddress` varchar(255) NOT NULL,
  `PaymentName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `CustomerName`, `CustomerAddress`, `PaymentName`) VALUES
('CU001', 'Beben', 'Jl. Kelapa Gading Barat', 'Debit Card'),
('CU002', 'Bonaventura', 'Jl. Gajah No. 8', 'OVO'),
('CU003', 'Callista', 'Jl. Menawan 99 ', 'Gopay'),
('CU004', 'Daniel', 'Jl. Letnan Jendral ', 'Debit Card'),
('CU005', 'Yolanda', 'Jl. Delima 12', 'Shopee Pay');

-- --------------------------------------------------------

--
-- Table structure for table `dropshipper admin`
--

CREATE TABLE `dropshipper admin` (
  `Admin_Username` varchar(255) NOT NULL,
  `Admin_Password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dropshipper admin`
--

INSERT INTO `dropshipper admin` (`Admin_Username`, `Admin_Password`) VALUES
('Benyamin', 'benyamin99'),
('Bunga', 'bunga10'),
('Matthew', 'Matthew50');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrdersID` char(5) NOT NULL,
  `ProductID` char(5) NOT NULL,
  `CustomerID` char(5) NOT NULL,
  `ShippingID` char(5) NOT NULL,
  `TotalPrice` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrdersID`, `ProductID`, `CustomerID`, `ShippingID`, `TotalPrice`) VALUES
('OR001', 'PR002', 'CU003', 'SH001', 358000),
('OR002', 'PR001', 'CU001', 'SH003', 109000),
('OR003', 'PR003', 'CU002', 'SH002', 511000),
('OR004', 'PR002', 'CU005', 'SH002', 361000);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentName` varchar(255) NOT NULL,
  `Balance` bigint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PaymentName`, `Balance`) VALUES
('Debit Card', 200000),
('OVO', 100000),
('Gopay', 500000),
('Shopee Pay', 400000),
('Credit Card', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` char(5) NOT NULL,
  `SupplierID` char(5) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `ProductPrice` bigint(9) NOT NULL,
  `ProductDetails` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `SupplierID`, `ProductName`, `ProductPrice`, `ProductDetails`) VALUES
('PR001', 'SU001', 'Baju Tidur', 99000, 'Size : S- XL, Colors : Black & White-Polkadot'),
('PR002', 'SU002', 'Celana Jeans', 349000, 'Size : 20-29, Colors : Denim - Blue'),
('PR003', 'SU003', 'Sneakers Jordan Pria', 499000, 'Size : 39-45, Colors : White');

-- --------------------------------------------------------

--
-- Table structure for table `shipping`
--

CREATE TABLE `shipping` (
  `ShippingID` char(5) NOT NULL,
  `CustomerID` char(5) NOT NULL,
  `SupplierID` char(5) NOT NULL,
  `ShippingProvider` varchar(255) NOT NULL,
  `ShippingEstimation` date NOT NULL,
  `ShippingCost` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipping`
--

INSERT INTO `shipping` (`ShippingID`, `CustomerID`, `SupplierID`, `ShippingProvider`, `ShippingEstimation`, `ShippingCost`) VALUES
('SH001', 'CU005', 'SU001', 'JNE', '2022-06-02', 9000),
('SH002', 'CU004', 'SU003', 'JNT', '2022-06-12', 12000),
('SH003', 'CU003', 'SU002', 'TIKI', '2022-06-06', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` char(5) NOT NULL,
  `SupplierName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`) VALUES
('SU001', 'Indra'),
('SU002', 'Asura'),
('SU003', 'Pratama');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrdersID`),
  ADD KEY `ProductID` (`ProductID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `ShippingID` (`ShippingID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `SupplierID` (`SupplierID`);

--
-- Indexes for table `shipping`
--
ALTER TABLE `shipping`
  ADD PRIMARY KEY (`ShippingID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `SupplierID` (`SupplierID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`ShippingID`) REFERENCES `shipping` (`ShippingID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);

--
-- Constraints for table `shipping`
--
ALTER TABLE `shipping`
  ADD CONSTRAINT `shipping_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  ADD CONSTRAINT `shipping_ibfk_2` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
