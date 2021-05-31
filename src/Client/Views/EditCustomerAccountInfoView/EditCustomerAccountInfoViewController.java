package Client.Views.EditCustomerAccountInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.ViewModel.EditCustomerInfoViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EditCustomerAccountInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditCustomerInfoViewModel editCustomerInfoViewModel;

  private Customer customer;

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
    this.editCustomerInfoViewModel=viewModelFactory.getEditCustomerInfoViewModelViewModel();

  }

  public void setCustomer(Customer customer)
  {
    this.customer=customer;
    loadData();
  }

  public static final LocalDate dateConvertor (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
  }


  public void loadData(){
    firstNameField.setText(customer.getFirstName());
    lastNameField.setText(customer.getLastName());
    dateOfBirthPicker.setValue(
        dateConvertor(
            customer.getDateOfBirth().get(Calendar.DATE)+ "-" +
                      customer.getDateOfBirth().get(Calendar.MONTH)+"-"+
                      customer.getDateOfBirth().get(Calendar.YEAR)));
    eMailField.setText(customer.getEmail());
    drivingLicenseField.setText(customer.getDrivingLicenseNumber());
    cprFirstField.setText(customer.getCpr_number().substring(0,6));
    cprSecondField.setText(customer.getCpr_number().substring(7,11));
    passwordField.setText(customer.getPassword());
    rePasswordField.setText(customer.getPassword());
    phoneField.setText(customer.getPhoneNumber());
    passwordCheckLabel.setVisible(false);
  }

  private String getCpr(){
    return cprFirstField.getText()+"/"+cprSecondField.getText();
  }

  public GregorianCalendar getDateBirth(){
    LocalDate date = dateOfBirthPicker.getValue();

    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    return dateOfBirth;
  }

  public void onUpdateCustomer() throws RemoteException, SQLException
  {
    editCustomerInfoViewModel.editCustomerInfo(
        customer,
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

  public void onMenu(){
    viewHandler.openMainMenu();
  }
}

