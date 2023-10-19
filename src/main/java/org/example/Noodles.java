package org.example;

import lombok.*;

import java.math.BigDecimal;

/**
 * @auther: huangzm
 * @date: 2023/10/19 0019 12:08
 * @description: 面
 */
@ToString
@Setter
@Getter
public class Noodles extends Food{

    /**
     * 大小
     */
    private String size;

    public Noodles(String type, BigDecimal unitPrice, BigDecimal discount, String size) {
        super(type, unitPrice, discount);
        this.size = size;
    }
}
