/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.repository.ChiTietSPRepository;
import com.mycompany.duanmau.repository.HoaDonChiTietRepository;
import com.mycompany.duanmau.repository.HoaDonRepository;
import com.mycompany.duanmau.request.GioHangChiTietRequest;
import com.mycompany.duanmau.request.HoaDonChiTietRequest;
import com.mycompany.duanmau.servicer.HoaDonChiTietService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
        private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();


    @Override
    public void delete(HoaDonChiTiet hoaDonChiTiet) {

        hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }

    @Override
    public List<HoaDonChiTiet> getOne(UUID idChiTietSanPham) {
        return hoaDonChiTietRepository.getOne(idChiTietSanPham);
    }

    @Override
    public HoaDonChiTiet getConvert(GioHangChiTietRequest request , String maHD) {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setDonGia(request.getDonGia());
        hoaDonChiTiet.setHoaDon(hoaDonRepository.getOne(maHD));
        hoaDonChiTiet.setChiTietSP(chiTietSPRepository.getOne(request.getIdChiTiet()));
        hoaDonChiTiet.setSoLuong(request.getSoLuong());
        return hoaDonChiTiet;
    }

    @Override
    public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> list) {
        return hoaDonChiTietRepository.saveAll(list);
    }

}
