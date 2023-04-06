/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.infrastructure;

import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.ChucVu;
import com.mycompany.duanmau.entily.CuaHang;
import com.mycompany.duanmau.entily.DongSP;
import com.mycompany.duanmau.entily.GioHang;
import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.entily.KhachHang;
import com.mycompany.duanmau.entily.MauSac;
import com.mycompany.duanmau.entily.NSX;
import com.mycompany.duanmau.entily.NhanVien;
import com.mycompany.duanmau.entily.SanPham;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import static com.mycompany.duanmau.hibernate.HibernateUtil.getConfiguration;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author vinhnv
 */
public class GenDB {
    //Tạo DB trong SQL SERVER = SOFT2041_PTPM
    //Sau đó tiến hành chạy đển zen bảng

    public static void main(String[] args) {

        Properties prop = HibernateUtil.getProperties();
        prop.put(Environment.HBM2DDL_AUTO, "create");
        // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(prop)
                .build();

        // tạo lớp giao tiếp với jdbc
        Configuration conf = getConfiguration(prop);
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        // tạo giao dịch tương ứng 
        Transaction trans = session.beginTransaction();


        MauSac mauSac1 = new MauSac();
        mauSac1.setMa(new TaoChuoiNgauNhien().getMaRanDum("#"));
        mauSac1.setTen("Red");
//        mauSac1.setIdMauSac(mauSac1.getIdMauSac());
        session.save(mauSac1);

        MauSac mauSac2 = new MauSac();
        mauSac2.setMa(new TaoChuoiNgauNhien().getMaRanDum("#"));
        mauSac2.setTen("Yellow");
//        mauSac2.setIdMauSac(mauSac2.getIdMauSac());
        session.save(mauSac2);

        MauSac mauSac3 = new MauSac();
        mauSac3.setMa(new TaoChuoiNgauNhien().getMaRanDum("#"));
        mauSac3.setTen("Blue");
//        mauSac3.setIdMauSac(mauSac3.getIdMauSac());
        session.save(mauSac3);

        MauSac mauSac4 = new MauSac();
        mauSac4.setMa(new TaoChuoiNgauNhien().getMaRanDum("#"));
        mauSac4.setTen("Black");
//        mauSac4.setIdMauSac(mauSac4.getIdMauSac());
        session.save(mauSac4);

        MauSac mauSac5 = new MauSac();
        mauSac5.setMa(new TaoChuoiNgauNhien().getMaRanDum("#"));
        mauSac5.setTen("White");
//        mauSac5.setIdMauSac(mauSac5.getIdMauSac());
        session.save(mauSac5);

        DongSP dongSP = new DongSP();
        dongSP.setTen("Iphone");
        dongSP.setMa(new TaoChuoiNgauNhien().getMaRanDum("DO"));
//        dongSP.setIdDongSP(dongSP.getIdDongSP());
        session.save(dongSP);

        DongSP dongSP1 = new DongSP();
        dongSP1.setTen("Sam Sung");
        dongSP1.setMa(new TaoChuoiNgauNhien().getMaRanDum("DO"));
//        dongSP1.setIdDongSP(dongSP1.getIdDongSP());
        session.save(dongSP1);

        DongSP dongSP2 = new DongSP();
        dongSP2.setTen("Oppo");
        dongSP2.setMa(new TaoChuoiNgauNhien().getMaRanDum("DO"));
//        dongSP2.setIdDongSP(dongSP2.getIdDongSP());
        session.save(dongSP2);

        SanPham sanPham = new SanPham();
        sanPham.setTen("San pham 1");
        sanPham.setMa(new TaoChuoiNgauNhien().getMaRanDum("SP"));
//        sanPham.setIdSP(sanPham.getIdSP());
        session.save(sanPham);

        SanPham sanPham1 = new SanPham();
        sanPham1.setTen("San pham 2");
        sanPham1.setMa(new TaoChuoiNgauNhien().getMaRanDum("SP"));
//        sanPham1.setIdSP(sanPham1.getIdSP());
        session.save(sanPham1);

        SanPham sanPham2 = new SanPham();
        sanPham2.setTen("San pham 3");
        sanPham2.setMa(new TaoChuoiNgauNhien().getMaRanDum("SP"));
//        sanPham2.setIdSP(sanPham2.getIdSP());
        session.save(sanPham2);

        NSX nsx = new NSX();
        nsx.setMa(new TaoChuoiNgauNhien().getMaRanDum("NSX"));
        nsx.setTen("Hà Nội");
//        nsx.setIdNsx(nsx.getIdNsx());
        session.save(nsx);

        NSX nsx1 = new NSX();
        nsx1.setMa(new TaoChuoiNgauNhien().getMaRanDum("NSX"));
        nsx1.setTen("HCM");
//        nsx1.setIdNsx(nsx1.getIdNsx());
        session.save(nsx1);

        NSX nsx2 = new NSX();
        nsx2.setMa(new TaoChuoiNgauNhien().getMaRanDum("NSX"));
        nsx2.setTen("Đà Nẵng");
//        nsx2.setIdNsx(nsx2.getIdNsx());
        session.save(nsx2);

        NSX nsx3 = new NSX();
        nsx3.setMa(new TaoChuoiNgauNhien().getMaRanDum("NSX"));
        nsx3.setTen("Cần Thơ");
//        nsx3.setIdNsx(nsx3.getIdNsx());
        session.save(nsx3);

        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(new TaoChuoiNgauNhien().getMaRanDum("CH"));
        cuaHang.setTen("Cửa Hàng 01");
        cuaHang.setDiaChi("Hà Nội");
        cuaHang.setThanhPho("HN");
        cuaHang.setQuocGia("Việt Nam");
//        cuaHang.setIdCuaHang(cuaHang.getIdCuaHang());
        session.save(cuaHang);

        CuaHang cuaHang1 = new CuaHang();
        cuaHang1.setMa(new TaoChuoiNgauNhien().getMaRanDum("CH"));
        cuaHang1.setTen("Cửa Hàng 02");
        cuaHang1.setDiaChi("HCM");
        cuaHang1.setThanhPho("HCM");
        cuaHang1.setQuocGia("Việt Nam");
//        cuaHang1.setIdCuaHang(cuaHang1.getIdCuaHang());
        session.save(cuaHang1);

        CuaHang cuaHang2 = new CuaHang();
        cuaHang2.setMa(new TaoChuoiNgauNhien().getMaRanDum("CH"));
        cuaHang2.setTen("Cửa Hàng 03");
        cuaHang2.setDiaChi("Da Nang");
        cuaHang2.setThanhPho("Da Nang");
        cuaHang2.setQuocGia("Việt Nam");
//        cuaHang2.setIdCuaHang(cuaHang2.getIdCuaHang());
        session.save(cuaHang2);

        ChucVu chucVu = new ChucVu();
        chucVu.setMa(new TaoChuoiNgauNhien().getMaRanDum("CV"));
        chucVu.setTen("Nhan Vien");
//        chucVu.setIdChucVu(chucVu.getIdChucVu());
        session.save(chucVu);
        

        ChucVu chucVu1 = new ChucVu();
        chucVu1.setMa(new TaoChuoiNgauNhien().getMaRanDum("CV"));
        chucVu1.setTen("Truong Phong");
//        chucVu1.setIdChucVu(chucVu1.getIdChucVu());
        session.save(chucVu1);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setHo("Nguyen");
        nhanVien.setTenDem("Van");
        nhanVien.setTen("Nguyen Van A");
        nhanVien.setMa("NV001");
        nhanVien.setSdt("0123456789");
        nhanVien.setTrangThai(0);
        nhanVien.setMatKhau("1");
        nhanVien.setIdCuaHang(cuaHang);
        nhanVien.setChucVu(chucVu1);
        nhanVien.setIdGuiBC(nhanVien);
        nhanVien.setNgaySinh(Date.valueOf("2003-01-21"));
        nhanVien.setGioiTinh("Nam");
        nhanVien.setDiaChi("Hà Nội");
//        nhanVien.setIdNhanVien(nhanVien.getIdNhanVien());
        session.save(nhanVien);

        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setHo("Nguyen");
        nhanVien1.setTenDem("Van");
        nhanVien1.setTen("B");
        nhanVien1.setMa(new TaoChuoiNgauNhien().getMaRanDum("NV"));
        nhanVien1.setSdt("0123456799");
        nhanVien1.setTrangThai(0);
        nhanVien1.setMatKhau("1");
        nhanVien1.setIdCuaHang(cuaHang1);
        nhanVien1.setChucVu(chucVu);
        nhanVien1.setIdGuiBC(nhanVien1);
        nhanVien1.setNgaySinh(Date.valueOf("2003-01-21"));
        nhanVien1.setGioiTinh("Nữ");
        nhanVien1.setDiaChi("Hà Nội");
//        nhanVien1.setIdNhanVien(nhanVien1.getIdNhanVien());
        session.save(nhanVien1);

        NhanVien nhanVien2 = new NhanVien();
        nhanVien2.setHo("Nguyen");
        nhanVien2.setTenDem("Van");
        nhanVien2.setTen("B");
        nhanVien2.setMa(new TaoChuoiNgauNhien().getMaRanDum("NV"));
        nhanVien2.setSdt("0123456799");
        nhanVien2.setTrangThai(0);
        nhanVien2.setMatKhau("1");
        nhanVien2.setIdCuaHang(cuaHang1);
        nhanVien2.setChucVu(chucVu);
        nhanVien2.setIdGuiBC(nhanVien);
        nhanVien2.setNgaySinh(Date.valueOf("2003-01-21"));
        nhanVien2.setGioiTinh("Nữ");
        nhanVien2.setDiaChi("Hà Nội");
//        nhanVien2.setIdNhanVien(nhanVien2.getIdNhanVien());
        session.save(nhanVien2);

        ChiTietSP chiTietSP = new ChiTietSP();
        chiTietSP.setChiTietSanPhamId(chiTietSP.getChiTietSanPhamId());
        chiTietSP.setSanPham(sanPham);
        chiTietSP.setNsx(nsx);
        chiTietSP.setMauSac(mauSac3);
        chiTietSP.setDongSP(dongSP1);
        chiTietSP.setNamBH(2022);
        chiTietSP.setMoTa("Tốt");
        chiTietSP.setSoLuongTon(25);
        chiTietSP.setGiaNhap(new BigDecimal(10000.0));
        chiTietSP.setGiaBan(new BigDecimal(200000.0));
        session.save(chiTietSP);

        ChiTietSP chiTietSP1 = new ChiTietSP();
        chiTietSP1.setChiTietSanPhamId(chiTietSP1.getChiTietSanPhamId());
        chiTietSP1.setSanPham(sanPham1);
        chiTietSP1.setNsx(nsx1);
        chiTietSP1.setMauSac(mauSac5);
        chiTietSP1.setDongSP(dongSP2);
        chiTietSP1.setNamBH(2022);
        chiTietSP1.setMoTa("Tốt");
        chiTietSP1.setSoLuongTon(124);
        chiTietSP1.setGiaNhap(new BigDecimal(10000.0));
        chiTietSP1.setGiaBan(new BigDecimal(200000.0));
        session.save(chiTietSP1);

        ChiTietSP chiTietSP2 = new ChiTietSP();
        chiTietSP2.setChiTietSanPhamId(chiTietSP2.getChiTietSanPhamId());
        chiTietSP2.setSanPham(sanPham2);
        chiTietSP2.setNsx(nsx);
        chiTietSP2.setMauSac(mauSac5);
        chiTietSP2.setDongSP(dongSP);
        chiTietSP2.setNamBH(2022);
        chiTietSP2.setMoTa("Tốt");
        chiTietSP2.setSoLuongTon(30);
        chiTietSP2.setGiaNhap(new BigDecimal(10000.0));
        chiTietSP2.setGiaBan(new BigDecimal(200000.0));
        session.save(chiTietSP2);

       

        KhachHang khachHang = new KhachHang();
//        khachHang.setIdKhachHang(khachHang.getIdKhachHang());
        khachHang.setMa(new TaoChuoiNgauNhien().getMaRanDum("KH"));
        khachHang.setTen("A");
        khachHang.setTenDem("Quoc");
        khachHang.setHo("Nguyen");
        khachHang.setNgaySinh(Date.valueOf("2003-04-22"));
        khachHang.setSdt("0123456789");
        khachHang.setDiaChi("Ba Vi");
        khachHang.setThanhPho("Hà Nội");
        khachHang.setQuocGia("Viet Nam");
        khachHang.setMatKhau("1");
        session.save(khachHang);

        KhachHang khachHang1 = new KhachHang();
//        khachHang1.setIdKhachHang(khachHang1.getIdKhachHang());
        khachHang1.setMa("KH001");
        khachHang1.setTen("B");
        khachHang1.setTenDem("Quoc");
        khachHang1.setHo("Nguyen");
        khachHang1.setNgaySinh(Date.valueOf("2003-04-22"));
        khachHang1.setSdt("0123456789");
        khachHang1.setDiaChi("Ba Vi");
        khachHang1.setThanhPho("Hà Nội");
        khachHang1.setQuocGia("Viet Nam");
        khachHang1.setMatKhau("1");
        session.save(khachHang1);

        KhachHang khachHang2 = new KhachHang();
//        khachHang2.setIdKhachHang(khachHang2.getIdKhachHang());
        khachHang2.setMa(new TaoChuoiNgauNhien().getMaRanDum("KH"));
        khachHang2.setTen("C");
        khachHang2.setTenDem("Quoc");
        khachHang2.setHo("Nguyen");
        khachHang2.setNgaySinh(Date.valueOf("2003-04-22"));
        khachHang2.setSdt("0123456789");
        khachHang2.setDiaChi("Ba Vi");
        khachHang2.setThanhPho("Hà Nội");
        khachHang2.setQuocGia("Viet Nam");
        khachHang2.setMatKhau("1");
        session.save(khachHang2);

        GioHang gioHang = new GioHang();
//        gioHang.setGioHangId(gioHang.getGioHangId());
        gioHang.setIdKhachHang(khachHang);
        gioHang.setIdNhanVien(nhanVien);
        gioHang.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang.setTenNguoiNhan("Nguyễn Quốc Huy");
        gioHang.setDiaChhi("Hà Nội");
        gioHang.setSdt("0123456789");
        gioHang.setTinhTrang(0);
        session.save(gioHang);

        GioHang gioHang1 = new GioHang();
//        gioHang1.setGioHangId(gioHang1.getGioHangId());
        gioHang1.setIdKhachHang(khachHang);
        gioHang1.setIdNhanVien(nhanVien);
        gioHang1.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang1.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang1.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang1.setTenNguoiNhan("Nguyễn Quốc A");
        gioHang1.setDiaChhi("Hà Nội");
        gioHang1.setSdt("0123456789");
        gioHang1.setTinhTrang(1);
        session.save(gioHang1);

        GioHang gioHang2 = new GioHang();
//        gioHang2.setGioHangId(gioHang2.getGioHangId());
        gioHang2.setIdKhachHang(khachHang1);
        gioHang2.setIdNhanVien(nhanVien);
        gioHang2.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang2.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang2.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang2.setTenNguoiNhan("Nguyễn Quốc B");
        gioHang2.setDiaChhi("Hà Nội");
        gioHang2.setSdt("0123456789");
        gioHang2.setTinhTrang(0);
        session.save(gioHang2);

        GioHang gioHang3 = new GioHang();
//        gioHang3.setGioHangId(gioHang3.getGioHangId());
        gioHang3.setIdKhachHang(khachHang2);
        gioHang3.setIdNhanVien(nhanVien);
        gioHang3.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang3.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang3.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang3.setTenNguoiNhan("Nguyễn Quốc C");
        gioHang3.setDiaChhi("Hà Nội");
        gioHang3.setSdt("0123456789");
        gioHang3.setTinhTrang(0);
        session.save(gioHang3);

        GioHang gioHang4 = new GioHang();
//        gioHang4.setGioHangId(gioHang4.getGioHangId());
        gioHang4.setIdKhachHang(khachHang2);
        gioHang4.setIdNhanVien(nhanVien);
        gioHang4.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang4.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang4.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang4.setTenNguoiNhan("Nguyễn Quốc Huy");
        gioHang4.setDiaChhi("Hà Nội");
        gioHang4.setSdt("0123456789");
        gioHang4.setTinhTrang(0);
        session.save(gioHang4);

        GioHang gioHang5 = new GioHang();
//        gioHang5.setGioHangId(gioHang5.getGioHangId());
        gioHang5.setIdKhachHang(khachHang);
        gioHang5.setIdNhanVien(nhanVien);
        gioHang5.setMa(new TaoChuoiNgauNhien().getMaRanDum("GH"));
        gioHang5.setNgayTao(Date.valueOf("2022-05-22"));
        gioHang5.setNgayThanhToan(Date.valueOf("2022-06-30"));
        gioHang5.setTenNguoiNhan("Nguyễn Quốc Huy");
        gioHang5.setDiaChhi("Hà Nội");
        gioHang5.setSdt("0123456789");
        gioHang5.setTinhTrang(0);
        session.save(gioHang5);

        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setGioHang(gioHang);
        gioHangChiTiet.setChiTietSP(chiTietSP);
        gioHangChiTiet.setSoLuong(2);
        gioHangChiTiet.setDonGia(new BigDecimal(10000.0));
        gioHangChiTiet.setDonGiaKhiGiam(new BigDecimal(9000.1));
        session.save(gioHangChiTiet);

        GioHangChiTiet gioHangChiTiet1 = new GioHangChiTiet();
        gioHangChiTiet1.setGioHang(gioHang1);
        gioHangChiTiet1.setChiTietSP(chiTietSP);
        gioHangChiTiet1.setSoLuong(2);
        gioHangChiTiet1.setDonGia(new BigDecimal(10000.0));
        gioHangChiTiet1.setDonGiaKhiGiam(new BigDecimal(9000.1));
        session.save(gioHangChiTiet1);

        GioHangChiTiet gioHangChiTiet2 = new GioHangChiTiet();
        gioHangChiTiet2.setGioHang(gioHang);
        gioHangChiTiet2.setChiTietSP(chiTietSP1);
        gioHangChiTiet2.setSoLuong(2);
        gioHangChiTiet2.setDonGia(new BigDecimal(10000.0));
        gioHangChiTiet2.setDonGiaKhiGiam(new BigDecimal(9000.1));
        session.save(gioHangChiTiet2);

        GioHangChiTiet gioHangChiTiet3 = new GioHangChiTiet();
        gioHangChiTiet3.setGioHang(gioHang1);
        gioHangChiTiet3.setChiTietSP(chiTietSP1);
        gioHangChiTiet3.setSoLuong(2);
        gioHangChiTiet3.setDonGia(new BigDecimal(10000.0));
        gioHangChiTiet3.setDonGiaKhiGiam(new BigDecimal(9000.1));
        session.save(gioHangChiTiet3);

        HoaDon hd = new HoaDon();
//        hd.setIdHoaDon(hd.getIdHoaDon());
        hd.setKhachHang(khachHang1);
        hd.setNhanVien(nhanVien);
        hd.setMa(new TaoChuoiNgauNhien().getMaRanDum("HD"));
        hd.setNgayTao(Date.valueOf("2022-08-22"));
        hd.setNgayThanhToan(Date.valueOf("2022-08-22"));
        hd.setNgayShip(Date.valueOf("2022-08-22"));
        hd.setNgayNhan(Date.valueOf("2022-08-22"));
        hd.setTinhTrang(0);
        hd.setTenNguoiNhan("Huy");
        hd.setDiaChhi("Hà Nội");
        hd.setSdt("0123456789");
        session.save(hd);

        HoaDon hd1 = new HoaDon();
//        hd1.setIdHoaDon(hd.getIdHoaDon());
        hd1.setKhachHang(khachHang);
        hd1.setNhanVien(nhanVien1);
        hd1.setMa(new TaoChuoiNgauNhien().getMaRanDum("HD"));
        hd1.setNgayTao(Date.valueOf("2022-08-22"));
        hd1.setNgayThanhToan(Date.valueOf("2022-08-22"));
        hd1.setNgayShip(Date.valueOf("2022-08-22"));
        hd1.setNgayNhan(Date.valueOf("2022-08-22"));
        hd1.setTinhTrang(0);
        hd1.setTenNguoiNhan("Huy");
        hd1.setDiaChhi("Hà Nội");
        hd1.setSdt("0123456789");
        session.save(hd1);

        HoaDon hd2 = new HoaDon();
//        hd2.setIdHoaDon(hd.getIdHoaDon());
        hd2.setKhachHang(khachHang2);
        hd2.setNhanVien(nhanVien1);
        hd2.setMa(new TaoChuoiNgauNhien().getMaRanDum("HD"));
        hd2.setNgayTao(Date.valueOf("2022-08-22"));
        hd2.setNgayThanhToan(Date.valueOf("2022-08-22"));
        hd2.setNgayShip(Date.valueOf("2022-08-22"));
        hd2.setNgayNhan(Date.valueOf("2022-08-22"));
        hd2.setTinhTrang(0);
        hd2.setTenNguoiNhan("Huy");
        hd2.setDiaChhi("Hà Nội");
        hd2.setSdt("0123456789");
        session.save(hd2);

        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setHoaDon(hd);
        hdct.setChiTietSP(chiTietSP);
        hdct.setSoLuong(2);
        hdct.setDonGia(new BigDecimal(10000.0));
        session.save(hdct);

        HoaDonChiTiet hdct1 = new HoaDonChiTiet();
        hdct1.setHoaDon(hd1);
        hdct1.setChiTietSP(chiTietSP);
        hdct1.setSoLuong(2);
        hdct1.setDonGia(new BigDecimal(10000.0));
        session.save(hdct1);

        HoaDonChiTiet hdct2 = new HoaDonChiTiet();
        hdct2.setHoaDon(hd);
        hdct2.setChiTietSP(chiTietSP1);
        hdct2.setSoLuong(2);
        hdct2.setDonGia(new BigDecimal(10000.0));
        session.save(hdct2);

        // db generator : gen bảng tự động
        trans.commit();
    }

}
