package Client.Views.EditEmployeeInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Employee;
import Client.ViewModel.EditEmployeeInfoViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EditEmployeeInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditEmployeeInfoViewModel editEmployeeInfoViewModel;

  private Employee employee;

  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML DatePicker dateOfBirthPicker;
  @FXML TextField eMailField;
  @FXML TextField cprFirstField;
  @FXML TextField cprSecondField;
  @FXML TextField phoneField;
  @FXML TextField position;
  @FXML TextField salaryField;

  private boolean manager;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    this.editEmployeeInfoViewModel = viewModelFactory.getEditEmployeeViewModel();
  }

  public void setEmployee(Employee employee)
  {
    this.employee = employee;
    loadData();
  }

  public void setManager(boolean manager)
  {
    this.manager = manager;
  }

  public static final LocalDate dateConvertor(String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
  }

  public void loadData()
  {
    firstNameField.setText(employee.getFirstName());
    lastNameField.setText(employee.getLastName());
    dateOfBirthPicker.setValue(
        dateConvertor(
            employee.getDateOfBirth().get(Calendar.DATE)+ "-" +
                employee.getDateOfBirth().get(Calendar.MONTH)+"-"+
                employee.getDateOfBirth().get(Calendar.YEAR)));
    eMailField.setText(employee.getEmail());
    cprFirstField.setText(employee.getCpr().substring(0,6));
    cprSecondField.setText(employee.getCpr().substring(7,11));
    phoneField.setText(employee.getPhoneNumber());
    position.setText(employee.getPosition());
    String str = Double.toString(employee.getSalary());
    salaryField.setText(str);
  }

  private String getCpr()
  {
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

  public GregorianCalendar getDateOfBirth()
  {
    GregorianCalendar now=new GregorianCalendar();
    LocalDate date = dateOfBirthPicker.getValue();
    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
    if(dateOfBirth.before(now))
      return null;
    return  dateOfBirth;
  }

  public int getSalary()
  {
    int salary = Integer.parseInt(salaryField.getText());
    return salary;
  }

  public void onSaveButton() throws RemoteException, SQLException
  {
    if (getDateOfBirth() != null && getCpr() != null)
    {
      editEmployeeInfoViewModel
          .editEmployeeInfo(employee, getCpr(), firstNameField.getText(),
              lastNameField.getText(), getDateOfBirth(), phoneField.getText(),
              eMailField.getText(), getSalary(), position.getText());
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Employee information edited");
      alert.setContentText(
          "The employee information has been successfully edited!\nThank you!");
      alert.showAndWait();
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setContentText(
          "Please enter a valid information to the fields!\nPlease try again!");
      alert.showAndWait();
    }
  }

  public void onMenu()
  {
    viewHandler.openMainMenu(manager);
  }

}
