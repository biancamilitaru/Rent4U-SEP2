package Client.Model;



public class Booking
{
  private int idOfCustomer;
  private String licencePlate;
  private Date startTime;
  private Date endTime;
  private int price;

  public Booking(int idOfCustomer,String licencePlate,Date startTime,Date endTime,int price){
    this.idOfCustomer = idOfCustomer;
    this.licencePlate = licencePlate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public int getPrice()
  {
    return price;
  }

  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }

  public Date getEndTime()
  {
    return endTime;
  }

  public void setIdOfCustomer(int idOfCustomer)
  {
    this.idOfCustomer = idOfCustomer;
  }

  public int getIdOfCustomer()
  {
    return idOfCustomer;
  }

  public void setLicencePlate(String licencePlate)
  {
    this.licencePlate = licencePlate;
  }

  public String getLicencePlate()
  {
    return licencePlate;
  }

  public void setStartTime(Date startTime)
  {
    this.startTime = startTime;
  }

  public Date getStartTime()
  {
    return startTime;
  }
}
