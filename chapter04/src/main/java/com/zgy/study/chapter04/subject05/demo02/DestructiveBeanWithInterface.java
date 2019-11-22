package com.zgy.study.chapter04.subject05.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * @author ZGY <br>
 * @date 2019/11/22 10:24 <br>
 * @description DestructiveBeanWithInterface <br>
 */
public class DestructiveBeanWithInterface {

    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    private void init() throws IOException {
        System.out.println("初始化 Bean 。。。");
        if (filePath == null) {
            throw new IllegalArgumentException("请设置文件路径，" + this.getClass());
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("文件是否存在：" + file.exists());
    }

    @PreDestroy
    private void destroy() {
        System.out.println("销毁 Bean 。。。");
        if (!this.file.delete()) {
            System.out.println("文件删除失败，出现了未知错误！");
        }
        System.out.println("文件是否存在：" + file.exists());
    }

}
