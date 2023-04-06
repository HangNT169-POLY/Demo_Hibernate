/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.request;

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
public class ChiTietSPRequest {
    
    private String tenSp;  
    private String tenNSX;
    private String tenMau;
    private String tenDong;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
}
