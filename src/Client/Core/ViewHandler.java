package Client.Core;

import Client.Model.Booking;
import Client.Model.Vehicle;
import Client.Views.AddBookingView.AddBookingViewController;
import Client.Views.EditBookingInfoView.EditBookingInfoViewController;
import Client.Views.EditVehicleInfoView.EditVehicleInfoViewController;
import Client.Views.ListOfVehiclesView.ListOfVehiclesViewController;
import Client.Views.LogInView.LoginViewController;
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
    openLogInEmployee();
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

    loader.setLocation(getClass().getResource("../Views/EditVehicleInfoView/EditVehicleInfoViewController.fxml"));
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
    stage.setTitle("Edit vehicle");

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

}
