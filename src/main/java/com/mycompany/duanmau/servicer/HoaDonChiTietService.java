/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.request.GioHangChiTietRequest;
import com.mycompany.duanmau.request.HoaDonChiTietRequest;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface HoaDonChiTietService {

    void delete(HoaDonChiTiet hoaDonChiTiet);

    List<HoaDonChiTiet> getOne(UUID idChiTietSanPham);

    HoaDonChiTiet getConvert(GioHangChiTietRequest request , String maHD);

    List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> list);

}
