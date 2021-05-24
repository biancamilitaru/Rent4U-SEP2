package Client.Views.CreateBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.CreateBookingViewModel;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class CreateBookingViewController implements ViewController
{
  private ViewHandler viewHandler;
  private CreateBookingViewModel createBookingViewModel;

  @FXML Button confirmButton;
  @FXML Button goToMenuButton;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    createBookingViewModel = viewModelFactory.getCreateBookingViewModel();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public void setConfirmButton(ActionEvent evt)
  {
    Platform.runLater(() ->{
      try{
        createBookingViewModel.createBooking();

      }
      catch (SQLException | RemoteException e)
      {
        e.printStackTrace();
      }
    });
    viewHandler.openMainMenu();
  }

}
