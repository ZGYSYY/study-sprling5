package com.zgy.study.chapter02.helloworld.decoupled;

/**
 * @author ZGY <br>
 * @date 2019/11/19 12:04 <br>
 * @description 代码6 MessageRendererImpl <br>
 */
public class MessageRendererImpl implements MessageRenderer{
    private MessageProvider messageProvider;

    /**
     * 渲染数据
     */
    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("messageProvider 为空：" + MessageRendererImpl.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    /**
     * 设置 MessageProvider
     *
     * @param provider
     */
    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    /**
     * 获取 MessageProvider
     *
     * @return
     */
    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
