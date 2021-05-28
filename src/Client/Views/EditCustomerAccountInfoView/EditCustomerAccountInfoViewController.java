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

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

  private String[] splitCpr(String cprFull){
    String[] parts = cprFull.split("/");
    return parts;
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
            customer.getDateOfBirth().getTime().getDay()+ "-" +
                      customer.getDateOfBirth().getTime().getMonth()+"-"+
                      customer.getDateOfBirth().getTime().getYear()));
    eMailField.setText(customer.getEmail());
    drivingLicenseField.setText(customer.getDrivingLicenseNumber());
    cprFirstField.setText(splitCpr(String.valueOf(customer.getCpr_number()))[0]);
    cprSecondField.setText(splitCpr(String.valueOf(customer.getCpr_number()))[1]);
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

