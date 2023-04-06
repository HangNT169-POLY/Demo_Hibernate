/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel;
import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.DongSP;
import com.mycompany.duanmau.entily.MauSac;
import com.mycompany.duanmau.entily.NSX;
import com.mycompany.duanmau.entily.SanPham;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vinhnv
 */
public class ChiTietSPRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public ChiTietSP create(ChiTietSP chiTiet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTiet;
    }

    public List<ChiTietSP> updateAll(List<ChiTietSP> list) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (ChiTietSP chiTiet : list) {
                session.update(chiTiet);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public ChiTietSP update(ChiTietSP chiTiet, UUID idChiTiet) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(String.valueOf(idChiTiet), chiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTiet;
    }

    public ChiTietSP delete(ChiTietSP chiTiet) {
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

    public List<ChiTietSanPhamViewModel> searchByNameTenSp(String tenSanPham) {
        Transaction transaction = null;
        List<ChiTietSanPhamViewModel> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT new com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel "
                    + " ( ct.chiTietSanPhamId AS idChiTiet ,"
                    + " ct.sanPham.ma  AS maSanPham , "
                    + " ct.sanPham.ten AS tenSanPham ,"
                    + " ct.namBH AS namBaoHanh ,"
                    + " ct.moTa AS moTa ,"
                    + " ct.soLuongTon AS soLuongSanPham ,"
                    + " ct.giaNhap AS giaNhap ,"
                    + " ct.giaBan AS giaBan "
                    + " )"
                    + " FROM ChiTietSP ct "
                    + " JOIN SanPham sp ON sp.idSP = ct.sanPham.idSP "
                    + " WHERE sp.ten LIKE :tenSanPham ";
            list = session.createQuery(query).setParameter("tenSanPham", "%" + tenSanPham + "%").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ChiTietSanPhamViewModel> getAll() {
        Transaction transaction = null;
        List<ChiTietSanPhamViewModel> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT new com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel "
                    + " ( ct.chiTietSanPhamId AS idChiTiet ,"
                    + " ct.sanPham.ma  AS maSanPham , "
                    + " ct.sanPham.ten AS tenSanPham ,"
                    + " ct.namBH AS namBaoHanh ,"
                    + " ct.moTa AS moTa ,"
                    + " ct.soLuongTon AS soLuongSanPham ,"
                    + " ct.giaNhap AS giaNhap ,"
                    + " ct.giaBan AS giaBan "
                    + " )"
                    + " FROM ChiTietSP ct "
                    + " JOIN SanPham sp ON sp.idSP = ct.sanPham.idSP";
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ChiTietSP> getAllList() {
        Transaction transaction = null;
        List<ChiTietSP> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT ct "
                    + " FROM ChiTietSP ct ";
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public ChiTietSP getOne(UUID idChiTiet) {
        ChiTietSP sp = new ChiTietSP();
        try {
            String query = "SELECT ct "
                    + "FROM ChiTietSP ct "
                    + "WHERE ct.chiTietSanPhamId = :idChiTiet ";
            sp = (ChiTietSP) session.createQuery(query).setParameter("idChiTiet", idChiTiet).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public static void main(String[] args) {

        SanPham sp = new SanPhamRepository().getByName("San pham 3");
        System.out.println(sp);
//        MauSac mau = new MauSacRepository().getByName("Rep");
//        DongSP dong = new DongSPRepository().getByName("ĐIện tử");
//        NSX nsx = new NSXRepository().getByName("2001");
//        ChiTietSP chiTietSP = new ChiTietSP(sp, nsx, mau, dong, 1999, "Sony Xperia XQBE62 PRO-I Smartphone", 20, new BigDecimal(20000), new BigDecimal(26000));
//        ChiTietSP creat = new ChiTietSPRepository().create(chiTietSP);
//        System.out.println(creat);
    }
}
