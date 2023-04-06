/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.request;

import java.sql.Date;
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
public class HoaDonRequest {

    private String maNhanVien;
    private String maKhachHang;
    private String tenNguoiNhan;
    private Date ngayShip;
    private Date ngayNhan;
    private String diaChi;
}
