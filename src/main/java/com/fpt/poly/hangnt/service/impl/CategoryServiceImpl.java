/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.poly.hangnt.service.impl;

import com.fpt.poly.hangnt.domainmodel.Category;
import com.fpt.poly.hangnt.repository.CategoryRepository;
import com.fpt.poly.hangnt.service.CategoryService;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

}
