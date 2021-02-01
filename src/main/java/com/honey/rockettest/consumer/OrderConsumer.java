package com.honey.rockettest.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;


/**
 * @author ：Brayden
 * @date ：Created in 2021/2/1 18:34
 * @description：
 * @modified By：
 * @version:
 */
public class OrderConsumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group");
        // 设置NameServer的地址
        consumer.setNamesrvAddr("localhost:9876");

        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("brayden", "TagA || TagC || TagD");

        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }

}
