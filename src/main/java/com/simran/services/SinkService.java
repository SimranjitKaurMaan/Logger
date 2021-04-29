package com.simran.services;

import com.simran.ConsoleSink;
import com.simran.TextSink;
import com.simran.abstractions.ISink;
import com.simran.models.Level;
import com.simran.models.Message;
import com.simran.models.SinkType;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinkService
{
    private Map<SinkType, ISink> sinkMap;
    private Configuration configuration;

    public SinkService(Configuration configuration)
    {
        this.sinkMap = new HashMap<>();
        this.sinkMap.put(SinkType.text,new TextSink());
        this.sinkMap.put(SinkType.console,new ConsoleSink());
        this.configuration = configuration;
    }

    public void sendToSink(@NonNull Message message)
    {
        Level messageLevel = message.getLevel();
        List<Level> messageLevelsAndAbove = new ArrayList<>();
        switch (messageLevel)
        {
            case debug:messageLevelsAndAbove.add(Level.debug);
            case info:messageLevelsAndAbove.add(Level.info);
            case warn:messageLevelsAndAbove.add(Level.warn);
            case error:messageLevelsAndAbove.add(Level.error);
            case fatal:messageLevelsAndAbove.add(Level.fatal);
        }

        messageLevelsAndAbove.stream().forEach(level -> {
            List<SinkType> sinkTypes = configuration.getConfigMap().get(level);
            sinkTypes.stream().forEach(sinkType -> {
                ISink sink = sinkMap.get(sinkType);
                sink.dump(message);
            });
        });
    }
}
