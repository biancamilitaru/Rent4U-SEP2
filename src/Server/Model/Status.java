package Server.Model;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

public class Status implements Serializable
{
    private String status;
    public String getStatus()
  {
    return status;
  }
    public void setStatus(String status)
  {
    this.status = status;
  }
}
