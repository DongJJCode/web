package com.web.webservicedemo;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CxfClient {

    public static void main(String[] args) {
        //cxf2();

        try {
            return;
        } finally {
            System.out.println("finally");
        }
    }

    public static void cxf1() {
        try {
            //接口地址
            String address = "http://localhost:8080/services/CommonService";
            //  代理工程
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            //  设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            //  创建一个代理接口实现
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            //  数据准备
            CommonService commonService = (CommonService) jaxWsProxyFactoryBean.create();
            //  调用代理接口的方法调用并返回结果
            String userName = "dongjj";
            //
            String result = commonService.sayHello(userName);
            System.out.println("返回结果 : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cxf2() {
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = jaxWsDynamicClientFactory.createClient("http://localhost:8080/services/CommonService?wsdl");
        Object[] objects = new Object[0];
        try {
            objects = client.invoke("sayHello", "DongJJ");
            System.out.println("返回数据 ： " + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
