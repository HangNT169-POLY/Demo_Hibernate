/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.DongSP;
import com.mycompany.duanmau.repository.DongSPRepository;
import com.mycompany.duanmau.servicer.DongSPService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinhnv
 */
public class DongServiceImpl implements DongSPService {

    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public List<String> getListNameSanPham() {
        List<String> list = new ArrayList<>();
        dongSPRepository.getAll().forEach(a -> list.add(a.getTen()));
        return list;
    }

    @Override
    public DongSP getOne(String name) {
        return dongSPRepository.getByName(name);
    }

}
