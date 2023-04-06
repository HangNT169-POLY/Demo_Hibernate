/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.request;

import com.mycompany.duanmau.entily.GioHangChiTiet;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vinhnv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTietRequest {

    private BigDecimal donGia;
    private BigDecimal DonGiaKhiGiam;
    private int soLuong;
    private UUID idChiTiet;
    private UUID idGioHang;
    
    
}
