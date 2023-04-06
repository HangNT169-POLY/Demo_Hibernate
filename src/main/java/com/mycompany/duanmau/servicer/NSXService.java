/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.entily.NSX;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface NSXService {

    List<NSX> getAll();

    List<String> getListNameSanPham();

    NSX getOne(String name);
}
