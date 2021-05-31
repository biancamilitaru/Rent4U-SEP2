package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Employee;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class AddEmployeeViewModel
{
  private ClientModel userModel;

  public AddEmployeeViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }
  public void createEmployee(String cpr, String firstName, String lastName, GregorianCalendar dateOfBirth,String phoneNumber,
      String email, int salary,String position)
      throws RemoteException, SQLException
  {
    userModel.createEmployee(new Employee(cpr,firstName,lastName,dateOfBirth,phoneNumber,email,salary,position));
  }
}
