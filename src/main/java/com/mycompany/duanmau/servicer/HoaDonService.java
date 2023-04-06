/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duanmau.servicer;

import com.mycompany.duanmau.viewModel.HoaDonViewModel;
import com.mycompany.duanmau.entily.HoaDon;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface HoaDonService {

    public HoaDon create(HoaDon hoaDon);

    public HoaDon update(HoaDon hoaDon);

    public HoaDon getOne(String ma);

    public List<HoaDonViewModel> getAll();
}
