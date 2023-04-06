/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.ChucVu;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import com.mycompany.duanmau.infrastructure.TaoChuoiNgauNhien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vinhnv
 */
public class ChucVuRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public ChucVu create(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chucVu;
    }
    public ChucVu getByMa(String ma) {
        ChucVu chucVu = new ChucVu();
        try {
            String query = "SELECT cv "
                    + "FROM ChucVu cv "
                    + "WHERE cv.ma LIKE :ma ";
            Query<ChucVu> hth = session.createQuery(query);
            hth.setParameter("ma", ma.trim());
            chucVu = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chucVu;
    }

    public static void main(String[] args) {
//        ChucVu chucVu = new ChucVuRepository().create(new ChucVu(
//                new TaoChuoiNgauNhien().getMaRanDum("CV"), "Nhân viên"));

        ChucVu chucVu = new ChucVuRepository().getByMa("CV224");
        System.out.println(chucVu.toString());
        
    }
}
