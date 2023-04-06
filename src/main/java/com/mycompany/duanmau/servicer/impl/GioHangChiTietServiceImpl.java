/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.repository.ChiTietSPRepository;
import com.mycompany.duanmau.repository.GioHangChiTietRepository;
import com.mycompany.duanmau.repository.HoaDonRepository;
import com.mycompany.duanmau.request.GioHangChiTietRequest;
import com.mycompany.duanmau.servicer.GioHangChiTietService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    private GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    public void delete(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }

    @Override
    public List<GioHangChiTiet> getOne(UUID idChiTietSanPham) {
        return gioHangChiTietRepository.getOne(idChiTietSanPham);
    }

    @Override
    public GioHangChiTiet getConvert(GioHangChiTietRequest request ) {
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setDonGia(request.getDonGia());
        gioHangChiTiet.setSoLuong(request.getSoLuong());
        gioHangChiTiet.setGioHang(null);
        gioHangChiTiet.setDonGiaKhiGiam(request.getDonGia());
        gioHangChiTiet.setChiTietSP(chiTietSPRepository.getOne(request.getIdChiTiet()));
        return gioHangChiTiet;
    }

    @Override
    public List<GioHangChiTiet> saveAll(List<GioHangChiTiet> list) {
        return gioHangChiTietRepository.save(list);
    }

}
