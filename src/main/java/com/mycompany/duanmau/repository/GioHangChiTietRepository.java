/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.GioHangChiTiet;
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
public class GioHangChiTietRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public GioHangChiTiet delete(GioHangChiTiet chiTiet) {
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

    public List<GioHangChiTiet> getOne(UUID idChiTietSanPham) {
        List<GioHangChiTiet> gioHangChiTiet = new ArrayList<>();
        try {
            String query = "SELECT ct "
                    + "FROM GioHangChiTiet ct "
                    + "WHERE ct.chiTietSP.chiTietSanPhamId = :idChiTietSanPham ";
            gioHangChiTiet = session.createQuery(query).setParameter("idChiTietSanPham", idChiTietSanPham).list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return gioHangChiTiet;
    }

    public List<GioHangChiTiet> save (List<GioHangChiTiet> list) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (GioHangChiTiet gioHangChiTiet : list) {
                session.saveOrUpdate(gioHangChiTiet);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
