package com.simran.abstractions;

import com.simran.models.Message;

public interface ISink
{
    void dump(Message message);
}
