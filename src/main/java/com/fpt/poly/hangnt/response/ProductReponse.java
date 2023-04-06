/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.poly.hangnt.response;

import com.fpt.poly.hangnt.domainmodel.Product;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hangnt
 */
@Getter
@Setter
public class ProductReponse {

    private Long productId;

    private String categoryName;

    private String categoryCode;

    private String productCode;

    private String productName;

    private Float price;

    private String description;

    public ProductReponse() {
    }

    public ProductReponse(Product product) {
        this.productId = product.getId();
        this.categoryCode = product.getCategory().getCategoryCode();
        this.categoryName = product.getCategory().getCategoryName();
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

    public Object[] toDataRow() {
        return new Object[]{productId, productCode, categoryCode, productName, categoryName, price, description};
    }
}
