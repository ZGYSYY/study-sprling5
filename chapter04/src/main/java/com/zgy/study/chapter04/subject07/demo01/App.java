package com.zgy.study.chapter04.subject07.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * @author ZGY <br>
 * @date 2019/11/22 11:45 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject07/demo01/app-context.xml");
        context.refresh();

        MessageDigest shaMessageDigestFactoryBean = context.getBean("shaMessageDigestFactoryBean", MessageDigest.class);
        byte[] digest = shaMessageDigestFactoryBean.digest("好好学习，天天向上".getBytes());
        System.out.println(digest);

        // 直接使用 FactoryBean 对象
        MessageDigestFactoryBean messageDigestFactoryBean = (MessageDigestFactoryBean)context.getBean("&shaMessageDigestFactoryBean");
        MessageDigest messageDigest = messageDigestFactoryBean.getObject();
        byte[] digest2 = messageDigest.digest("老子明天不上班".getBytes());
        System.out.println(digest2);

        context.close();
    }
}
