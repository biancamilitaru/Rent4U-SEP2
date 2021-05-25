package Client.Model;


import java.util.GregorianCalendar;

import java.util.GregorianCalendar;

public class Booking
{
  private int idOfCustomer;
  private String licencePlate;
  private GregorianCalendar startTime;
  private GregorianCalendar endTime;
  private double price;

  public Booking(int idOfCustomer,String licencePlate,GregorianCalendar startTime,GregorianCalendar endTime,double price){
    this.idOfCustomer = idOfCustomer;
    this.licencePlate = licencePlate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public double getPrice()
  {
    return price;
  }

  public void setEndTime(GregorianCalendar endTime)
  {
    this.endTime = endTime;
  }

  public GregorianCalendar getEndTime()
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

  public void setStartTime(GregorianCalendar startTime)
  {
    this.startTime = startTime;
  }

  public GregorianCalendar getStartTime()
  {
    return startTime;
  }
}
