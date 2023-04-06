/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.entily;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID idHoaDon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    
    @Column(name = "Ma" , length = 20)
    private String ma;
    
    @Column(name = "NgayTao" )
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    
    @Column(name = "NgayShip")
    private Date ngayShip;
    
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    
    @Column(name = "TinhTrang")
    private int tinhTrang;
    
    @Column(name = "TenNguoiNhan" , length = 50)
    private String tenNguoiNhan;
    
    @Column(name = "DiaChi", length = 100)
    private String diaChhi;
    
    @Column(name = "Sdt", length = 30)
    private String sdt;
    
    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    public HoaDon(KhachHang khachHang, NhanVien idNhanVien, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChhi, String sdt) {
        this.khachHang = khachHang;
        this.nhanVien = idNhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChhi = diaChhi;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", idKhachHang=" + khachHang + ", nhanVien=" + nhanVien + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayShip=" + ngayShip + ", ngayNhan=" + ngayNhan + ", tinhTrang=" + tinhTrang + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChhi=" + diaChhi + ", sdt=" + sdt + '}';
    }
    
    
}
