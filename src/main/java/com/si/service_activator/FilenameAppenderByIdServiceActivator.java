package com.si.service_activator;

import com.si.exception.IdFormatException;
import com.si.handler.ErrorHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;

public class FilenameAppenderByIdServiceActivator {
    @Autowired
    @Qualifier("errorHandler")
    private ErrorHandler errorHandler;

    public String appendFilenames(Message<String> message) {
        String filename = message.getHeaders().get("file_name").toString();

        String payload = message.getPayload();
        String[] lines = payload.split("\r?\n");

        StringBuilder sb;
        try {
            sb = formPayload(filename, lines);
            System.out.println(sb);
            return sb.toString();
        } catch (IdFormatException e) {
            errorHandler.handleError(e, message.getHeaders(), message.getPayload());
            return null;
        }
    }

    private StringBuilder formPayload(String filename, String[] lines) throws IdFormatException {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (!StringUtils.isNumeric(line)) throw new IdFormatException(line);
            sb.append(line).append(",").append(filename).append("\n");
        }
        return sb;
    }
}
