package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class EditPersonalInfoViewModel
{
  private ClientModel userModel;


  public EditPersonalInfoViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }
  public void editPersonalInfo(Customer customer, String firstName,String lastName,
      GregorianCalendar dateOfBirth,String email,String password,String phoneNumber,String drivingLicenseNumber,String cpr_number)
      throws RemoteException, RemoteException, SQLException
  {
    Customer newCustomer = new Customer(firstName, lastName, dateOfBirth, email , password ,phoneNumber , drivingLicenseNumber , cpr_number);
    userModel.editPersonalInfo(customer, newCustomer);
  }

  public void deleteCustomerAccount(Customer customer) throws RemoteException, SQLException {
    userModel.deleteCustomer(customer);
  }
}
