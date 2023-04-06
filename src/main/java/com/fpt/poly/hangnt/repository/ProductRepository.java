/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.poly.hangnt.repository;

import com.fpt.poly.hangnt.config.HibernatUtil;
import com.fpt.poly.hangnt.custommodel.ViewProductCustomModel;
import java.util.List;
import org.hibernate.query.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author hangnt
 */
public class ProductRepository {

    private static final Logger logger = Logger.getLogger(ProductRepository.class);

    private Session session = HibernatUtil.getFACTORY().openSession();

    private String fromTable = "FROM Product "; // HQL

    public List<ViewProductCustomModel> getAll() {
        String sql = "SELECT new com.fpt.poly.hangnt.custommodel.ViewProductCustomModel"
                + "(p.id AS id ,p.category.categoryName AS categoryName ,"
                + " p.productName AS productName,p.price AS price) "
                + " FROM Product p JOIN Category c "
                + " ON  p.category.id = c.id";
        Query<ViewProductCustomModel> query = session.createQuery(sql);
        List<ViewProductCustomModel> list = query.list();
        return list;
    }

//    public static void main(String[] args) {
//        new ProductRepository().getAll().forEach(s -> System.out.println(s.toString()));
//    }
}
