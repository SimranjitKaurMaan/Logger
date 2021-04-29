package com.simran.services;

import com.simran.models.Level;
import com.simran.models.SinkType;

import java.util.List;
import java.util.Map;

public class Configuration
{
    private Map<Level, List<SinkType>> configMap;

    public Configuration(Map<Level, List<SinkType>> configMap)
    {
        this.configMap = configMap;
    }

    public Map<Level, List<SinkType>> getConfigMap() {
        return configMap;
    }
}
