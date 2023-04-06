/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.KhachHang;
import com.mycompany.duanmau.repository.KhachHangRepository;
import com.mycompany.duanmau.servicer.KhachHangService;

/**
 *
 * @author vinhnv
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public KhachHang getOne(String ma) {
        KhachHang khachHang = khachHangRepository.getOne(ma.trim());
        return khachHang;
    }

}
