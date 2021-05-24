package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Server.Model.Date;

public class CreateBookingViewModel
{
  private ClientModel userModel;

  public CreateBookingViewModel(ClientModel userModel){
    this.userModel= userModel;

  }
  public void createBooking(int idOfCustomer,String licencePlate, Date startTime,Date endTime,int price){
    userModel.createBooking(new Booking(idOfCustomer,licencePlate,startTime,endTime,price));
  }
}
