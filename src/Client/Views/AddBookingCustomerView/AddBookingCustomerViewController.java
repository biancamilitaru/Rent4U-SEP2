package Client.Views.AddBookingCustomerView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.Model.Vehicle;
import Client.ViewModel.AddBookingViewModel;
import Client.Views.AddBookingCustomerView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddBookingCustomerViewController implements ViewController {


  private ViewHandler viewHandler;
  private AddBookingViewModel viewModel;
  @FXML ListView<Vehicle> listView;
  @FXML DatePicker startDatePicker;
  private Customer customer;
  @FXML DatePicker endDatePicker;
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

  public void setCustomer(Customer customer)
  {
    this.customer=customer;
  }

  private String[] splitCpr(String cprFull){
    String[] parts = cprFull.split("/");
    return parts;
  }

  public void onCreateBookingButton() throws RemoteException, SQLException {
    int id = Integer.parseInt(customer.getCpr_number());
    String licensePlate=chosenVehicle.getLicensePlate();
    GregorianCalendar now=new GregorianCalendar();

    if(licensePlate.length()>7)
     JOptionPane.showMessageDialog(null, "The license plate number is not correct!\nPlease enter again!",
         "Error", JOptionPane.ERROR_MESSAGE);
    if(getStartDate().before(now) || getEndDate().before(getStartDate())|| getEndDate().before(now))
      JOptionPane.showMessageDialog(null, "Please enter a valid end time\nTry again!","Error", JOptionPane.ERROR_MESSAGE);
    else
    {
      viewModel.createBooking(id,chosenVehicle.getLicensePlate(), getStartDate(), getEndDate(),getTotalPrice());
      viewHandler.openMenuCustomerView(customer);
      JOptionPane.showMessageDialog(null, "The booking has been created", "Rent4U", JOptionPane.INFORMATION_MESSAGE);
    }

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
        !endMinute.getText().equals(null)
        ){
      listView.setVisible(true);
    } else listView.setVisible(false);
  }

  public void onMainMenuButton(javafx.event.ActionEvent actionEvent) throws SQLException, RemoteException {
    viewHandler.openMenuCustomerView(customer);
  }
}
