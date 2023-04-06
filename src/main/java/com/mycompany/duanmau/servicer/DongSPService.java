/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.entily.DongSP;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface DongSPService {

    List<DongSP> getAll();

    List<String> getListNameSanPham();

    DongSP getOne(String name);
}
