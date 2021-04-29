package com.simran;

import com.simran.abstractions.ISink;
import com.simran.models.Message;

public class ConsoleSink implements ISink
{
    public void dump(Message message)
    {
        System.out.println("Writing to the console "+message);
    }
}
