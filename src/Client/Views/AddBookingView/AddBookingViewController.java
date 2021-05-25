package Client.Views.AddBookingView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddBookingViewModel;
import Client.Views.ViewController;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddBookingViewController implements ViewController {

  private ViewHandler viewHandler;
  private AddBookingViewModel viewModel;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    viewModel = viewModelFactory.getAddBookingViewModel();
  }

  public void onCreateBookingButton(ActionEvent evt) throws RemoteException
  {
    viewModel.createBooking();
  }
}