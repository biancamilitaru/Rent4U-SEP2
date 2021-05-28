package Client.Views.LogInForCustomerView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.Views.ViewController;
import javafx.fxml.FXML;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LogInForCustomerViewController implements ViewController
{
  private Customer customer;

  public void setCustomer(Customer customer)
  {
    this.customer=customer;
  }

  private String[] splitCpr(String cprFull){
    String[] parts = cprFull.split("/");
    return parts;
  }
  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {

  }
}
