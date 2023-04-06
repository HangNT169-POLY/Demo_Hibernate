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
import lombok.NoArgsConstructor;

/**
 *
 * @author vinhnv
 */
@Entity
@Data
@Table(name = "GioHang")
public class GioHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID gioHangId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH")
    private KhachHang idKhachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNV")
    private NhanVien idNhanVien;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TenNguoiNhan", length = 50)
    private String tenNguoiNhan;

    @Column(name = "DiaChi", length = 100)
    private String diaChhi;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGHCT;
}
