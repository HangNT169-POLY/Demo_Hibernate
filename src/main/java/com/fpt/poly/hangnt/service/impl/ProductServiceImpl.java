/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.poly.hangnt.service.impl;

import com.fpt.poly.hangnt.custommodel.ViewProductCustomModel;
import com.fpt.poly.hangnt.repository.ProductRepository;
import com.fpt.poly.hangnt.service.ProductService;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<ViewProductCustomModel> getAll() {
        return productRepository.getAll();
    }

}
