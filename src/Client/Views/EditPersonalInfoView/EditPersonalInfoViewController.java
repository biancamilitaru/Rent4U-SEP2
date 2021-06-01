package Client.Views.EditPersonalInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.ViewModel.EditPersonalInfoViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

public class EditPersonalInfoViewController implements ViewController
{
  private ViewHandler viewHandler;
  private EditPersonalInfoViewModel editPersonalInfoViewModel;

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
    this.editPersonalInfoViewModel=viewModelFactory.getEditPersonalInfoViewModelViewModel();

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
    boolean setter=true;
    int firstPart=0;
    int secondPart=0;
    try{
      firstPart=Integer.parseInt(cprFirstField.getText());
      secondPart=Integer.parseInt(cprSecondField.getText());
    }
    catch (NumberFormatException e)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Invalid Input");
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
    GregorianCalendar now=new GregorianCalendar();
    LocalDate date = dateOfBirthPicker.getValue();
    GregorianCalendar dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
    if(dateOfBirth.before(now))
      return null;
    return  dateOfBirth;
  }
  public String getPhoneNumber()
  {
    String phoneNumberString=phoneField.getText();
    if(phoneNumberString.length()>12 ||phoneNumberString.length()<6)
      return null;

    int phoneNumber=0;
    try {
      phoneNumber=Integer.parseInt(phoneField.getText());
    }
    catch (NumberFormatException e){
      return null;
    }
    return phoneNumberString;
  }

  public void onUpdatePersonalAccount() throws RemoteException, SQLException
  {
    if(getCpr()!=null && getDateBirth()!=null && getPhoneNumber()!=null)
    {
      editPersonalInfoViewModel.editPersonalInfo(
        customer,
        firstNameField.getText(),
        lastNameField.getText(),
        getDateBirth(),
        eMailField.getText(),
        passwordField.getText(),
        getPhoneNumber(),
        drivingLicenseField.getText(),
        getCpr());

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Your information was edited");
      alert.setContentText(
          "Your personal information has been successfully edited!\nThank you!");
      alert.showAndWait();
    }
    if(getCpr()==null){
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Invalid input");
      alert.setContentText("Please enter a valid cpr number!");
      alert.showAndWait();}

    if(getDateBirth()==null){
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Invalid input");
      alert.setContentText("Please enter a valid birthday!");
      alert.showAndWait();
    }
    if(getPhoneNumber()==null)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Invalid input");
      alert.setContentText("Please enter a phone number!");
      alert.showAndWait();
    }
  }

    public void onMenu(ActionEvent actionEvent) throws SQLException, RemoteException {
      viewHandler.openMenuCustomerView(customer);
    }
}

