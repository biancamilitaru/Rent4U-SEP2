package Client.Views.EditBookingInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Vehicle;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.EditBookingInfoViewModel;
import Client.Views.AddBookingView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditBookingInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditBookingInfoViewModel editBookingInfoViewModel;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML javafx.scene.control.TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;
  @FXML ListView listView;

  public final ObservableList<Vehicle> vehiclesObservableList = FXCollections.observableArrayList();
  private Booking booking;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    editBookingInfoViewModel=viewModelFactory.getEditBookingInfoViewModel();
    getVehicleData(editBookingInfoViewModel.getVehicles());
    listView.setItems(vehiclesObservableList);
    listView.setCellFactory(studentListView -> new VehicleListViewCell());
  }

  public ObservableList<Vehicle> getVehicleData(
      ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      vehiclesObservableList.add(vehiclesArrayList.get(x));
    }
    return vehiclesObservableList;
  }

  public void setBooking(Booking booking)
  {
    this.booking=booking;
  }

  public void onUpdateBookingButton(ActionEvent evt) throws RemoteException
  {

  }


  public void onExitButton(){
    viewHandler.openMainMenu();
  }
}
