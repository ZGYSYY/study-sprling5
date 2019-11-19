package com.zgy.study.chapter02.helloworld.decoupled;

/**
 * @author ZGY <br>
 * @date 2019/11/19 12:03 <br>
 * @description 代码5 MessageProviderImpl <br>
 */
public class MessageProviderImpl implements MessageProvider{
    /**
     * 返回信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
