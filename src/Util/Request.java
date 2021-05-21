package Util;

import java.io.Serializable;

public class Request implements Serializable
{
    private String text;
    private Object object;

    public Request(String text)
    {
        this.text = text;
        object = null;
    }
    public Request(String text, Object object)
    {
        this.text = text;
        this.object = object;
    }
}
