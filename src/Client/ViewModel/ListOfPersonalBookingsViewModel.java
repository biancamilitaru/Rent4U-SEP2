package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfPersonalBookingsViewModel
{
  private ClientModel userModel;

  public ListOfPersonalBookingsViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public ArrayList<Booking> getPersonalBookings(Customer customer) throws SQLException,
      RemoteException
  {
    return userModel.getPersonalBookings(customer);
  }

  public void deletePersonalBooking(Booking booking) throws RemoteException,SQLException
  {
    userModel.deletePersonalBooking(booking);
  }


}
