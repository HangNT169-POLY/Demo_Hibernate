/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.hibernate;

import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.ChucVu;
import com.mycompany.duanmau.entily.CuaHang;
import com.mycompany.duanmau.entily.DongSP;
import com.mycompany.duanmau.entily.GioHang;
import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.entily.KhachHang;
import com.mycompany.duanmau.entily.MauSac;
import com.mycompany.duanmau.entily.NSX;
import com.mycompany.duanmau.entily.NhanVien;
import com.mycompany.duanmau.entily.SanPham;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author vinhnv
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Properties prop = getProperties();
       
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(prop).build();
         Configuration conf = getConfiguration(prop);
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
    
    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");
        return properties;
    }
    
    public static Configuration getConfiguration(Properties prop) {
        Configuration conf = new Configuration();

        conf.setProperties(prop);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        
        return conf;
    }
}
