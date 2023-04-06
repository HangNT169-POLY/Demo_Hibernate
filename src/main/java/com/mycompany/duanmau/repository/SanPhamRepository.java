/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.SanPham;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import com.mycompany.duanmau.infrastructure.TaoChuoiNgauNhien;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vinhnv
 */
public class SanPhamRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public SanPham create(SanPham sp) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public SanPham update(SanPham sp) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public SanPham delete(SanPham sp) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public SanPham getByName(String ten) {
        SanPham sp = new SanPham();
        try {
            String query = "SELECT sp "
                    + "FROM SanPham sp "
                    + "WHERE sp.ten LIKE :ten ";
            Query<SanPham> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            sp = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public SanPham getByMa(String ma) {
        SanPham sp = new SanPham();
        try {
            String query = "SELECT sp "
                    + "FROM SanPham sp "
                    + "WHERE sp.ma LIKE :ma ";
            Query<SanPham> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            sp = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        try {
            String query = "SELECT sp "
                    + "FROM SanPham sp ";
            Query<SanPham> hth = session.createQuery(query);
            list = hth.list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        SanPham sp = new SanPham(new TaoChuoiNgauNhien().getMaRanDum("SP"), "May tinh");
        SanPham sp1 = new SanPhamRepository().create(sp);
        System.out.println(sp1.toString());

    }
}
