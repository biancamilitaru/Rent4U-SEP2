package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Employee;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class EditEmployeeInfoViewModel
{
  private ClientModel userModel;

  public EditEmployeeInfoViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }
  public void editEmployeeInfo(Employee employee,String cpr, String firstName, String lastName, GregorianCalendar dateOfBirth,String phoneNumber,
      String email, int salary,String position)
      throws RemoteException, SQLException
  {
    Employee newEmployee = new Employee(cpr,firstName,lastName,dateOfBirth,phoneNumber,email,salary,position);
    userModel.editEmployeeInfo(employee,newEmployee);
  }
}
