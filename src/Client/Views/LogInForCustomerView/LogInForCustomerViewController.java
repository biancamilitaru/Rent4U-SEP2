package Client.Views.LogInForCustomerView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.LogInCustomerViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LogInForCustomerViewController implements ViewController
{
  @FXML TextField emailField;
  @FXML TextField passwordField;

  private ViewHandler viewHandler;
  private LogInCustomerViewModel logInCustomerViewModel;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.logInCustomerViewModel = viewModelFactory.getLogInCustomerViewModel();
  }

  public void logIn() throws RemoteException, SQLException
  {
    if (logInCustomerViewModel.checkForPassword(emailField.getText(),passwordField.getText()))
      //viewHandler.; openToCustomerMenu
    emailField.clear();
    passwordField.clear();
  }

  public void onBackButton() throws SQLException, RemoteException
  {
    viewHandler.openLogInMenu();
  }

  public void signUp() throws SQLException, RemoteException
  {
    viewHandler.openAddPersonalAccount();
  }
}
