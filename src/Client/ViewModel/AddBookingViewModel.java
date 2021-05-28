package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Customer;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AddBookingViewModel
{
  private ClientModel userModel;


  public AddBookingViewModel(ClientModel userModel){
    this.userModel= userModel;

  }
  public void createBooking(int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, double price) throws RemoteException, SQLException {

    userModel.createBooking(new Booking(idOfCustomer,licencePlate,startTime,endTime,price));
  }

  public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
    return userModel.getVehicles();
  }

  public ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws SQLException, RemoteException
  {
    return userModel.getFreeVehicles(startDate, endDate, type);
  }

  public ArrayList<Integer> getAllCustomersID() throws RemoteException, SQLException {
    ArrayList<Integer> IDs = new ArrayList<>();
    ArrayList<Customer> customers = userModel.getCustomers();
    for (int i = 0; i < customers.size(); i++)
    {
      IDs.add(Integer.parseInt(customers.get(i).getCpr_number()));
    }
    return IDs;
  }
}
