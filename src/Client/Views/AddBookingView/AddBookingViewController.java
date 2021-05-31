package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Vehicle;
import Client.ViewModel.AddBookingViewModel;
import Client.Views.AddBookingView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddBookingViewController implements ViewController {


  private ViewHandler viewHandler;
  private AddBookingViewModel viewModel;
  @FXML ListView<Vehicle> listView;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML ComboBox<Integer> customersID;
  @FXML TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;
  @FXML ComboBox<String> type;
  @FXML Label totalPriceOfBooking;

  public final ObservableList<Vehicle> vehiclesObservableList = FXCollections.observableArrayList();
  private Vehicle chosenVehicle;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
      throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    viewModel = viewModelFactory.getAddBookingViewModel();
    getVehicleData(viewModel.getVehicles());
    listView.setItems(vehiclesObservableList);
    listView.setCellFactory(vehicleListView -> new VehicleListViewCell(this));
    listView.setFixedCellSize(125);
    listView.setVisible(false);
    customersID.getItems().addAll(viewModel.getAllCustomersID());
    System.out.println(customersID.getItems());
    type.getItems().addAll("Car", "Minibus", "Bus", "Motorcycle");
  }

  public ObservableList<Vehicle> getVehicleData(
      ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      vehiclesObservableList.add(vehiclesArrayList.get(x));
    }
    return vehiclesObservableList;
  }

  public GregorianCalendar getStartDate(){
    int startHour1 = Integer.parseInt(startHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    LocalDate date1 = startDatePicker.getValue();

    GregorianCalendar startDate = new GregorianCalendar(date1.getYear(), date1.getMonth().getValue()-1, date1.getDayOfMonth(), startHour1, startMinute1);

    return startDate;
  }

  public GregorianCalendar getEndDate(){
    int endHour1 = Integer.parseInt(endHour.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());
    LocalDate date2 = endDatePicker.getValue();

    GregorianCalendar endDate = new GregorianCalendar(date2.getYear(), date2.getMonth().getValue()-1, date2.getDayOfMonth(), endHour1, endMinute1);

    return endDate;
  }

  public void onCreateBookingButton() throws RemoteException, SQLException {
    viewModel.createBooking(customersID.getSelectionModel().getSelectedItem(),chosenVehicle.getLicensePlate(), getStartDate(), getEndDate(),getTotalPrice());
    viewHandler.openListOfBookingsView();
  }

  public int daysBetween(Date d1, Date d2) {
    return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
  }

  public double getTotalPrice(){
    int daysBetween = daysBetween(getStartDate().getTime(),getEndDate().getTime());

    if (chosenVehicle!=null){
      return chosenVehicle.getPrice()*daysBetween;
    }
    else return 0;
  }

  public void setTotalPriceOfBooking(){
    totalPriceOfBooking.setText(String.valueOf(getTotalPrice()));
  }

  public void setVehicle(Vehicle vehicle){
    this.chosenVehicle=vehicle;
  }

  public void onChoseType(){
    if (!startDatePicker.getValue().equals(null) &&
        !endDatePicker.getValue().equals(null) &&
        !startHour.getText().equals(null) &&
        !startMinute.getText().equals(null) &&
        !endHour.getText().equals(null) &&
        !endMinute.getText().equals(null) &&
        !customersID.getSelectionModel().isEmpty()
        ){
      listView.setVisible(true);
    } else listView.setVisible(false);
  }

  public void onMainMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }
}
