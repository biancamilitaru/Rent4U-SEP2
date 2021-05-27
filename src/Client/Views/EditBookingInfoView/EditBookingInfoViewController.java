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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditBookingInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditBookingInfoViewModel editBookingInfoViewModel;
  private Vehicle vehicle;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML javafx.scene.control.TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;
  @FXML ListView listView;
  @FXML ComboBox<String> customerID;

  public final ObservableList<Vehicle> vehiclesObservableList = FXCollections.observableArrayList();
  private Booking booking;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    editBookingInfoViewModel=viewModelFactory.getEditBookingInfoViewModel();
    getVehicleData(editBookingInfoViewModel.getVehicles());
    listView.setItems(vehiclesObservableList);
    listView.setCellFactory(studentListView -> new VehicleListViewCell(null));
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

  public void onUpdateBookingButton(ActionEvent evt)
      throws RemoteException, SQLException
  {

    int startHour1 = Integer.parseInt(startHour.getText());
    int endHour1 = Integer.parseInt(endHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());

    //Still need to develop these functions
    int idOfCustomer=2;
    String licensePlate="Need to develop this";
    int price=100;
    ///////////////////////////////////////

    LocalDate date1 = startDatePicker.getValue();
    LocalDate date2 = endDatePicker.getValue();

    GregorianCalendar startDate1 = new GregorianCalendar(date1.getYear(), date1.getMonth().getValue(), date1.getDayOfMonth(), startHour1, startMinute1);
    GregorianCalendar endDate1 = new GregorianCalendar(date2.getYear(), date2.getMonth().getValue(), date2.getDayOfMonth(), endHour1, endMinute1);

    editBookingInfoViewModel.editBookingInfo(booking,idOfCustomer,licensePlate,startDate1,endDate1,price);

  }


  public void onExitButton(){
    viewHandler.openMainMenu();
  }
}
