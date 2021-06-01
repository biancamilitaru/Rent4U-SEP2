package Client.Views.EditPersonalBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Vehicle;
import Client.ViewModel.EditPersonalBookingViewModel;
import Client.Views.EditPersonalBookingView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditPersonalBookingViewController implements ViewController
{
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;
  @FXML ListView listView;
  @FXML Label totalPriceOfBooking;
  @FXML ComboBox<String> type;
  private ViewHandler viewHandler;
  private Customer customer;
  private EditPersonalBookingViewModel editPersonalBookingViewModel;
  private Booking booking;
  public final ObservableList<Vehicle> vehiclesObservableList = FXCollections.observableArrayList();
  private Vehicle vehicle;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    editPersonalBookingViewModel=viewModelFactory.getEditPersonalBookingViewModel();
    getVehicleData(editPersonalBookingViewModel.getVehicles());
    listView.setItems(vehiclesObservableList);
    listView.setCellFactory(vehiclesObservableList-> new VehicleListViewCell(this));
    listView.setFixedCellSize(125);
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

  public Vehicle getVehicle()
  {
    return vehicle;
  }

  public void setTotalPriceOfBooking(){
    totalPriceOfBooking.setText(String.valueOf(getTotalPrice()));
  }

  public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
  }

  public void loadData(){
    startDatePicker.setValue(convertToLocalDateViaInstant(booking.getStartTime().getTime()));
    endDatePicker.setValue(convertToLocalDateViaInstant(booking.getEndTime().getTime()));
    startHour.setText(String.valueOf(booking.getStartTime().get(Calendar.HOUR)));
    startMinute.setText(String.valueOf(booking.getStartTime().get(Calendar.MINUTE)));
    endHour.setText(String.valueOf(booking.getEndTime().get(Calendar.HOUR)));
    endMinute.setText(String.valueOf(booking.getEndTime().get(Calendar.MINUTE)));
    totalPriceOfBooking.setText(String.valueOf(booking.getPrice()));
  }

  public void setCustomer(Customer customer)
  {
    this.customer=customer;
  }

  public void setBooking(Booking booking)
  {
    this.booking=booking;
    loadData();
  }

  public Booking getBooking()
  {
    return booking;
  }

  public void setVehicle(Vehicle vehicle)
  {
    this.vehicle=vehicle;
  }

  public void onUpdateBooking()
      throws RemoteException, SQLException
  {

    int startHour1 = Integer.parseInt(startHour.getText());
    int endHour1 = Integer.parseInt(endHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());

    String idOfCustomer = String.valueOf(booking.getIdOfCustomer());
    String licensePlate = booking.getLicencePlate();
    if (vehicle!=null){
      licensePlate=vehicle.getLicensePlate();
    }
    double price=Double.valueOf(totalPriceOfBooking.getText());

    LocalDate date1 = startDatePicker.getValue();
    LocalDate date2 = endDatePicker.getValue();

    GregorianCalendar startDate1 = new GregorianCalendar(date1.getYear(), date1.getMonth().getValue()-1, date1.getDayOfMonth(), startHour1, startMinute1);
    GregorianCalendar endDate1 = new GregorianCalendar(date2.getYear(), date2.getMonth().getValue()-1, date2.getDayOfMonth(), endHour1, endMinute1);

    editPersonalBookingViewModel.editPersonalBooking(booking,Integer.valueOf(idOfCustomer),licensePlate,startDate1,endDate1,price);

  }
  public int daysBetween(Date d1, Date d2) {
    return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
  }

  public double getTotalPrice(){
    int daysBetween = daysBetween(getStartDate().getTime(),getEndDate().getTime());

    if (vehicle!=null){
      return vehicle.getPrice()*daysBetween;
    }
    else return 0;
  }


  public void onExitButton() throws SQLException, RemoteException
  {
    viewHandler.openMenuCustomerView(customer);
  }


}
