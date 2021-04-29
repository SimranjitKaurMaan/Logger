package com.simran.models;

import java.time.LocalDateTime;

public class Message
{
    private String content;
    private Level level;
    private String namespace;
    private LocalDateTime timestamp;

    public Message(String content, Level level, String namespace) {
        this.content = content;
        this.level = level;
        this.namespace = namespace;
    }

    public Level getLevel() {
        return level;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", level=" + level +
                ", namespace='" + namespace + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
