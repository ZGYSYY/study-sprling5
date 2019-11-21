package com.zgy.study.chapter04.subject03.demo01;

import org.springframework.beans.factory.InitializingBean;

import java.io.File;

/**
 * @author ZGY <br>
 * @date 2019/11/21 17:03 <br>
 * @description DestructiveBean <br>
 */
public class DestructiveBean implements InitializingBean {

    private File file;
    private String filePath;

    public void setFile(File file) {
        this.file = file;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
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
