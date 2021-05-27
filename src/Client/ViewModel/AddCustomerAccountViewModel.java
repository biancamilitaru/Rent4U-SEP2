package Client.ViewModel;

import Client.Model.ClientModel;

import java.util.GregorianCalendar;

public class AddCustomerAccountViewModel
{
  private ClientModel userModel;

  public AddCustomerAccountViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public void createCustomerAccount(String firstName,String lastName,
      GregorianCalendar dateOfBirth,String email,String password,String phoneNumber,String drivingLicenseNumber,String cpr_number)
  {
    userModel.createCustomerAccount(firstName,lastName,dateOfBirth,email,password,phoneNumber,drivingLicenseNumber,cpr_number);
  }
}
