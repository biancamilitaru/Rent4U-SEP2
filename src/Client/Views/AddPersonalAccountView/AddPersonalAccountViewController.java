package Client.Views.AddPersonalAccountView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddPersonalAccountViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class AddPersonalAccountViewController implements ViewController
{
  private ViewHandler viewHandler;
  private AddPersonalAccountViewModel addPersonalAccountViewModel;

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
  @FXML Label passwordCheckLabel;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.addPersonalAccountViewModel = viewModelFactory.getAddPersonalAccountViewModelViewModel();
    passwordCheckLabel.setVisible(false);
  }

  private boolean checkPassword(){
    if (passwordField.getText().equals(rePasswordField.getText())){
      passwordCheckLabel.setVisible(false);
      return true;
    } else {
      passwordCheckLabel.setVisible(true);
      return false;
    }
  }

  private String getCpr(){
    return cprFirstField.getText()+cprSecondField.getText();
  }

  public GregorianCalendar getDateBirth(){
    LocalDate date = dateOfBirthPicker.getValue();

    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    return dateOfBirth;
  }

  public void onCreateButton() throws RemoteException, SQLException {
    if (checkPassword()){
      addPersonalAccountViewModel.createPersonalAccount(
          firstNameField.getText(),
          lastNameField.getText(),
          getDateBirth(),
          eMailField.getText(),
          passwordField.getText(),
          phoneField.getText(),
          drivingLicenseField.getText(),
          getCpr()
      );
    }
  }

  public void onMenuButton() throws SQLException, RemoteException {
    viewHandler.openLogInCustomer();
  }

}
