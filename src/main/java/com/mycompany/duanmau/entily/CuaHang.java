/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.entily;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "CuaHang")
@NoArgsConstructor
@AllArgsConstructor
public class CuaHang implements Serializable{
    
    @Id 
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID idCuaHang;
    
    @Column(name = "Ma",length = 20)
    private String ma;
    
    @Column(name = "Ten", length = 50)
    private String ten;
    
    @Column(name = "DiaChi", length = 100)
    private String diaChi;
    
    @Column(name = "ThanhPho", length = 50)
    private String thanhPho;
    
    @Column(name = "QuocGia", length = 50)
    private String quocGia;
    
    @OneToMany(mappedBy = "idCuaHang" , fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

    public CuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

}
