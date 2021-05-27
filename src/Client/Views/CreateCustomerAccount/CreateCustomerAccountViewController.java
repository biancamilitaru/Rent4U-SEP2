package Client.Views.CreateCustomerAccount;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class CreateCustomerAccountViewController implements ViewController
{
  private ViewHandler viewHandler;
  private CreateCustomerAccountViewModel createCustomerAccountViewModel;

  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML DatePicker dateOfBirthPicker;
  @FXML TextField eMailField;
  @FXML TextField drivingLicenseField;
  @FXML TextField cprFirstField;
  @FXML TextField cprSecondField;
  @FXML TextField passwordField;
  @FXML TextField rePasswordField;
  @FXML TextField phoneField;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
  }

  private onCreateButton(){
    createCustomerAccountViewModel.createAccount();
  }


}
