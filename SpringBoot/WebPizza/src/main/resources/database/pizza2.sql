-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 10, 2022 lúc 04:41 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `pizza2`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `macthd` int(11) NOT NULL,
  `don_gia` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `thanh_tien` int(11) DEFAULT NULL,
  `mahd` int(11) DEFAULT NULL,
  `masp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cthoadon`
--

INSERT INTO `cthoadon` (`macthd`, `don_gia`, `so_luong`, `thanh_tien`, `mahd`, `masp`) VALUES
(1, 169000, 1, 169000, 1, 111),
(2, 129000, 1, 129000, 2, 112),
(3, 119000, 2, 238000, 2, 113),
(4, 23000, 3, 69000, 3, 136),
(5, 29000, 2, 58000, 3, 125),
(6, 129000, 1, 129000, 4, 118),
(7, 169000, 1, 169000, 4, 111);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` int(11) NOT NULL,
  `ngay_lap` date DEFAULT NULL,
  `tong_tien` int(11) DEFAULT NULL,
  `makh` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `ngay_lap`, `tong_tien`, `makh`) VALUES
(1, '2022-12-10', 169000, 1),
(2, '2022-12-10', 367000, 1),
(3, '2022-12-10', 127000, 2),
(4, '2022-12-10', 298000, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `dia_chi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ho_ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mat_khau` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tai_khoan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `dia_chi`, `ho_ten`, `mat_khau`, `sdt`, `tai_khoan`) VALUES
(1, '34 Kênh Tân Hóa, Tân Phú, HCM', 'Khanh', '$2a$10$4PRzkK/EEqUDjzOPZQgwTOh9r7flRxUL2hPBDMfR7Y2gtkUwjKstW', '0124584123', 'Khanh@gmail.com'),
(2, '34 Nguyễn Đình Chiểu Quận 3 HCM', 'Em Gái Mưa', '$2a$10$f5EiRx4k/czuts8JhXRiK.UF4K6rYN98gfuM8/0oW.tq2MIas.uhu', '0124584123', 'EmGaiMua@gmail.com'),
(3, '34 Kênh Đào Panama', 'Cô gái m52', '$2a$10$StzGvx..UT4krKq9MltIGetQwOlfGFgcS3icnmH6EBL.oeYanG5tu', '0147842155', 'cogaim52@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `ma_loai` int(11) NOT NULL,
  `hinh_anh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten_loai` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`ma_loai`, `hinh_anh`, `ten_loai`) VALUES
(1, 'burger-2.jpg', 'Pizza'),
(2, 'tea.jpg', 'Nước uống'),
(3, 'botmi.jpg', 'Nguyên liệu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` int(11) NOT NULL,
  `don_gia` int(11) DEFAULT NULL,
  `don_vi_tinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hinh_anh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `tensp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ma_loai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`masp`, `don_gia`, `don_vi_tinh`, `hinh_anh`, `so_luong`, `tensp`, `ma_loai`) VALUES
(111, 169000, 'Cái', 'pizza0.png', 29, 'Pizza Hải Sản Pesto Xanh', 1),
(112, 129000, 'Cái', 'pizza1.png', 38, 'Pizza Hải Sản Nhiệt Đới', 1),
(113, 119000, 'Cái', 'pizza2.png', 32, 'Pizza Hải Sản Cocktail', 1),
(114, 159000, 'Cái', 'pizza3.png', 36, 'Pizza Tôm Cocktail', 1),
(115, 119000, 'Cái', 'pizza4.png', 38, 'Pizza Aloha', 1),
(116, 130000, 'Cái', 'pizza5.png', 39, 'Pizza Thịt Xông Khói', 1),
(117, 149000, 'Cái', 'pizza6.png', 34, 'Pizza Thịt Nguội', 1),
(118, 129000, 'Cái', 'pizza7.png', 34, 'Pizza Gà Nướng 3 Vị', 1),
(119, 239000, 'Cái', 'pizza8.jpg', 13, 'Pizza hải sản Pesto gấp đôi nhân', 1),
(120, 239000, 'Cái', 'pizza9.jpg', 37, 'Pizza gấp đôi nhân phủ cơn lốc hải sản', 1),
(121, 229000, 'Cái', 'pizza10.jpg', 41, 'Pizza gấp đôi nhân phủ hải sản xốt tiêu đen', 1),
(122, 249000, 'Cái', 'pizza11.jpg', 43, 'Pizza bò nướng tiêu đen', 1),
(123, 269000, 'Cái', 'pizza12.jpg', 33, 'Pizza cá ngừ thanh cua', 1),
(124, 19000, 'Lon', 'douong0.jpeg', 150, 'Pepsi lon 330ml', 2),
(125, 29000, 'Chai', 'douong1.jpeg', 248, 'Pepsi chai 1.5l', 2),
(126, 19000, 'Lon', 'douong2.jpeg', 150, '7Up lon 330ml', 2),
(127, 29000, 'Chai', 'douong3.jpeg', 110, '7Up chai 1.5l', 2),
(128, 19000, 'Lon', 'douong4.jpg', 180, 'Pepsi no calories 330ml', 2),
(129, 19000, 'Lon', 'douong5.jpg', 100, 'Mirinda cam 330ml', 2),
(130, 19000, 'Lon', 'douong6.jpg', 80, 'Mirinda kem soda 330ml', 2),
(131, 10000, 'Chai', 'douong7.jpg', 52, 'Nước suối Aquafina', 2),
(132, 25000, 'Ly', 'douong8.jpg', 6, 'Trà sữa trà đen', 2),
(135, 10000, 'Gói', 'botmi.jpg', 100, 'Bột mì Meizan 500g', 3),
(136, 23000, 'Hộp', 'menno.jpg', 197, 'Men nở Mauripan 50g*5', 3),
(137, 84500, 'Chai', 'dau.jpg', 80, 'Dầu olive Olivoilà 250ml', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`macthd`),
  ADD KEY `FKi79wu3m8nkmh6b0vif9a7025w` (`mahd`),
  ADD KEY `FKst4yd15ncvag9tlqm7ahulnn3` (`masp`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `FKx9teb3ild3ss0o4hrl2a1t5f` (`makh`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`ma_loai`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `FKribtxdd67qi0tw66axhm5m5y6` (`ma_loai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  MODIFY `macthd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `ma_loai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `FKi79wu3m8nkmh6b0vif9a7025w` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`),
  ADD CONSTRAINT `FKst4yd15ncvag9tlqm7ahulnn3` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FKx9teb3ild3ss0o4hrl2a1t5f` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FKribtxdd67qi0tw66axhm5m5y6` FOREIGN KEY (`ma_loai`) REFERENCES `loai` (`ma_loai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
