package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.AddBookingViewModel;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddBookingViewController implements ViewController
{
  private ViewHandler viewHandler;
  private AddBookingViewModel createBookingViewModel;

  @FXML Button confirmButton;
  @FXML Button goToMenuButton;


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
    Platform.runLater(() ->{
      createBookingViewModel.createBooking();

    });
    viewHandler.openMainMenu();
  }

}
