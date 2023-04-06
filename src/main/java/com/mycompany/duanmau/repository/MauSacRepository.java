/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.MauSac;
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
public class MauSacRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public MauSac create(MauSac ms) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ms;
    }

    public MauSac getByName(String ten) {
        MauSac mau = new MauSac();
        try {
            String query = "SELECT mau "
                    + "FROM MauSac mau "
                    + "WHERE mau.ten LIKE :ten ";
            Query<MauSac> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            mau = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mau;
    }

    public List<MauSac> getAll() {
        List<MauSac> list = new ArrayList<>();
        try {
            String query = "SELECT mau "
                    + "FROM MauSac mau ";
            Query<MauSac> hth = session.createQuery(query);
            list = hth.list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
//        MauSac ms = new MauSacRepository().create(new MauSac(new TaoChuoiNgauNhien().getMaRanDum("#"),"Brown"));
//        System.out.println(ms.toString());
        List<MauSac> list = new MauSacRepository().getAll();
        list.forEach(a->System.out.println(a));

    }
}
