package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfBookingsViewModel
{
  private ClientModel userModel;

  public ListOfBookingsViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public ArrayList<Booking> getBookings() throws SQLException, RemoteException
  {
    return userModel.getBookings();
  }

}

