/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.MauSac;
import com.mycompany.duanmau.repository.MauSacRepository;
import com.mycompany.duanmau.servicer.MauService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public class MauServiceImpl implements MauService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public List<String> getListNameSanPham() {
        List<String> list = new ArrayList<>();
        mauSacRepository.getAll().forEach(a -> list.add(a.getTen()));
        return list;
    }

    @Override
    public MauSac getOne(String name) {
        return mauSacRepository.getByName(name);
    }
}
