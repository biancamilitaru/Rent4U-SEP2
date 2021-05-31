package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Customer;
import Client.Model.Vehicle;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class EditBookingInfoViewModel
{

    private ClientModel userModel;

    public EditBookingInfoViewModel(ClientModel userModel){
      this.userModel= userModel;

    }
    public void editBookingInfo(Booking booking , int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, double price)
            throws RemoteException, RemoteException, SQLException {
        Booking newBooking = new Booking(idOfCustomer, licencePlate, startTime, endTime, price);
        userModel.editBookingInfo(booking, newBooking);
    }

    public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
        return userModel.getVehicles();
    }

    public ArrayList<Customer> getCustomers() throws SQLException, RemoteException {
        return userModel.getCustomers();
    }
}
