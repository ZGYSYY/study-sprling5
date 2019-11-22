package com.zgy.study.chapter04.subject09.demo01;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author ZGY <br>
 * @date 2019/11/22 14:20 <br>
 * @description App <br>
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "test.txt");
        file.createNewFile();
        file.deleteOnExit();

        TimeUnit.SECONDS.sleep(1);

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:subject09/demo01/app-context.xml");
        context.refresh();

        PropertyEditorBean propertyEditorBean = context.getBean("propertyEditorBean", PropertyEditorBean.class);

        context.close();
    }
}
