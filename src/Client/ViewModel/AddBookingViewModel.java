package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Server.Model.Date;

import java.rmi.RemoteException;

public class AddBookingViewModel
{
  private ClientModel userModel;


  public AddBookingViewModel(ClientModel userModel){
    this.userModel= userModel;

  }
  public void createBooking() throws RemoteException
  {

    //userModel.createBooking(new Booking(idOfCustomer,licencePlate,startTime,endTime,price));
  }
}
