package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddBookingViewModel;
import Client.Views.ViewController;
import Server.Model.Date;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddBookingViewController implements ViewController {

  private ViewHandler viewHandler;
  private AddBookingViewModel viewModel;
  @FXML DatePicker startDatePicker;
  @FXML DatePicker endDatePicker;
  @FXML TextField startHour;
  @FXML TextField startMinute;
  @FXML TextField endHour;
  @FXML TextField endMinute;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    viewModel = viewModelFactory.getAddBookingViewModel();
  }

  public void onCreateBookingButton(ActionEvent evt) throws RemoteException
  {
    int startHour1 = Integer.parseInt(startHour.getText());
    int endHour1 = Integer.parseInt(endHour.getText());
    int startMinute1 = Integer.parseInt(startMinute.getText());
    int endMinute1 = Integer.parseInt(endMinute.getText());

    LocalDate date1 = startDatePicker.getValue();
    LocalDate date2 = endDatePicker.getValue();

    Date startDate1 = new Date(date1.getYear(), date1.getMonth().getValue(), date1.getDayOfMonth(), startHour1, startMinute1);
    Date endDate1 = new Date(date2.getYear(), date2.getMonth().getValue(), date2.getDayOfMonth(), endHour1, endMinute1);

  }
}