/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.NSX;
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
public class NSXRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public NSX create(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nsx;
    }

    public NSX update(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nsx;
    }

    public NSX delete(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nsx;
    }

    public NSX getByName(String ten) {
        NSX mau = new NSX();
        try {
            String query = "SELECT n "
                    + "FROM NSX n "
                    + "WHERE n.ten LIKE :ten ";
            Query<NSX> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            mau = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mau;
    }

    public List<NSX> getAll() {
        List<NSX> list = new ArrayList<>();
        try {
            String query = "SELECT n "
                    + "FROM NSX n ";
            Query<NSX> hth = session.createQuery(query);
            list = hth.list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        NSX nsx = new NSXRepository().getByName("1990");
        System.out.println(nsx);

//        for (int i = 1980; i < 1995; i++) {
//            new NSXRepository().create(new NSX(new TaoChuoiNgauNhien().getMaRanDum(""),""+i));
//        }
    }

}
