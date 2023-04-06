/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.entily.MauSac;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface MauService {

    List<MauSac> getAll();

    List<String> getListNameSanPham();

    MauSac getOne(String name);
}
