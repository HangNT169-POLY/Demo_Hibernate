/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.viewModel.HoaDonViewModel;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vinhnv
 */
public class HoaDonRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public HoaDon create(HoaDon hoaDon) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }
     public HoaDon update(HoaDon hoaDon) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(hoaDon);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }


    public HoaDon getOne( String maHD) {
        Transaction transaction = null;
        HoaDon hoaDon = new HoaDon();
        try {
            transaction = session.beginTransaction();
            String query = "SELECT hd FROM HoaDon hd WHERE hd.ma = :maHD ";
            hoaDon = (HoaDon) session.createQuery(query).setParameter("maHD", maHD).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }

    public List<HoaDonViewModel> getAll() {
        Transaction transaction = null;
        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT new com.mycompany.duanmau.viewModel.HoaDonViewModel "
                    + " ( hd.idHoaDon AS idHoaDon ,"
                    + " hd.ma AS maHoaDon , "
                    + " hd.ngayTao AS ngayTao ,"
                    + " nv.ten AS tenNhanVien ,"
                    + " hd.tinhTrang AS tinhTrang "
                    + " )"
                    + " FROM HoaDon hd "
                    + " JOIN NhanVien nv ON nv.idNhanVien = hd.nhanVien.idNhanVien "
                    + " ORDER BY hd.ngayTao DESC";
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
//        List<HoaDonViewModel> list = new HoaDonRepository().getAll();
//        list.forEach(a -> System.out.println(a));
        
        HoaDon hoaDon = new HoaDonRepository().getOne("HD241");
        System.out.println(hoaDon); 
   }
}
