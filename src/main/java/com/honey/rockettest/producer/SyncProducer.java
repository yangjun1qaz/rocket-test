package com.honey.rockettest.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.nio.charset.Charset;

/**
 * @author ：Brayden
 * @date ：Created in 2021/1/28 16:49
 * @description：
 * @modified By：
 * @version:
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("producer-group");
        // 设置NameServer的地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 10000000; i++) {
            Message message = new Message("brayden", "tags", "keys" + i, ("message" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult send = producer.send(message);
            System.out.println(send.toString());
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
