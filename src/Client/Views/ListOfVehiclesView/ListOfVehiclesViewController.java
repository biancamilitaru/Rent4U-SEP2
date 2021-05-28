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
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfVehiclesViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;

  //@FXML TableView table = new TableView();

  @FXML ListView<Vehicle> listView;
  @FXML ImageView logoSymbol;


  public final ObservableList<Vehicle> tableObservableList = FXCollections.observableArrayList();

  String url = "/GUI/Vehicle/onWhite/CarSymbol.png";

  public Image carSymbolImageOrange = new Image(url);
  public Image seatSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/SeatSymbolOrange.png");
  public Image gearboxSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/GearboxSymbolOrange.png");
  public Image fuelSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/FuelTypeSymbolOrange.png");
  public Image engineSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/EnginePowerSymbolOrange.png");
  public Image editSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/EditSymbolOrange.png");
  public Image deleteSymbolImageOrange = new Image("/GUI/Vehicle/onOrange/DeleteSymbolOrange.png");
  public Image licensePlateSymbolImage = new Image("/GUI/Vehicle/LicensePlate.png");

  public Image getCarSymbolImageOrange() { return carSymbolImageOrange; }
  public Image getSeatSymbolImageOrange() { return seatSymbolImageOrange; }
  public Image getGearboxSymbolImageOrange() { return gearboxSymbolImageOrange; }
  public Image getFuelSymbolImageOrange() { return fuelSymbolImageOrange; }
  public Image getEngineSymbolImageOrange() { return engineSymbolImageOrange; }
  public Image getEditSymbolImageOrange() { return editSymbolImageOrange; }
  public Image getDeleteSymbolImageOrange() { return deleteSymbolImageOrange; }
  public Image getLicensePlateSymbolImage() { return licensePlateSymbolImage; }


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException {
    this.viewHandler = viewHandler;
    this.listOfVehiclesViewModel = viewModelFactory.getListOfVehiclesViewModel();
    //addStatusButton();
    //addEditButton();

    Vehicle car1 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car2 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car3 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car4 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car5 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car6 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car7 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car8 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);
    Vehicle car9 = new Vehicle("BA40136",105,"Car","Audi","A1 Hatchback",2011,"manual","diesel",4,750);

    ArrayList<Vehicle> cars = new ArrayList<>();
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);

    getVehicleData(cars);

    Image logo = new Image("/GUI/Logo.png");
    logoSymbol.setImage(logo);

    //getVehicleData(listOfVehiclesViewModel.getVehicles());

    //table.setItems(tableObservableList);

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
  }

  public ObservableList<Vehicle> getVehicleData(ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      tableObservableList.add(vehiclesArrayList.get(x));
    }
    return tableObservableList;
}


/*
  private void addStatusButton() {
    TableColumn<Vehicle, Void> colBtn = new TableColumn("Status");

    Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>> cellFactory = new Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>>() {
      @Override
      public TableCell<Vehicle, Void> call(final TableColumn<Vehicle, Void> param) {
        final TableCell<Vehicle, Void> cell = new TableCell<Vehicle, Void>() {

          private final Button btn = new Button("New");

          {
            btn.setOnAction((ActionEvent event) -> {
              Vehicle data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              viewHandler.openSetStatusView(data);

            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };

    colBtn.setCellFactory(cellFactory);
    colBtn.setPrefWidth(82.5);

    table.getColumns().add(colBtn);

  }

  private void addEditButton() {
    TableColumn<Vehicle, Void> colBtn = new TableColumn("Edit");

    Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>> cellFactory = new Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>>() {
      @Override
      public TableCell<Vehicle, Void> call(final TableColumn<Vehicle, Void> param) {
        final TableCell<Vehicle, Void> cell = new TableCell<Vehicle, Void>() {

          private final Button btn = new Button("Edit");

          {
            btn.setOnAction((ActionEvent event) -> {
              Vehicle data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              try {
                viewHandler.openEditVehicle(data);
              } catch (SQLException throwables) {
                throwables.printStackTrace();
              } catch (RemoteException e) {
                e.printStackTrace();
              }
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };

    colBtn.setCellFactory(cellFactory);
    colBtn.setPrefWidth(82.5);

    table.getColumns().add(colBtn);

  }
 */

}
