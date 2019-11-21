package com.zgy.study.chapter04.subject04.demo01;

import java.io.File;
import java.io.IOException;

/**
 * @author ZGY <br>
 * @date 2019/11/21 17:03 <br>
 * @description DestructiveBean <br>
 */
public class DestructiveBean {

    private File file;
    private String filePath;

    public void setFile(File file) {
        this.file = file;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void init() throws IOException {
        System.out.println("初始化 Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("filePath 为 null，请输入 filePath。" + DestructiveBean.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("文件是否存在：" + this.file.exists());
    }

    public void destroy() {
        System.out.println("开始删除创建的文件。。。");
        if(!file.delete()) {
            System.err.println("删除文件出错");
        }
        System.out.println("文件是否存在：" + this.file.exists());
    }
}
