package com.simran;

import com.simran.abstractions.ISink;
import com.simran.models.Message;

import java.io.*;

public class TextSink implements ISink
{
    public void dump(Message message)
    {
        try
        {
            String filename= "textlog.txt";
            FileWriter fileWriter = new FileWriter(filename,true);
            fileWriter.write(message.toString()+"\n");
            fileWriter.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}
