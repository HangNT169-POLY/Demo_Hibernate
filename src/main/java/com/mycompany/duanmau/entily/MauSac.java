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
@Table(name = "MauSac")
@NoArgsConstructor
@AllArgsConstructor
public class MauSac implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID idMauSac;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "Ten", length = 30)
    private String ten;

    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    private List<ChiTietSP> listChiTietSP;
    
}
