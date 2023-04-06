/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.repository;

import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.CuaHang;
import com.mycompany.duanmau.hibernate.HibernateUtil;
import com.mycompany.duanmau.infrastructure.TaoChuoiNgauNhien;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vinhnv
 */
public class CuaHangRepository {
    
    private Session session = HibernateUtil.getFACTORY().openSession();

    public CuaHang create(CuaHang cuaHang) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cuaHang;
    }
    public static void main(String[] args) {
        CuaHang cuaHang = new CuaHangRepository().create(new CuaHang(
                new TaoChuoiNgauNhien().getMaRanDum("CH"), "VanVinh", "Đan Phượng", "Hà Nội", "Việt Nam"));
        System.out.println(cuaHang.toString());
    }
}
