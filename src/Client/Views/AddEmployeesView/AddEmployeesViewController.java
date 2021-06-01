package Client.Views.AddEmployeesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddEmployeeViewModel;
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

public class AddEmployeesViewController implements ViewController
{
  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML DatePicker dateOfBirthPicker;
  @FXML TextField eMailField;
  @FXML TextField position;
  @FXML TextField cprFirstField;
  @FXML TextField cprSecondField;
  @FXML TextField salary;
  @FXML TextField phoneField;
  @FXML Label addedLabel;

  private ViewHandler viewHandler;
  private AddEmployeeViewModel addEmployeeViewModel;

  private boolean manager;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    addEmployeeViewModel=viewModelFactory.getAddEmployeeViewModel();
    addedLabel.setVisible(false);
  }

  public void setManager(boolean manager)
  {
    this.manager = manager;
  }

  private String getCpr(){
    return cprFirstField.getText()+cprSecondField.getText();
  }

  public GregorianCalendar getDateBirth(){
    GregorianCalendar now=new GregorianCalendar();
    LocalDate date = dateOfBirthPicker.getValue();
    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
    if(dateOfBirth.before(now))
      return null;
    return  dateOfBirth;
  }

  public void onCreateButton() throws RemoteException, SQLException, NumberFormatException{
    if(dateOfBirthPicker!=null)
    {
      addEmployeeViewModel.createEmployee(getCpr(), firstNameField.getText(),
          lastNameField.getText(), getDateBirth(), phoneField.getText(),
          eMailField.getText(), Integer.parseInt(salary.getText()),
          position.getText()

      );
      viewHandler.openListOfEmployees(manager);
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Employee created");
      alert.setContentText("The employee has been created!\nThank you!");
      alert.showAndWait();
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setContentText(
          "Please enter a valid time of birth\nPlease try again!");
      alert.showAndWait();
    }
  }

  public void onMenuButton(){
    viewHandler.openMainMenu(manager);
  }

}
