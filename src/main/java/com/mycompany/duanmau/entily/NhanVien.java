/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.entily;

import java.io.Serializable;
import java.sql.Date;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vinhnv
 */
@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien implements Serializable{
    
    @Id 
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID idNhanVien;
    
    @Column(name = "Ma" ,  length = 20 )
    private String ma;
    
    @Column(name = "Ten" , length = 30)
    private String ten;
    
    @Column(name = "TenDem", length = 30 )
    private String tenDem;
    
    @Column(name = "Ho", length = 30)
    private String ho;
    
    @Column(name = "GioiTinh", length = 10 )
    private String gioiTinh;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "Sdt",length = 30 )
    private String sdt;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGuiBC")
    private NhanVien idGuiBC;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH")
    private CuaHang idCuaHang;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV")
    private ChucVu ChucVu;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @OneToMany(mappedBy = "idGuiBC" , fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;
   
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<HoaDon> listGioHang;
    
}
