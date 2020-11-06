create database QuanLyThuVien1
go
use QuanLyThuVien1
GO
CREATE TABLE NhaXuatBan (
	MaNhaXuatBan nvarchar(12),
	TenNhaXuatBan nvarchar(20) primary key,
)
select * from NhaXuatBan
insert into NhaXuatBan values
('NXB1','Khoa Hoc'),
('NXB2','Giao Duc'),
('NXB3','Thanh Nien')

CREATE TABLE TheLoai (
	MaTheLoai nvarchar(12) ,
	TenTheLoai nvarchar(20) primary key,
)
insert into TheLoai values
('LTL1','Giao trinh'),
('LTL2','Tieu thuyet'),
('LTL3','Truyen ngan')
select * from TheLoai

CREATE table TaiLieu(
	MaTaiLieu nvarchar(12) PRIMARY KEY,
	TenTaiLieu nvarchar(30),
	TenNhaXuatBan nvarchar(20),
	CONSTRAINT fk_NhaXuatBan FOREIGN KEY(TenNhaXuatBan) REFERENCES NhaXuatBan(TenNhaXuatBan),
	TacGia nvarchar(30),
	SoLuongCo int,
	TenTheLoai nvarchar(20),
	CONSTRAINT fk_TheLoai FOREIGN KEY(TenTheLoai) REFERENCES TheLoai(TenTheLoai),
	NamXuatBan int,
	ViTri nvarchar(6),
	Gia MONEY)
select * from TaiLieu
insert into TaiLieu values
('TL1','Toan cao cap','Khoa Hoc','Nguyen Van Minh',20,'Giao trinh','2015','Khu A', 50000),
('TL2','Toan roi rac','Thanh Nien','Nguyen Duc Hung',20,'Tieu thuyet','2016','Khu B', 45000),
('TL3','Tuoi Tre','Giao Duc','Tran Duc Bo',20,'Truyen ngan','2015','Khu B',30000),
('TL4','Lap trinh can ban','Giao Duc','Pham Van Manh',20,'Giao trinh','2014','Khu C', 25000)

CREATE table NhanVienQLMT
(
	MaNhanVien nvarchar(12) PRIMARY KEY,
	TenNhanVien nvarchar(30),
	DienThoai int,
	DiaChi nvarchar(30),
	NgaySinh date,
	GioiTinh nvarchar(5),
	TenDangNhap nvarchar(15),
	MatKhau nvarchar(12)
)
select * from NhanVienQLMT
insert into NhanVienQLMT values 
('NVQLMT1','Hoang Van Anh','0936846124','Hai Phong','1995-03-04','Nam','anhhv','1'),
('NVQLMT2','Tran Thi Tam','0936846125','Ha Noi','1995-05-04','Nu','tamtt','1'),
('NVQLMT3','Nguyen Duc Quan','0936846126','Bac Ninh','1998-08-14','Nam','quannd','1')


CREATE table NhanVienQLTL
(
	MaNhanVien nvarchar(12) PRIMARY KEY,
	TenNhanVien nvarchar(30),
	DienThoai int,
	DiaChi nvarchar(30),
	NgaySinh date,
	GioiTinh nvarchar(5),
	TenDangNhap nvarchar(15),
	MatKhau nvarchar(12)
)
select * from NhanVienQLTL
insert into NhanVienQLTL values 
('NVQLTL1','Tran Trong Duc','0836846124','Hai Phong','1996-03-04','Nam','ductt','1'),
('NVQLTL2','Phan Van Tam','0836846125','Bac Ninh','1997-05-04','Nam','tampv','1'),
('NVQLTL3','Nguyen Dac Quang','0836846126','Dien Bien','1994-08-04','Nam','quangnd','1')


CREATE table ADmin
(
	TenDangNhap nvarchar(15),
	MatKhau nvarchar(12)
)

SELECT * FROM dbo.ADmin WHERE TenDangNhap = '@admin' OR 1='1'

create table BanDoc
(
	MaBanDoc nvarchar(12) PRIMARY KEY,
	TenBanDoc nvarchar(30),
	NgaySinh DATE,
	Khoa nvarchar(12),
	DienThoai int,
	GioiTinh nvarchar(5)
)
select * from BanDoc
insert into BanDoc Values
('BD001','Nam','1999-07-01','CNTT-K12','0847295731','Nam'),
('BD002','Hung','1999-07-03','CNTT-K13','0847295732','Nam'),
('BD003','Lan','1999-07-07','CNTT-K12','0847295733',N'Nữ')


CREATE table Phieu
(
	MaPhieu nvarchar(12) PRIMARY KEY,
	MaTaiLieu nvarchar(12),
	NgayMuon date,
	NgayThucTra date,
	MaBanDoc nvarchar(12),
	HoVaTen CHAR(30),
	NgayTra date,
	CONSTRAINT fk_TaiLieu FOREIGN KEY(MaTaiLieu) REFERENCES TaiLieu(MaTaiLieu),
	CONSTRAINT fk_BanDoc FOREIGN KEY(MaBanDoc) REFERENCES BanDoc(MaBanDoc),
)
select * from Phieu
insert into Phieu values 
('P1','TL1','2020-01-06','2020-01-12','BD001','Nam','2020-01-10'),
('P2','TL3','2020-03-14','2020-03-21','BD003','Lan','2020-03-24'),
('P3','TL3','2020-04-20','2020-05-01','BD001','Nam','2020-04-28'),
('P4','TL2','2020-05-08','2020-05-15','BD002','Hung','2020-05-24'),
('P5','TL4','2020-06-14','2020-06-18','BD001','Nam','2020-06-20')

CREATE TABLE BanTaiLieu(
	MaDonHang nvarCHAR(12) PRIMARY KEY,
	MaTaiLieu nvarCHAR(12) FOREIGN KEY REFERENCES dbo.TaiLieu(MaTaiLieu),
	HoVaTen nvarCHAR(30),
	DienThoai nvarchar(12),
	SoLuong int,
	GiaTien MONEY,
	ThanhTien MONEY
)
select * from BanTaiLieu
insert  into BanTaiLieu values
('DH1','TL2','Tran Trong Hung','0947373284',30,30000,900000),
('DH2','TL3','Dang Van Nghia','0947373285',10,40000,400000),
('DH3','TL4','Pham Van Duc','0947373286',2,360000,720000),
('DH4','TL1','Nguyen Hoang Anh','0947373287',10,300000,3000000)

INSERT INTO dbo.ADmin VALUES
('admin' , '1'),
('HongQuan' , '1')

create table XuLyPhieu (
	MaXuLy nvarchar(5) primary key,
	MaPhieu nvarchar(12) FOREIGN KEY REFERENCES dbo.Phieu(MaPhieu),
	LyDo nvarchar(25),
	TienPhat money,
	TrangThai nvarchar(20)
)
insert into XuLyPhieu values
('PXL1','P2',N'Quá hạn',20000,N'Đã nộp'),
('PXL2','P4',N'Quá hạn',20000,N'Chưa nộp')


