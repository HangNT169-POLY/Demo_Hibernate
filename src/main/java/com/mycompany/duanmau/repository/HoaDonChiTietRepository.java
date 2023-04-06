/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.viewModel.GioHangViewModel;
import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vinhnv
 */
public class HoaDonChiTietRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public HoaDonChiTiet delete(HoaDonChiTiet chiTiet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(chiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTiet;
    }

    public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> list) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (HoaDonChiTiet hoaDonChiTiet : list) {
                session.save(hoaDonChiTiet);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<HoaDonChiTiet> getOne(UUID idChiTietSanPham) {
        List<HoaDonChiTiet> hoaDonChiTiet = new ArrayList<>();
        try {
            String query = "SELECT ct "
                    + "FROM HoaDonChiTiet ct "
                    + "WHERE ct.chiTietSP.chiTietSanPhamId = :idChiTietSanPham ";
            hoaDonChiTiet = session.createQuery(query).setParameter("idChiTietSanPham", idChiTietSanPham).list();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }

    public List<GioHangViewModel> getHoaDonChiTietCustom(UUID idHoaDon) {
        Transaction transaction = null;
        List<GioHangViewModel> listCustoms = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = "SELECT new com.mycompany.duanmau.viewModel.GioHangViewModel "
                    + " (  hdct.chiTietSP.chiTietSanPhamId AS idchiTietSP ,"
                    + "    hdct.chiTietSP.sanPham.ma AS maSP ,"
                    + "    hdct.chiTietSP.sanPham.ten AS tenSP ,"
                    + "    hdct.soLuong AS soLuong ,"
                    + "    hdct.donGia AS donGia  "
                    + " ) "
                    + " FROM HoaDonChiTiet hdct"
                    + " JOIN ChiTietSP ct ON ct.chiTietSanPhamId = hdct.chiTietSP.chiTietSanPhamId "
                    + " JOIN HoaDon hd ON hd.idHoaDon = hdct.hoaDon.idHoaDon "
                    + " WHERE hdct.hoaDon.idHoaDon = :idHoaDon";
            listCustoms = session.createQuery(query).setParameter("idHoaDon", idHoaDon).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCustoms;
    }

    public static void main(String[] args) {
        String o = "2B11EEC9-9774-6A4D-B095-053658446374";
        UUID ok = UUID.fromString(o);
        List<GioHangViewModel> list = new HoaDonChiTietRepository().getHoaDonChiTietCustom(ok);
        System.out.println(list.size());
    }

}
