package com.si.handler;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

import java.util.Arrays;

public class ErrorHandler {
    private MessageChannel defaultErrorChannel;

    public void handleError(Throwable t, MessageHeaders headers, String payload) {
        Message message = MessageBuilder
                .withPayload(payload)
                .copyHeadersIfAbsent(headers)
                .build();

        defaultErrorChannel.send(message);
    }

    public MessageChannel getDefaultErrorChannel() {
        return defaultErrorChannel;
    }

    public void setDefaultErrorChannel(MessageChannel defaultErrorChannel) {
        this.defaultErrorChannel = defaultErrorChannel;
    }
}
