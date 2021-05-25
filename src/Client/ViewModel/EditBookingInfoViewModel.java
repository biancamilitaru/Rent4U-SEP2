package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

public class EditBookingInfoViewModel
{

    private ClientModel userModel;

    public EditBookingInfoViewModel(ClientModel userModel){
      this.userModel= userModel;

    }
    public void editBookingInfo(/*Booking booking ,int idOfCustomer,String licencePlate,
        GregorianCalendar startTime,GregorianCalendar endTime, int price*/)
        throws RemoteException
    {
      //userModel.editBookingInfo(booking,idOfCustomer,licencePlate,startTime,endTime,price);
    }
}
