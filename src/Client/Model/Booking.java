package Client.Model;


import java.util.GregorianCalendar;

import java.util.GregorianCalendar;

public class Booking
{
  private int booking_id;
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

  public Booking(int booking_id, int idOfCustomer,String licencePlate,GregorianCalendar startTime,GregorianCalendar endTime,double price){
    this.booking_id = booking_id;
    this.idOfCustomer = idOfCustomer;
    this.licencePlate = licencePlate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }

  public void setBooking_id(int booking_id) {
    this.booking_id = booking_id;
  }

  public int getBooking_id() {
    return booking_id;
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

  @Override
  public String toString() {
    return "Booking{" +
            "booking_id=" + booking_id +
            ", idOfCustomer=" + idOfCustomer +
            ", licencePlate='" + licencePlate + '\'' +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", price=" + price +
            '}';
  }
}
