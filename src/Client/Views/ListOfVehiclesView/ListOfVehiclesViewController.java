package Client.Views.ListOfVehiclesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Vehicle;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.ListOfVehiclesView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfVehiclesViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;

  @FXML ListView<Vehicle> listView;
  @FXML ImageView logoSymbol;


  public final ObservableList<Vehicle> tableObservableList = FXCollections.observableArrayList();

  public Image carSymbolImage = new Image("/GUI/Vehicle/CarSymbol.png");
  public Image minivanSymbolImage = new Image("/GUI/Vehicle/MiniVanSymbol.png");
  public Image busImage = new Image("/GUI/Vehicle/BusSymbol.png");
  public Image motorcycleImage = new Image("/GUI/Vehicle/MotorcycleSymbol.png");
  public Image seatSymbolImage = new Image("/GUI/Vehicle/SeatSymbol.png");
  public Image gearboxSymbolImage = new Image("/GUI/Vehicle/GearboxSymbol.png");
  public Image fuelSymbolImage = new Image("/GUI/Vehicle/FuelSymbol.png");
  public Image engineSymbolImage = new Image("/GUI/Vehicle/EnginePowerSymbol.png");
  public Image editSymbolImage = new Image("/GUI/Vehicle/EditSymbol.png");
  public Image deleteSymbolImage = new Image("/GUI/Vehicle/DeleteSymbol.png");
  public Image licensePlateSymbol = new Image("/GUI/Vehicle/LicensePlate.png");

  public Image getCarSymbolImage() { return carSymbolImage; }
  public Image getMinivanSymbolImage() { return minivanSymbolImage; }
  public Image getBusImage() { return busImage; }
  public Image getMotorcycleImage() { return motorcycleImage; }
  public Image getSeatSymbolImage() { return seatSymbolImage; }
  public Image getGearboxSymbolImage() { return gearboxSymbolImage; }
  public Image getFuelSymbolImage() { return fuelSymbolImage; }
  public Image getEngineSymbolImage() { return engineSymbolImage; }
  public Image getEditSymbolImage() { return editSymbolImage; }
  public Image getDeleteSymbolImage() { return deleteSymbolImage; }
  public Image getLicensePlateSymbolImage() { return licensePlateSymbol; }


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException {
    this.viewHandler = viewHandler;
    this.listOfVehiclesViewModel = viewModelFactory.getListOfVehiclesViewModel();
    getVehicleData(listOfVehiclesViewModel.getVehicles());

    Image logo = new Image("/GUI/Logo.png");
    logoSymbol.setImage(logo);
    listView.setItems(tableObservableList);
    listView.setCellFactory(vehicleListView -> new VehicleListViewCell(this));
    listView.setFixedCellSize(50);

    listView.setFocusTraversable( false );
  }

  public void onAddVehicleButton(ActionEvent evt)
  {
    viewHandler.openAddVehicle();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public void onEdit(Vehicle vehicle) throws SQLException, RemoteException
  {
    viewHandler.openEditVehicle(vehicle);
  }

  public void onClickedDelete(Vehicle vehicle)
      throws RemoteException, SQLException
  {
    listOfVehiclesViewModel.deleteVehicle(vehicle);
    viewHandler.openListOfVehicleView();
  }

  public ObservableList<Vehicle> getVehicleData(ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      tableObservableList.add(vehiclesArrayList.get(x));
    }
    return tableObservableList;
}
}
