package com.tuyoo.bi.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

/**
 * @Author zhangpengfei
 * @Date 2023-06-05 17:59
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class TmpProducer03 {

    Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        TmpProducer03 tmpProducer = new TmpProducer03();
        tmpProducer.producer();
    }
    public void producer() throws InterruptedException {
        //连接集群，通过配置文件方式,获取Kafka生产者的client
        Properties props = new Properties();
        //props.put("bootstrap.servers", "192.168.20.83:9092");
        props.put("bootstrap.servers", "10.201.30.16:9092,10.201.30.28:9092,10.201.30.81:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

        int cnt = 1;
        while (true) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("project_id", "141");
            jsonObject.put("client_id", "H5_2.0_weixin.weixin.0-hall141.weixin.WXpay");
            jsonObject.put("type", "track");
            jsonObject.put("event", "test_event3");
            jsonObject.put("device_id", getUserId());
            jsonObject.put("user_id", getUserId());
            jsonObject.put("event_time", System.currentTimeMillis() - 1000 * 60 * 60 * 18L);
            jsonObject.put("properties", getPropertiesEvent3_052());
            jsonObject.put("lib", getLib());

            System.out.println(jsonObject);
            kafkaProducer.send(new ProducerRecord<String, String>("ga_log_141" ,JSONObject.toJSONString(jsonObject)));
            Thread.sleep(100);

            cnt ++;
            if (cnt > 20)
                return;
        }
    }

    public String getUserId() {
        String prefix = "100";
        int i = random.nextInt(199999);
        String suf = String.format("%06d", i);
        return prefix + suf;
    }


    public JSONObject getPropertiesEvent3_05() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sdk_yidun_device_id", "eqrfegadsghytrewrwq");

        return jsonObject;
    }

    public JSONObject getPropertiesEvent3_051() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("android_id", "reqwfew342546gdsagas");

        return jsonObject;
    }

    public JSONObject getPropertiesEvent3_052() {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }



    public JSONObject getLib() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lib_type", "test");
        jsonObject.put("lib_version", "0.1.0");
        return jsonObject;
    }
}
