/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.viewModel.HoaDonViewModel;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.repository.HoaDonRepository;
import com.mycompany.duanmau.servicer.HoaDonService;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public HoaDon create(HoaDon hoaDon) {

        return hoaDonRepository.create(hoaDon);
    }

    @Override
    public List<HoaDonViewModel> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        return hoaDonRepository.update(hoaDon);
    }

    @Override
    public HoaDon getOne(String ma) {
        return hoaDonRepository.getOne(ma);
    }

}
