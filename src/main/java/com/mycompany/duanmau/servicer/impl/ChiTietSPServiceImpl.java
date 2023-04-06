/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.servicer.impl;

import com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel;

import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.repository.ChiTietSPRepository;
import com.mycompany.duanmau.repository.DongSPRepository;
import com.mycompany.duanmau.repository.MauSacRepository;
import com.mycompany.duanmau.repository.NSXRepository;
import com.mycompany.duanmau.repository.SanPhamRepository;
import com.mycompany.duanmau.request.ChiTietSPRequest;
import com.mycompany.duanmau.servicer.ChiTietSPService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public class ChiTietSPServiceImpl implements ChiTietSPService {

    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private NSXRepository nSXRepository = new NSXRepository();

    @Override
    public String addChiTiet(ChiTietSPRequest request) {

        ChiTietSP chiTietSP = new ChiTietSP();
        if (request.getGiaBan().intValue() < 0) {
            return "giá bán không để nhỏ hơn 0";
        }
        if (request.getGiaNhap().intValue() < 0) {
            return "giá nhập không để nhỏ hơn 0";
        }
        if (request.getNamBH() < 0) {
            return "Năm phải là số Dương ";
        }
        chiTietSP.setDongSP(dongSPRepository.getByName(request.getTenDong()));
        chiTietSP.setNsx(nSXRepository.getByName(request.getTenNSX()));
        chiTietSP.setSanPham(sanPhamRepository.getByName(request.getTenSp()));
        chiTietSP.setMauSac(mauSacRepository.getByName(request.getTenMau()));
        chiTietSP.setGiaNhap(request.getGiaNhap());
        chiTietSP.setGiaBan(request.getGiaBan());
        chiTietSP.setMoTa(request.getMoTa());
        chiTietSP.setNamBH(request.getNamBH());
        chiTietSP.setSoLuongTon(request.getSoLuongTon());
        ChiTietSP chiTiet = chiTietSPRepository.create(chiTietSP);
        if (chiTiet != null) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public List<ChiTietSanPhamViewModel> getAll() {
        return chiTietSPRepository.getAll();
    }

    @Override
    public String update(ChiTietSPRequest request ,ChiTietSP chiTietSP) {
        if (request.getGiaBan().intValue() < 0) {
            return "giá bán không để nhỏ hơn 0";
        }
        if (request.getGiaNhap().intValue() < 0) {
            return "giá nhập không để nhỏ hơn 0";
        }
        if (request.getNamBH() < 0) {
            return "Năm phải là số Dương ";
        }
        chiTietSP.setDongSP(dongSPRepository.getByName(request.getTenDong()));
        chiTietSP.setNsx(nSXRepository.getByName(request.getTenNSX()));
        chiTietSP.setSanPham(sanPhamRepository.getByName(request.getTenSp()));
        chiTietSP.setMauSac(mauSacRepository.getByName(request.getTenMau()));
        chiTietSP.setGiaNhap(request.getGiaNhap());
        chiTietSP.setGiaBan(request.getGiaBan());
        chiTietSP.setMoTa(request.getMoTa());
        chiTietSP.setNamBH(request.getNamBH());
        chiTietSP.setSoLuongTon(request.getSoLuongTon());
        ChiTietSP chiTiet = chiTietSPRepository.update(chiTietSP,chiTietSP.getChiTietSanPhamId());
        if (chiTiet != null) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(ChiTietSP chiTiet) {
        if (chiTiet == null) {
            return "không tìm thấy ";
        } else {
            chiTietSPRepository.delete(chiTiet);
        }
        return " Đã delete thành công";
    }

    @Override
    public List<ChiTietSanPhamViewModel> searchByNameSanPham(String tenSanPham) {
        return chiTietSPRepository.searchByNameTenSp(tenSanPham);
    }

    @Override
    public ChiTietSP getOne(UUID idChiTiet) {
        return chiTietSPRepository.getOne(idChiTiet);
    }

    @Override
    public List<ChiTietSP> updateAll(List<ChiTietSP> list) {
        return chiTietSPRepository.updateAll(list);
    }

    @Override
    public List<ChiTietSP> getAllList() {
        return chiTietSPRepository.getAllList();
    }

}
