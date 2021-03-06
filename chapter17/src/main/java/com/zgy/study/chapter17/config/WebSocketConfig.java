package com.zgy.study.chapter17.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
# 知识点
@EnableWebSocket：将其添加到 @Configuration 类，以便配置处理 WebSocket 请求。
 */

/**
 * @author ZGY <br/>
 * @date 2019/12/10 17:28 <br/>
 * @description WebSocketConfig <br/>
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        LOGGER.info("=======================> 执行了 public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) 方法");
        registry.addHandler(new EchoHandler(), "/echoHandler");
    }

    /**
     * 这是一个基本的处理程序，它接收提供的消息并简单的将其回送给客户端。
     */
    private class EchoHandler extends TextWebSocketHandler {
        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            // message.getPayload()：所接收的 WebSocket 消息的内容包含在该方法中。
            if ("ping".equals(message.getPayload())) {
                session.sendMessage(new TextMessage(message.getPayload()));
            } else {
                session.sendMessage(new TextMessage(message.getPayload() + "！"));
            }
        }
    }
}
