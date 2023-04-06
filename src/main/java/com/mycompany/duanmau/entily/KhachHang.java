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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID idKhachHang;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "Ten", length = 30)
    private String ten;

    @Column(name = "TenDem", length = 30)
    private String tenDem;

    @Column(name = "Ho", length = 30)
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "ThanhPho", length = 50)
    private String thanhPho;

    @Column(name = "QuocGia", length = 50)
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "idKhachHang", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang;
    
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;

    

}
