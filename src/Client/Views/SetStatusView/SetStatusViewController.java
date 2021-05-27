package Client.Views.SetStatusView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Status;
import Client.Model.Vehicle;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class SetStatusViewController implements ViewController
{

  private ViewHandler viewHandler;
  private SetStatusViewModel setStatusViewModel;

  @FXML Button setStatusButton;
  @FXML Button goToMenuButton;
  @FXML TextField statusTextField;
  private Vehicle vehicle;
  @FXML Label makeAndModelLabel;
  @FXML Label licensePlateLabel;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;



  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    setStatusViewModel = viewModelFactory.getSetStatusViewModel();
  }


  public void setVehicle(Vehicle vehicle)
  {
    this.vehicle = vehicle;
    System.out.println(vehicle.getMake() + " " + vehicle.getModel());
    makeAndModelLabel.setText(vehicle.getMake()+" + "+vehicle.getModel());
    licensePlateLabel.setText(vehicle.getLicensePlate());
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public void setSetStatusButton(ActionEvent evt)
      throws RemoteException, SQLException
  {
    int startHour1 = Integer.parseInt(startHour.getText());
    int endHour1 = Integer.parseInt(endHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());

    LocalDate date1 = startDatePicker.getValue();
    LocalDate date2 = endDatePicker.getValue();

    GregorianCalendar startDate1 = new GregorianCalendar(date1.getYear(), date1.getMonth().getValue(), date1.getDayOfMonth(), startHour1, startMinute1);
    GregorianCalendar endDate1 = new GregorianCalendar(date2.getYear(), date2.getMonth().getValue(), date2.getDayOfMonth(), endHour1, endMinute1);

    Status status = new Status(startDate1, endDate1, statusTextField.getText());
    setStatusViewModel.setStatus(vehicle, status);
    viewHandler.openListOfVehicleView();
  }


}
