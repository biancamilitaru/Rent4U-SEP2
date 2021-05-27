package Client.ViewModel;

import Client.Model.ClientModel;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class EditCustomerViewModel
{
  private ClientModel userModel;

  public EditCustomerViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public void editCustomerInfo(String firstName,String lastName,
      GregorianCalendar dateOfBirth,String email,String password,String phoneNumber,String drivingLicenseNumber,String cpr_number)
      throws RemoteException, SQLException
  {
    userModel.editCustomerInfo(firstName,lastName,dateOfBirth,email,password,phoneNumber,drivingLicenseNumber,cpr_number);
  }
}
