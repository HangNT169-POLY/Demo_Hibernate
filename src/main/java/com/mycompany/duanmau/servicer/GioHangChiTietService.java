/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.request.GioHangChiTietRequest;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author vinhnv
 */
public interface GioHangChiTietService {

    void delete(GioHangChiTiet gioHangChiTiet);
    
    List<GioHangChiTiet> getOne (UUID idChiTietSanPham);
    
    GioHangChiTiet getConvert(GioHangChiTietRequest request );
    
    List<GioHangChiTiet> saveAll( List<GioHangChiTiet> list );

}
