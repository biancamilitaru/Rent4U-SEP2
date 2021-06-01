package Client.Views.ListOfEmployeesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Employee;
import Client.ViewModel.ListOfEmployeesViewModel;
import Client.Views.ListOfEmployeesView.EmployeeCellView.EmployeeCellViewController;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfEmployeesViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfEmployeesViewModel listOfEmployeesViewModel;

  @FXML ListView<Employee> listView;

  public final ObservableList<Employee> employeesArrayList = FXCollections.observableArrayList();

  private boolean manager;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    this.listOfEmployeesViewModel = viewModelFactory.getListOfEmployeesViewModel();
    getEmployeesData(listOfEmployeesViewModel.getEmployees());
    listView.setItems(employeesArrayList);
    listView.setCellFactory(employeeListView -> new EmployeeCellViewController(this));
    listView.setFixedCellSize(40);
  }

  public void setManager(boolean manager)
  {
    this.manager = manager;
  }

  public ObservableList<Employee> getEmployeesData(
      ArrayList<Employee> customersArrayList)
  {
    for (int x = 0; x < employeesArrayList.size(); x++)
    {
      employeesArrayList.add(customersArrayList.get(x));
    }
    return employeesArrayList;
  }

  public void onAddEmployeeButton() throws SQLException, RemoteException {
    viewHandler.openAddEmployee(manager);
  }

  public void onMenuButton(){
    viewHandler.openMainMenu(manager);
  }

  public void onEditEmployee(Employee employee)
      throws SQLException, RemoteException
  {
    viewHandler.openEditEmployeeInfo(employee, manager);
  }
  
  public void deleteEmployee(Employee employee)
      throws SQLException, RemoteException
  {
    listOfEmployeesViewModel.deleteEmployee(employee);
    viewHandler.openListOfEmployees(manager);
  }

}
