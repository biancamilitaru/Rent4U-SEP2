package Client.ViewModel;

import Client.Model.Booking;
import Client.Model.ClientModel;
import Server.Model.Date;

public class EditBookingInfoViewModel
{

    private ClientModel userModel;

    public EditBookingInfoViewModel(ClientModel userModel){
      this.userModel= userModel;

    }
    public void editBookingInfo(/*Booking booking ,int idOfCustomer,String licencePlate, Date startTime,Date endTime, int price*/) {
      //userModel.editBookingInfo(booking,idOfCustomer,licencePlate,startTime,endTime,price);
    }
}
