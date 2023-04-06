/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.SanPham;
import com.mycompany.duanmau.repository.SanPhamRepository;
import com.mycompany.duanmau.servicer.SanPhamService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public List<String> getListNameSanPham() {
        List<String> list = new ArrayList<>();
        sanPhamRepository.getAll().forEach(a -> list.add(a.getTen()));
        return list;
    }

    @Override
    public SanPham getOne(String name) {
        return sanPhamRepository.getByName(name);
    }

}
