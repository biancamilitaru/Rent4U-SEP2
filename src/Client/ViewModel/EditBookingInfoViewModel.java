package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Client.Model.Vehicle;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EditBookingInfoViewModel
{

    private ClientModel userModel;

    public EditBookingInfoViewModel(ClientModel userModel){
      this.userModel= userModel;

    }
    public void editBookingInfo(Booking booking ,int idOfCustomer,String licencePlate, GregorianCalendar startTime,GregorianCalendar endTime, int price)
        throws RemoteException
    {
        userModel.editBookingInfo(booking,idOfCustomer,licencePlate,startTime,endTime,price);
    }

    public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
        return userModel.getVehicles();
    }
}
