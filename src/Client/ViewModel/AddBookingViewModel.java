package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

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

  public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
    return userModel.getVehicles();
  }
}
