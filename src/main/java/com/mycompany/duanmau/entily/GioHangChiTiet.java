/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.entily;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID gioHangChiTietId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;
}
