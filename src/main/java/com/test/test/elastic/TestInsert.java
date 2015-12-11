package com.test.test.elastic;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

/**
 * Created by zhengying on 15/12/11.
 */
public class TestInsert {

    public static void main(String[] args) {
        Client client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

        String log = "02:10:14.469 10.20.25.74 - 02:10:01,808  INFO AopIFace:100 - AOPLog:apptx:151211000194216207,method:ecaop.trades.query.comm.cust.check,SC:560,req:{\"accessType\":\"01\",\"bizkey\":\"CS-010\",\"certNum\":\"445202******232475\",\"certType\":\"02\",\"channelId\":\"51b13gv\",\"channelType\":\"1030100\",\"checkType\":\"0\",\"city\":\"526\",\"district\":\"0000000000\",\"opeSysType\":\"2\",\"operatorId\":\"DZJYJ011\",\"province\":\"51\",\"serType\":\"1\"},rsp:{\"detail\":\"510420151211021001642171285581:客户ID不存在\",\"code\":\"0001\"}";

        client.prepareIndex("loggers", "log").setSource(generateJson(log)).execute().actionGet();

        client.close();

        System.out.println("end");
    }

    public static String generateJson(String log) {
        String json = "";
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
            contentBuilder.field("log", log);
            json = contentBuilder.endObject().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
