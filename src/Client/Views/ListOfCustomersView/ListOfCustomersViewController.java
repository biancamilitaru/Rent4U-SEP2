package Client.Views.ListOfCustomersView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Customer;
import Client.ViewModel.ListOfCustomersViewModel;
import Client.Views.ListOfCustomersView.CustomerCellView.CustomerListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfCustomersViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfCustomersViewModel listOfCustomersViewModel;

  @FXML ListView<Customer> listView;

  public final ObservableList<Customer> customersObservableList = FXCollections.observableArrayList();

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    this.listOfCustomersViewModel = viewModelFactory.getListOfCustomersViewModel();
    getCustomersData(listOfCustomersViewModel.getCustomers());
    listView.setItems(customersObservableList);
    listView.setCellFactory(customerListView -> new CustomerListViewCell(this));
    listView.setFixedCellSize(40);
  }

  public ObservableList<Customer> getCustomersData(
      ArrayList<Customer> customersArrayList)
  {
    for (int x = 0; x<customersArrayList.size(); x++){
      customersObservableList.add(customersArrayList.get(x));
    }
    return customersObservableList;
  }

  public void onAddCustomerButton() throws SQLException, RemoteException {
    viewHandler.openAddCustomer();
  }

  public void onMenuButton(){
    viewHandler.openMainMenu();
  }

  public void editCustomer(Customer customer) throws SQLException, RemoteException
  {
    viewHandler.openEditCustomerInfo(customer);
  }

  public void deleteCustomer(Customer customer) throws RemoteException, SQLException
  {
    listOfCustomersViewModel.deleteCustomer(customer);
  }


}
