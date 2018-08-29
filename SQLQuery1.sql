create database quanlybhang
use quanlybhang

create table nhanvien
(
    manv nvarchar(5),
	tennv nvarchar(50),
	gioitinh nvarchar(3),
	luong int,
	ngaysinh date,
	ngaylv date,
	diachi nvarchar(100),
	sdt int,
	primary key(manv)
)
insert  nhanvien
values('N01','DUONG ANH DUONG','Nam',30000,'4/2/1990','9/3/2015','Q.5',01653245891)
insert  nhanvien
values('N02','DUONG HONG QUANG','Nam',2000,'5/2/1990','9/9/2014','Q.3',01253245897)
insert  nhanvien
values('N03','LE HOANG HAI NGUYEN','Nu',2000,'5/2/1990','9/9/2014','Q.3',01253245897)
select *from nhanvien

delete nhanvien where manv='11'

update nhanvien set tennv='Hiep',gioitinh='Nu',luong=2000,ngaysinh='5/2/1990',ngaylv='9/7/2013',diachi='Q5',sdt=0123655893 where manv='n09'
update nhanvien set tennv='kg',gioitinh='Nu',luong=2000,ngaysinh='5-2-1990',ngaylv='9-7-2013',diachi='Q5',sdt=0123655893 where manv=''

create table taikhoan
(
     tenhienthi nvarchar(100),
	 pass nvarchar(100),
	 loai int,
	 username nvarchar(100),
	 primary key(username)

)

delete from taikhoan
insert taikhoan
values(N'Ngan','123a',1,N'admin')

select *from taikhoan
select *from taikhoan where username=N'admin' and pass='123a'



create table khachhang
(
    makh nvarchar(5),
	tenkh nvarchar(50),
	gioitinh nvarchar(3),
	ngaysinh date,
	diachi nvarchar(100),
	sdt int,
	primary key(makh)
)

insert khachhang
values('K01',N'NGUYEN ANH','NAM','1970/2/1','Q.1',0978482537)
insert khachhang
values ('K02',N'NGUYEN VAN A','NAM','1980/4/19','Q.2',0968283357)

select *from khachhang
delete from khachhang

create table loaihang
(
  malh nvarchar(5),
  tenlh nvarchar(100),
  primary key(malh)

)

insert loaihang
values('L01','NUOC GIAI KHAT')

insert loaihang
values ('L02','DAU GOI')

insert loaihang
values ('L03','MI')

insert loaihang
values ('L04','KEM DANH RANG')

insert loaihang
values ('L05','SUA')

insert loaihang
values ('L06','KEM')

insert loaihang
values ('L07','BANH')

insert loaihang
values ('L08','KEO')

select *from loaihang


create table hanghoa
(
   mahh nvarchar(5),
   tenhh nvarchar(100),
   malh nvarchar(5),
   sl int,
   donvitinh nvarchar(10),
   mancc nvarchar(5),
   giaban int,
   primary key (mahh)
)

insert hanghoa
values ('H01','NUOC NUMBER ONE','L01',100,'LOC','C01',60000)
insert hanghoa
values  ('H02','NUOC UONG AQUA','L01',100,'CHAI','C01',6000)
insert hanghoa
values ('H03','NUOC NUTRI BOOST ','L01',100,'CHAI','C01',10000)

insert hanghoa
values ('H04','CLEAR DAU GOI ','L02',100,'TUI','C01',55000)
insert hanghoa
values('H05','CLEAR DAU GOI HOA 0G','L02',100,'TUI','C01',54000)

insert hanghoa
values('H06','VINATABA CU','L03',100,'CHAI','C01',20000)
insert hanghoa
values('H07','VINATABA MOI','L03',100,'CHAI','C01',19000)

insert hanghoa
values('H08','MI HAO HOA CHUA CAY','L04',100,'GOI','C02',35000)

insert hanghoa
values('H09','MI XAO HAO HOA','L04',100,'GOI','C02',3000)

insert hanghoa
values ('H10','KEM DANH RANG ','L04',100,'HOP','C03',15000)
insert hanghoa
values('H11','KEM DANH RANG COL','L04',90,'HOP','C03',20000)

insert hanghoa
values('H12','SUA TUOI KHONG D','L05',50,'HOP','C03',6000)
insert hanghoa
values ('H13','SC HUONG L','L05',50,'HOP','C03',3500)

insert hanghoa
values ('H14','KEM VANI 300G','L06',10,'HOP','C04',50000)
insert hanghoa
values('H15','KEM CHUOI','L06',20,'BICH','C04',4000)

insert hanghoa
values('H16','BANH GAO','L07',10,'GOI','C05',18000)
insert hanghoa
values('H17','BANH LA DUA ','L07',20,'GOI','C05',35000)

insert hanghoa
values('H18','KEO THAI ANYTIME','L08',18,'GOI','C06',28000)
insert hanghoa
values('H19','KEO SOBI 350G','L08',23,'GOI','C06',29000)

select *from hanghoa
delete from hanghoa

update hanghoa set tenhh='BANH LA DA', malh='L07',donvitinh='GOI', mancc='C05',giaban=35000 where mahh='H17'
create table nhacungcap
(
   mancc nvarchar(5),
   tenncc nvarchar(40),
   diachi nvarchar(50),
   email nvarchar(20),
   sdt int,
   primary key(mancc)
)

insert nhacungcap
values('C01','NHA CUNG CAP 1','Q.GOVAP','NHACC1@GMAIL.COM',123456870)
insert nhacungcap
values ('C02','NHA CUNG CAP 2','Q.GOVAP','NHACC2@GMAIL.COM',125583456)
insert nhacungcap
values ('C03','NHA CUNG CAP 3','Q.GOVAP','NHACC3@GMAIL.COM',123455568)
insert nhacungcap
values ('C04','NHA CUNG CAP 4','Q.GOVAP','NHACC4@GMAIL.COM',145234560)
insert nhacungcap
values('C05','NHA CUNG CAP 5','Q.GOVAP','NHACC5@GMAIL.COM',126456870)
insert nhacungcap
values('C06','NHA CUNG CAP 6','Q.GOVAP','NHACC6@GMAIL.COM',158456870)

select *from nhacungcap
delete from nhacungcap where mancc='C07'