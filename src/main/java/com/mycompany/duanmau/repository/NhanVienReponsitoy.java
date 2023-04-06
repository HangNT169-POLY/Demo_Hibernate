/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.ChucVu;
import com.mycompany.duanmau.entily.NhanVien;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import com.mycompany.duanmau.infrastructure.TaoChuoiNgauNhien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vinhnv
 */
public class NhanVienReponsitoy {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public NhanVien create(NhanVien nhanVien) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;
    }

    public NhanVien update(NhanVien nv) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien delete(NhanVien nv) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public NhanVien getOne(String ma) {
        NhanVien nv = new NhanVien();
        try {
            String query = "SELECT sp "
                    + "FROM NhanVien sp "
                    + "WHERE sp.ma LIKE :ten ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("ten", "%" + ma + "%");
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;

    }

    public static void main(String[] args) {
        NhanVien nhanVien = new NhanVienReponsitoy().getOne("NV744");
        System.out.println(nhanVien);
    }
}
