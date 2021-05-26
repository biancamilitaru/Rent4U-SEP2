package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Vehicle;
import Client.ViewModel.AddBookingViewModel;
import Client.Views.AddBookingView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.awt.print.Book;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddBookingViewController implements ViewController {

  private ViewHandler viewHandler;
  private AddBookingViewModel viewModel;
  @FXML ComboBox<Integer> customersID;
  @FXML ComboBox desiredType;
  @FXML Button createBookingButton;
  @FXML Button backToMenuButton;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;
  @FXML ListView<Vehicle> listView;
  private Vehicle vehicle;
  private int priceOfBooking;

  public final ObservableList<Vehicle> vehiclesObservableList = FXCollections.observableArrayList();

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
      throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    viewModel = viewModelFactory.getAddBookingViewModel();
    getVehicleData(viewModel.getVehicles());
    listView.setItems(vehiclesObservableList);
    listView.setCellFactory(vehicleListView -> new VehicleListViewCell());

    listView.setFixedCellSize(125);
  }

  public ObservableList<Vehicle> getVehicleData(
      ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      vehiclesObservableList.add(vehiclesArrayList.get(x));
    }
    return vehiclesObservableList;
  }

  public void onCreateBookingButton(ActionEvent evt) throws RemoteException
  {
    int startHour1 = Integer.parseInt(startHour.getText());
    int endHour1 = Integer.parseInt(endHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());

    LocalDate date1 = startDatePicker.getValue();
    LocalDate date2 = endDatePicker.getValue();

    GregorianCalendar startDate1 = new GregorianCalendar(date1.getYear(), date1.getMonth().getValue(), date1.getDayOfMonth(), startHour1, startMinute1);
    GregorianCalendar endDate1 = new GregorianCalendar(date2.getYear(), date2.getMonth().getValue(), date2.getDayOfMonth(), endHour1, endMinute1);



    viewModel.createBooking(customersID.getSelectionModel().getSelectedItem(),vehicle.getLicensePlate(), startDate1, endDate1,100.2 );
  }
}
