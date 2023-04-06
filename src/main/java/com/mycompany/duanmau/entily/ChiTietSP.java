/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.entily;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Table(name = "ChiTietSP")
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id" , columnDefinition = "uniqueidentifier")
    private UUID chiTietSanPhamId;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "Mota", length = 50)
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @OneToMany(mappedBy = "chiTietSP",  fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGHCT;
    
    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    public ChiTietSP(SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "chiTietSanPhamId=" + chiTietSanPhamId + ", sanPham=" + sanPham + ", nsx=" + nsx + ", mauSac=" + mauSac + ", dongSP=" + dongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

   
    

}
