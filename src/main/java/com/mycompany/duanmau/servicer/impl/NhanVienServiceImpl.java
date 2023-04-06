/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.NhanVien;
import com.mycompany.duanmau.repository.NhanVienReponsitoy;
import com.mycompany.duanmau.servicer.NhanVienService;

/**
 *
 * @author vinhnv
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienReponsitoy nhanVienReponsitoy = new NhanVienReponsitoy();

    @Override
    public NhanVien getOne(String ma) {
        NhanVien nhanVien = nhanVienReponsitoy.getOne(ma.trim());
        return nhanVien;
    }

}
