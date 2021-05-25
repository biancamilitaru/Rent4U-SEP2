package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;
import Server.Model.Date;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddBookingViewController implements ViewController
{
  private ViewHandler viewHandler;
  private AddBookingViewModel createBookingViewModel;

  @FXML Button confirmButton;
  @FXML Button goToMenuButton;
  @FXML DatePicker datePicker;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    createBookingViewModel = viewModelFactory.getAddBookingViewModel();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public void setConfirmButton(ActionEvent evt)
  {
    LocalDate date = datePicker.getValue();
    Platform.runLater(() ->{
      createBookingViewModel.createBooking();

    });
    viewHandler.openMainMenu();
  }

}
