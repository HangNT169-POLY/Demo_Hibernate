/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.KhachHang;
import com.mycompany.duanmau.entily.NhanVien;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vinhnv
 */
public class KhachHangRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    public KhachHang getOne(String ma) {
        KhachHang khachHang = new KhachHang();
        try {
            String query = "SELECT kh "
                    + "FROM KhachHang kh "
                    + "WHERE kh.ma = :ma ";
            Query<KhachHang> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            khachHang = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }
    public static void main(String[] args) {
        KhachHang hk =  new KhachHangRepository().getOne("KH001");
        System.out.println(hk.getIdKhachHang());
    }
}
