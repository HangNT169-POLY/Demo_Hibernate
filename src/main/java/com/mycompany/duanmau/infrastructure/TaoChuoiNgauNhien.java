/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duanmau.infrastructure;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author vinhnv
 */
public class TaoChuoiNgauNhien {

    public String getMaRanDum(String macDinh) {
        String generator = macDinh+ RandomStringUtils.randomNumeric(3);       
        return generator;
    }

    public static void main(String[] args) {
        Random generator = new Random();
        int value = generator.nextInt(10);
        System.out.println(value);

        String soMoi = RandomStringUtils.randomNumeric(3);
        System.out.println(soMoi);
    }
}
