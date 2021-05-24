package Server.Model;

public class Status
{
  private String status;
  private Date startDate;
  private Date endDate;

  public Status(Date startDate,Date endDate, String status)
  {
    this.startDate=startDate;
    this.endDate=endDate;
    this.status=status;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
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
