package Client.Views.AddCustomerAccountView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddCustomerAccountViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class AddCustomerAccountViewController implements ViewController
{
  private ViewHandler viewHandler;
  private AddCustomerAccountViewModel addCustomerAccountViewModel;

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

  private boolean manager;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.addCustomerAccountViewModel = viewModelFactory.getAddCustomerAccountViewModelViewModel();
    passwordCheckLabel.setVisible(false);
  }

  public void setManager(boolean manager)
  {
    this.manager = manager;
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
    boolean setter=true;
    int firstPart=0;
    int secondPart=0;
    try{
      firstPart=Integer.parseInt(cprFirstField.getText());
      secondPart=Integer.parseInt(cprSecondField.getText());
    }
    catch (NumberFormatException e)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setContentText(
          "Please enter a valid cpr!\nPlease try again!");
      alert.showAndWait();
      setter=false;
    }
    if(cprFirstField.getText().length()!=6 && cprSecondField.getText().length()!=4)
      setter=false;
    if(setter)
      return cprFirstField.getText()+cprSecondField.getText();
    return null;
  }

  public GregorianCalendar getDateBirth(){
    LocalDate date = dateOfBirthPicker.getValue();
    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
    return  dateOfBirth;
  }

  public void onCreateButton() throws RemoteException, SQLException {

    if (checkPassword() && getCpr()!=null){
      addCustomerAccountViewModel.createCustomerAccount(
          firstNameField.getText(),
          lastNameField.getText(),
          getDateBirth(),
          eMailField.getText(),
          passwordField.getText(),
          phoneField.getText(),
          drivingLicenseField.getText(),
          getCpr()

      );
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Customer created");
      alert.setContentText("The customer has been created!\nThank you!");
      alert.showAndWait();
      viewHandler.openListOfCustomers(manager);
    }
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Invalid input");
    alert.setContentText("Please enter a valid cpr number!");
    alert.showAndWait();


  }

  public void onMenuButton(){
    viewHandler.openMainMenu(manager);
  }

}
