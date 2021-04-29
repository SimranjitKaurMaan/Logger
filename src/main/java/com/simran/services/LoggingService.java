package com.simran.services;

import com.simran.models.Message;
import lombok.NonNull;


import java.time.LocalDateTime;

public class LoggingService
{
    private SinkService sinkService;

    public LoggingService(SinkService sinkService) {
        this.sinkService = sinkService;
    }

    public void logMessage(@NonNull Message message)
    {
        message.setTimestamp(LocalDateTime.now());
        this.sinkService.sendToSink(message);
    }

}
