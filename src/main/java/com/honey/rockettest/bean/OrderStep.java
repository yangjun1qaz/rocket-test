package com.honey.rockettest.bean;


/**
 * @author ：Brayden
 * @date ：Created in 2021/2/1 18:14
 * @description：
 * @modified By：
 * @version:
 */

public class OrderStep {

    private long orderId;
    private String desc;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderStep{" +
                "orderId=" + orderId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
