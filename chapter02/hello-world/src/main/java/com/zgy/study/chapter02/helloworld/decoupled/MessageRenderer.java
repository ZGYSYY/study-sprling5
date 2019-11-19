package com.zgy.study.chapter02.helloworld.decoupled;

/**
 * @author ZGY <br>
 * @date 2019/11/19 11:59 <br>
 * @description 代码4 MessageRenderer <br>
 */
public interface MessageRenderer {
    /**
     * 渲染数据
     */
    void render();

    /**
     * 设置 MessageProvider
     * @param provider
     */
    void setMessageProvider(MessageProvider provider);

    /**
     * 获取 MessageProvider
     * @return
     */
    MessageProvider getMessageProvider();
}
