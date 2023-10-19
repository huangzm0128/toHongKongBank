package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: huangzm
 * @date: 2023/10/19 0019 12:13
 * @description: 食品
 */
@Data
@AllArgsConstructor
public class Food {
    /**
     * 类型
     */
    private String type;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 计算单个价格
     * @param
     * @return
     */
    public BigDecimal calculate(){
        if (discount == null){
            return unitPrice;
        }
        return this.unitPrice.multiply(discount);
    }
}
