package Client.Views.EditBookingInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Vehicle;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.EditBookingInfoViewModel;
import Client.ViewModel.EditVehicleInfoViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class EditBookingInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditBookingInfoViewModel editBookingInfoViewModel;
  private Booking booking;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML javafx.scene.control.TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    editBookingInfoViewModel=viewModelFactory.getEditBookingInfoViewModel();
  }

  public void onUpdateBookingButton(ActionEvent evt) throws RemoteException
  {

  }
  public void setBooking(Booking booking)
  {
    this.booking = booking;
  }
}
