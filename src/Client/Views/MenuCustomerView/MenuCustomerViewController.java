package Client.Views.MenuCustomerView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.ViewModel.LogInCustomerViewModel;
import Client.ViewModel.MenuCustomerViewModel;
import Client.Views.ViewController;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MenuCustomerViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MenuCustomerViewModel menuCustomerViewModel;

  private Customer customer;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.menuCustomerViewModel=viewModelFactory.getMenuCustomerViewModel();
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public void onCreateBooking() throws SQLException, RemoteException {
    viewHandler.openAddBookingCustomer(customer);
  }

  public void onMyBooking(){

  }

  public void onMyAccount() throws SQLException, RemoteException {
    viewHandler.openEditPersonalInfo(customer);
  }

  public void onLogOutButton() throws SQLException, RemoteException {
    viewHandler.openLogInMenu();
  }
}
