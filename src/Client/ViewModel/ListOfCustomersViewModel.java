package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfCustomersViewModel
{
  private ClientModel userModel;

  public ListOfCustomersViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public ArrayList<Customer> getCustomers() throws SQLException, RemoteException
  {
    return userModel.getCustomers();
  }
}
