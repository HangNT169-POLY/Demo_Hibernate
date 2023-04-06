/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.viewModel;

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
public class GioHangViewModel {

    private UUID idchiTietSP;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private BigDecimal donGia;
}
