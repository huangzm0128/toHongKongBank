package org.example;

import java.math.BigDecimal;

/**
 * @auther: huangzm
 * @date: ${DATE} ${HOUR}:${MINUTE}
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        // 初始化
        Food smallBeefNoodleSoup = new Noodles("牛肉面",new BigDecimal(14),null,"小" );
        Food mediumBeefNoodleSoup = new Noodles("牛肉面",new BigDecimal(16),null,"中" );
        Food largeBeefNoodleSoup = new Noodles("牛肉面",new BigDecimal(18),null,"大" );
        Food smallIntestineNoodles = new Noodles("肥肠面",new BigDecimal(16),null,"小" );
        Food mediumIntestineNoodles = new Noodles("肥肠面",new BigDecimal(18),null,"中" );
        Food largeIntestineNoodles = new Noodles("肥肠面",new BigDecimal(20),null,"大" );
        Food beefPatty = new Food("牛肉饼",new BigDecimal(10),null );
        Food milkTea = new Food("奶茶",new BigDecimal(12),null );

        // 套餐1，折扣满40-2
        SetMenuDiscountRule setMenu1Discount1 = new SetMenuDiscountRule(new BigDecimal(40), new BigDecimal(2));
        // 套餐1
        SetMenu setMenu1 = new SetMenu(setMenu1Discount1);
        // 套餐2，折扣满40-2
        SetMenuDiscountRule setMenu1Discount2 = new SetMenuDiscountRule(new BigDecimal(40), new BigDecimal(2));
        // 套餐2
        SetMenu setMenu2 = new SetMenu(setMenu1Discount2);

        setMenu1.addFood(largeBeefNoodleSoup);
        setMenu1.addFood(beefPatty);
        setMenu1.addFood(milkTea);

        setMenu2.addFood(largeIntestineNoodles);
        setMenu2.addFood(beefPatty);
        setMenu2.addFood(milkTea);

        // 张三的订单
        Order zsOrder = new Order();
        zsOrder.addSetMenu(setMenu1);
        zsOrder.addFood(beefPatty);
        BigDecimal zsOrderPrice = zsOrder.calculateTotalPrice();

        // 李四的订单
        Order lsOrder = new Order();
        lsOrder.addFood(mediumIntestineNoodles);
        lsOrder.addFood(milkTea);
        lsOrder.addFood(milkTea);
        BigDecimal lsOrderPrice = lsOrder.calculateTotalPrice();

        System.out.printf("张三要向面馆付款%s元%n", zsOrderPrice);
        System.out.printf("李四要向面馆付款%s元%n", lsOrderPrice);
    }
}