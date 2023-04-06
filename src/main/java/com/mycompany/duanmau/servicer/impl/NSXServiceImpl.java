/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.NSX;
import com.mycompany.duanmau.repository.NSXRepository;
import com.mycompany.duanmau.servicer.NSXService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public class NSXServiceImpl implements NSXService {

    private NSXRepository nSXRepository = new NSXRepository();
    @Override
    public List<NSX> getAll() {
      return nSXRepository.getAll();
    }

    @Override
    public List<String> getListNameSanPham() {
        List<String> list = new ArrayList<>();
        nSXRepository.getAll().forEach(a -> list.add(a.getTen()));
        return list;
    }

    @Override
    public NSX getOne(String name) {
        return nSXRepository.getByName(name);
    }

}
