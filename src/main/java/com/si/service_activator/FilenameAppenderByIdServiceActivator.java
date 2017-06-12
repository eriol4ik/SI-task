package com.si.service_activator;

import org.springframework.messaging.Message;

public class FilenameAppenderByIdServiceActivator {
    public String appendFilenames(Message<String> message) {
        String payload = message.getPayload();
        String[] lines = payload.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append(",").append(message.getHeaders().get("file_name")).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }
}
