package com.factory.method;

import java.util.HashMap;
import java.util.Map;

public class MyFactoryMethodMain {

    public static void main(String[] args) {
        IMyMessageFactory myMessageFactory = new MyMessageFactory();

        IMyMessage myMessage;

        Map<String, Object> map = new HashMap<>();
        map.put("PHONENUM", "PHONENUM");
        map.put("EMAIL", "EMAIL");
        map.put("OAUSERNAME","OAUSERNAME");

        try {
            //短信通知
            myMessage = myMessageFactory.createMessage("SMS");
            myMessage.setMessageParam(map);
            myMessage.sendMessage();

            //oa待办
            myMessage = myMessageFactory.createMessage("OA");
            myMessage.setMessageParam(map);
            myMessage.sendMessage();

            //来一个邮件通知
            myMessage = myMessageFactory.createMessage("EMAIL");
            myMessage.setMessageParam(map);
            myMessage.sendMessage();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
