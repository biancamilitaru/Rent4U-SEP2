package Client.Core;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Employee;
import Client.Model.Vehicle;
import Client.ViewModel.AddEmployeeViewModel;
import Client.Views.AddBookingCustomerView.AddBookingCustomerViewController;
import Client.Views.AddBookingView.AddBookingViewController;
import Client.Views.AddCustomerAccountView.AddCustomerAccountViewController;
import Client.Views.AddEmployeesView.AddEmployeesViewController;
import Client.Views.AddPersonalAccountView.AddPersonalAccountViewController;
import Client.Views.EditBookingInfoView.EditBookingInfoViewController;
import Client.Views.EditCustomerAccountInfoView.EditCustomerAccountInfoViewController;
import Client.Views.EditEmployeeInfoView.EditEmployeeInfoViewController;
import Client.Views.EditPersonalInfoView.EditPersonalInfoViewController;
import Client.Views.EditVehicleInfoView.EditVehicleInfoViewController;
import Client.Views.ListOfPersonalBookings.ListOfPersonalBookingsViewController;
import Client.Views.ListOfBookingsView.ListOfBookingsViewController;
import Client.Views.ListOfCustomersView.ListOfCustomersViewController;
import Client.Views.ListOfVehiclesView.ListOfVehiclesViewController;
import Client.Views.LogInForCustomerView.LogInForCustomerViewController;
import Client.Views.LogInView.LoginViewController;
import Client.Views.MenuCustomerView.MenuCustomerViewController;
import Client.Views.MenuForLogInView.MenuForLogInViewController;
import Client.Views.MenuView.MenuViewController;
import Client.Views.AddVehicleView.AddVehicleViewController;
import Client.Views.SetStatusView.SetStatusViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ViewHandler
{
  private static ViewHandler instance = new ViewHandler();

  public static ViewHandler getInstance(){
    if(instance == null)
      instance = new ViewHandler();
    return instance;
  }

  private Stage stage;

  private ViewHandler() {}

  public void start() throws IOException, SQLException {
    stage = new Stage();
    openLogInMenu();
  }

  public void openLogInEmployee()
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/LogInView/LoginView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    LoginViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("LogIn");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddVehicle()
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddVehicleView/AddVehicleView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddVehicleViewController view= loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Add Vehicle");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  public void openMainMenu()
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/MenuView/MenuView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    MenuViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Menu");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openListOfVehicleView() throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/ListOfVehiclesView/VehicleListView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    ListOfVehiclesViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("List of vehicles");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  public void openListOfBookingsView() throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/ListOfBookingsView/ListOfBookingsView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    ListOfBookingsViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("List of bookings");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openSetStatusView(Vehicle vehicle) {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/SetStatusView/SetStatusView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    SetStatusViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Set status");
    view.setVehicle(vehicle);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openEditVehicle(Vehicle vehicle) throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/EditVehicleInfoView/EditVehicleInfoView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditVehicleInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit vehicle");
    view.setVehicle(vehicle);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddBooking() throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddBookingView/AddBookingView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddBookingViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Add Booking");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  public void openEditBooking(Booking booking) throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/EditBookingInfoView/EditBookingInfoView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditBookingInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit booking");
    view.setBooking(booking);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openEditBookingInfo(Booking booking) throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/EditBookingInfoView.EditBookingInfoView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditBookingInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit booking");
    view.setBooking(booking);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddCustomer() throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddCustomerAccountView/AddCustomerAccount.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddCustomerAccountViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Add customer");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  public void openAddPersonalAccount() throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddPersonalAccountView/AddPersonalAccountView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddPersonalAccountViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Add Personal Account");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openEditCustomerInfo(Customer customer) throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/EditCustomerAccountInfoView/EditCustomerAccountInfo.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditCustomerAccountInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit Customer Info");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openLogInCustomer() throws SQLException, RemoteException
  {
    //Still need to do the fxml for the login for the customer
    //The path might not be correct
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/LogInForCustomerView/LogInForCustomerView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    LogInForCustomerViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Log in for Customer");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddBookingCustomer(Customer customer) throws SQLException, RemoteException
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddBookingCustomerView/AddBookingCustomerView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddBookingCustomerViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Log In Menu");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openLogInMenu() throws SQLException, RemoteException
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/MenuForLogInView/MenuForLogInView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    MenuForLogInViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Log In Menu");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openListOfCustomers() throws SQLException, RemoteException
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/ListOfCustomersView/ListOfCustomersView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    ListOfCustomersViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("List of customers");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openMenuCustomerView(Customer customer) throws SQLException, RemoteException {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/MenuCustomerView/MenuCustomerView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    MenuCustomerViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Menu");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openListOfBookingCustomer(Customer customer) throws SQLException, RemoteException {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../Views/EditPersonalInfoView/EditPersonalInfoView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    ListOfPersonalBookingsViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit Personal Info");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  public void openEditPersonalInfo(Customer customer) throws SQLException, RemoteException {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../Views/EditPersonalInfoView/EditPersonalInfoView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditPersonalInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit Personal Info");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openEditEmployeeInfo(Employee employee) throws SQLException, RemoteException {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../Views/EditEmployeeInfoView/EditEmployeeInfo.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    EditEmployeeInfoViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Edit Personal Info");
    view.setEmployee(employee);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }



  public void openPersonalBookings(Customer customer) throws SQLException, RemoteException {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../Views/ListOfPersonalBookings/ListOfPersonalBookingsView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    //Check what Milan named the controller
    ListOfPersonalBookingsViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Personal Bookings");
    view.setCustomer(customer);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openListOfEmployees() throws SQLException, RemoteException
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/ListOfEmployeesView.ListOfEmployeesView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    ListOfEmployeesViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("List of employees");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddEmployee() throws SQLException, RemoteException
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/AddEmployeesView/AddEmployeesView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    AddEmployeesViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Add Employees");

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openEditEmployeeInfo(Employee employee)
  {
  }
}
