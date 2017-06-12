package com.si.filter;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import java.io.File;

public class FileSelector implements MessageSelector {
    private final String REGEX = "(LIA_products_)(Marks|Lequipeur)_([0-9]{4})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])((0[1-9]|[0-9][0-9])|())(.csv)";

    public boolean accept(Message<?> message) {
        return message.getPayload().getClass() == File.class &&
                ((File) message.getPayload()).getName()
                        .matches(REGEX);

    }
}
