package Client.Views.AddEmployeesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.AddEmployeeViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
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

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    addEmployeeViewModel=viewModelFactory.getAddEmployeeViewModel();
    addedLabel.setVisible(false);
  }

  private String getCpr(){
    return cprFirstField.getText()+cprSecondField.getText();
  }

  public GregorianCalendar getDateBirth(){
    LocalDate date = dateOfBirthPicker.getValue();

    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    return dateOfBirth;
  }

  public void onCreateButton() throws RemoteException, SQLException{

    boolean success=false;
    try{
      addEmployeeViewModel.createEmployee(
          getCpr(),
          firstNameField.getText(),
          lastNameField.getText(),
          getDateBirth(),
          phoneField.getText(),
          eMailField.getText(),
          Integer.parseInt(salary.getText()),
          position.getText()

      );
    success=true;}
    catch(NumberFormatException e){
      e.printStackTrace();
    }
    if(success)
      addedLabel.setVisible(true);
    viewHandler.openListOfEmployees();
  }

  public void onMenuButton(){
    viewHandler.openMainMenu();
  }

}
