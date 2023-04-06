/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel;
import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.request.ChiTietSPRequest;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface ChiTietSPService {

    List<ChiTietSanPhamViewModel> getAll();

    List<ChiTietSP> getAllList();

    String addChiTiet(ChiTietSPRequest request);

    String update(ChiTietSPRequest request, ChiTietSP chiTietSP);

    String delete(ChiTietSP chiTiet);

    ChiTietSP getOne(UUID idChiTiet);

    List<ChiTietSanPhamViewModel> searchByNameSanPham(String tenSanPham);

    List<ChiTietSP> updateAll(List<ChiTietSP> list);
}
