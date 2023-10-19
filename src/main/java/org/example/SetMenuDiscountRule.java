package org.example;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: huangzm
 * @date: 2023/10/19 0019 12:23
 * @description: 套餐折扣 -- 满减
 */
@Data
public class SetMenuDiscountRule {
    /**
     * 满足折扣条件的金额阈值
     */
    private BigDecimal threshold;
    /**
     * 折扣金额
     */
    private BigDecimal discount;

    public SetMenuDiscountRule(BigDecimal threshold, BigDecimal discount) {
        this.threshold = threshold;
        this.discount = discount;
    }
}
