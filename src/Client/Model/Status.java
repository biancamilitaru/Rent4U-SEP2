package Client.Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Status
{
  private String status;
  private GregorianCalendar startDate;
  private GregorianCalendar endDate;

  public Status(GregorianCalendar startDate,GregorianCalendar endDate, String status)
  {
    this.startDate=startDate;
    this.endDate=endDate;
    this.status=status;
  }

  public void setStartDate(GregorianCalendar startDate)
  {
    this.startDate = startDate;
  }

  public void setEndDate(GregorianCalendar endDate)
  {
    this.endDate = endDate;
  }

  public GregorianCalendar getStartDate()
  {
    return startDate;
  }

  public GregorianCalendar getEndDate()
  {
    return endDate;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }
}
