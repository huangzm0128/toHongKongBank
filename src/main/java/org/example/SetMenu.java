package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: huangzm
 * @date: 2023/10/19 0019 12:16
 * @description: 套餐
 */
public class SetMenu {

    /**
     * 套餐内食品列表
     */
    private List<Food> list = new ArrayList<>(8);
    /**
     * 折扣
     */
    private SetMenuDiscountRule discountRule;

    public SetMenu(SetMenuDiscountRule discountRule) {
        this.discountRule = discountRule;
    }

    /**
     * 计算套餐总金额
     * @return
     */
    public BigDecimal calculatePrice(){
        BigDecimal total = new BigDecimal(0);
        // 计算套餐总金额
        for (Food item : list) {
            total =total.add(item.calculate());
        }

        if (discountRule != null){
            // 应用套餐折扣规则
            total = applyDiscount(total);
        }

        return total;
    }

    /**
     * 添加商品到套餐
     * @param item
     */
    public void addFood(Food item) {
        list.add(item);
    }

    /**
     * 设置套餐折扣
     * @param foodDiscountRule
     */
    public void setDiscount(SetMenuDiscountRule foodDiscountRule) {
        discountRule = foodDiscountRule;
    }
    /**
     * 应用购物车折扣规则
     * @param totalAmount
     * @return
     */
    private BigDecimal applyDiscount(BigDecimal totalAmount) {
        // 根据折扣规则来计算折扣金额
        int comparisonResult  = totalAmount.compareTo(discountRule.getThreshold());
        if (comparisonResult >= 0){
            // 应用相应的折扣金额
            totalAmount = totalAmount.subtract(discountRule.getDiscount());
        }
        return totalAmount;
    }


}
