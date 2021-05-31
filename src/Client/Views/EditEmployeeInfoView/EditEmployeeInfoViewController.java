package Client.Views.EditEmployeeInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Employee;
import Client.ViewModel.EditEmployeeInfoViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
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
    return cprFirstField.getText()+"/"+cprSecondField.getText();
  }

  public GregorianCalendar getDateOfBirth()
  {
    LocalDate date = dateOfBirthPicker.getValue();

    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    return dateOfBirth;
  }

  public int getSalary()
  {
    int salary = Integer.parseInt(salaryField.getText());
    return salary;
  }

  public void onSaveButton() throws RemoteException, SQLException
  {
    editEmployeeInfoViewModel.editEmployeeInfo(
        employee, getCpr(), firstNameField.getText(), lastNameField.getText(),
        getDateOfBirth(), phoneField.getText(), eMailField.getText(), getSalary(), position.getText()
    );
  }

  public void onMenu()
  {
    viewHandler.openMainMenu();
  }

}
