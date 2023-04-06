/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.DongSP;
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
public class DongSPRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public DongSP create(DongSP dong) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dong);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dong;
    }

    public DongSP getByName(String ten) {
        DongSP dong = new DongSP();
        try {
            String query = "SELECT dong "
                    + "FROM DongSP dong "
                    + "WHERE dong.ten LIKE :ten ";
            Query<DongSP> hth = session.createQuery(query);
            hth.setParameter("ten", ten);
            dong = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dong;
    }

    public List<DongSP> getAll() {
        List<DongSP> dong = new ArrayList<>();
        try {
            String query = "SELECT dong "
                    + "FROM DongSP dong ";
            Query<DongSP> hth = session.createQuery(query);
            dong = hth.list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dong;
    }

    public static void main(String[] args) {
//        DongSP dong = new DongSPRepository().create(new DongSP(new TaoChuoiNgauNhien().getMaRanDum("Dong"), "Gày dép"));
//        System.out.println(dong.toString());

        DongSP sp3 = new DongSPRepository().getByName("Quần áo");
        System.out.println(sp3);
        
//        List<DongSP> list = new DongSPRepository().getAll();
//        list.forEach(a->System.out.println(a));
    }
}
