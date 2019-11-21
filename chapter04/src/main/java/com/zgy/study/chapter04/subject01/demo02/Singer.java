package com.zgy.study.chapter04.subject01.demo02;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author ZGY <br>
 * @date 2019/11/21 15:47 <br>
 * @description Singer <br>
 */
public class Singer implements InitializingBean {

    private static final String DEFAULT_NAME = "DEFAULT_NAME";

    private String name;
    private int age = Integer.MIN_VALUE;

    public Singer() {
        System.out.println("执行了构造方法");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
        if (name == null) {
            System.out.println("name 为 null，将使用默认的 name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("你必须要设置 age 的值：" + Singer.class);
        }
    }
}
