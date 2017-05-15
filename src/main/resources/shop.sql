-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2017 at 01:23 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Pizza'),
(2, 'Mỳ Ý'),
(3, 'Cơm'),
(4, 'Thức Uống');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `order_id` int(10) UNSIGNED NOT NULL,
  `product_id` int(10) UNSIGNED NOT NULL,
  `quantity` tinyint(3) UNSIGNED NOT NULL,
  `price` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(500) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `created` datetime NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(500) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` int(10) UNSIGNED NOT NULL,
  `category_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `image`, `price`, `category_id`) VALUES
(1, 'Pizza thập cẩm cao cấp', 'Pizza Thập Cẩm Cao Cấp với 9 loại nhân phủ: xúc xích, thịt nguội, thịt bò, xúc xích gà, thơm, nấm, hành tây, ớt chuông và ô liu', '01.png', 99000, 1),
(2, 'Pizza Hải Sản Sốt Pesto', 'Pizza Hải Sản Sốt Pesto cao cấp với tôm, mực, nghêu và nấm trên nền sốt Pesto đặc trưng, phủ phô mai Mozzarella và lá húng quế.', '02.png', 99000, 1),
(3, 'Pizza Cơn Lốc Hải Sản', 'Pizza Cơn Lốc Hải Sản với mực, nghêu, thanh cua, thơm, ớt chuông xanh, hành tây trên nền sốt Thousand Islands và phô mai Mozzarella thượng hạng.', '17.png', 80000, 1),
(4, 'Pizza Thập Cẩm', 'Pizza Thập Cẩm mang hương vị truyền thống với thịt bò, xúc xích, ớt chuông, nấm rơm và hành tây, phủ phô mai Mozzarella trứ danh', '05.png', 79000, 1),
(5, 'Mỳ Ý Hải Sản Sốt Tiêu Đen', 'Mỳ Ý Hải Sản Sốt Tiêu Đen', 'FA21.png', 50000, 2),
(6, 'Mỳ Ý Thịt Nguội Sốt Kem', 'Mỳ Ý Thịt Nguội Sốt Kem', 'FA23.png', 40000, 2),
(7, 'Pizza Hải Sản Sốt Tiêu Đen', 'Pizza Hải Sản Sốt Tiêu Đen nổi tiếng với tôm, mực, thanh cua, hành tây phủ sốt tiêu đen thơm nồng và phô mai Mozzarella', '04.png', 85000, 1),
(8, 'Pizza Thịt và Xúc Xích', 'Pizza Thịt và Xúc Xích thơm ngon và giàu protein với thịt muối, thịt bò, thịt nguội và xúc xích', '03.png', 65000, 1),
(9, 'Pizza Cá Ngừ', 'Pizza Cá Ngừ mang hương vị biển cả nhẹ nhàng với cá ngừ, thanh cua, hành tây, thơm trên nền sốt Thousand Islands', '09.png', 80000, 1),
(10, 'Pizza Gà Sốt Tiêu Đen', 'Thịt gà, Xúc Xích Gà, Nấm, Hành, Ớt Xanh, Phô mai Mozzarella', '07.png', 67000, 1),
(11, 'Mỳ Ý Thịt Viên Trộn Sốt Cà Chua', 'Mỳ Ý Thịt Viên Trộn Sốt Cà Chua', 'FA22.png', 30000, 2),
(12, 'Mỳ Ý Sốt Thịt Cà Chua', 'Mỳ Ý Sốt Thịt Cà Chua', 'FA17.png', 25000, 1),
(13, 'Cơm Chiên Tỏi Và Cánh Gà Nướng', 'Cơm Chiên Tỏi Và Cánh Gà Nướng', 'GA09.png', 25000, 3),
(14, 'Cơm Chiên Hải Sản', 'Cơm Chiên Hải Sản', 'GA08.png', 35000, 3),
(15, 'Coca-Cola 330ml', 'Coca-Cola 330ml', 'NC27.png', 10000, 4),
(16, 'Sprite 330ml', 'Sprite 330ml', 'NC29.png', 10000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
(1, 'Nguyễn Tuấn Anh', 'nguyentuananh11b6@gmail.com', '$2a$10$Fd/rhPgkG6XbufIneTSMxeRFLCwl3OShb5J7woRqTIuepHTwK7XXO');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `role_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
