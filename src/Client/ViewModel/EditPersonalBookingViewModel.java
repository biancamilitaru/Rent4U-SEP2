package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EditPersonalBookingViewModel
{
  private ClientModel userModel;

  public EditPersonalBookingViewModel(ClientModel userModel){
    this.userModel= userModel;

  }
  public void editPersonalBooking(Booking booking , int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, double price)
      throws RemoteException, RemoteException, SQLException
  {
    Booking newBooking = new Booking(idOfCustomer, licencePlate, startTime, endTime, price);
    userModel.editBookingInfo(booking, newBooking);
  }

  public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
    return userModel.getVehicles();
  }
}
