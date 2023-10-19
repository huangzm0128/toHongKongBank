package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: huangzm
 * @date: 2023/10/18 0018 06:02
 * @description: 订单
 */
public class Order {
    /**
     * 食物列表
     */
    private List<Food> foods = new ArrayList<>(4);

    /**
     * 套餐列表
     */
    private List<SetMenu> setMenus = new ArrayList<>(4);

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 计算总价
     * @return
     */
    public BigDecimal calculateTotalPrice(){
        BigDecimal total = new BigDecimal(0);
        // 计算食物列表总金额
        for (Food item : foods) {
            total =total.add(item.calculate());
        }
        // 计算套餐列表总金额
        for (SetMenu item : setMenus) {
            total =total.add(item.calculatePrice());
        }

        // 应用订单折扣
        total = applyDiscount(total);

        return total;
    }

    /**
     * 添加食物到订单
     * @param item
     */
    public void addFood(Food item) {
        foods.add(item);
    }
    /**
     * 添加套餐到订单
     * @param item
     */
    public void addSetMenu(SetMenu item) {
        setMenus.add(item);
    }

    /**
     * 设置折扣
     * @param discount
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    /**
     * 应用购物车折扣规则
     * @param totalAmount
     * @return
     */
    private BigDecimal applyDiscount(BigDecimal totalAmount) {
        if (this.discount != null){
            // 根据折扣规则来计算折扣金额
            totalAmount = totalAmount.subtract(this.discount);
        }
        return totalAmount;
    }
}
