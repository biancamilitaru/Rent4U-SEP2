package Client.Views.ListOfVehiclesView.VehicleViewCell;

import Client.Model.Vehicle;
import Client.Views.ListOfVehiclesView.ListOfVehiclesViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class VehicleListViewCell extends ListCell<Vehicle>
{
  private ListOfVehiclesViewController listOfVehiclesViewController;

  private FXMLLoader mLLoader;
  public Vehicle vehicle;
  @FXML AnchorPane anchorPane;
  @FXML Label makeLabel;
  @FXML Label modelLabel;
  @FXML Label yearLabel;
  @FXML Label gearboxTypeLabel;
  @FXML Label fuelTypeLabel;
  @FXML Label nbOfSeatsLabel;
  @FXML Label licensePlateLabel;
  @FXML Label enginesPowerLabel;
  @FXML Label priceLabel;
  @FXML Label typeLabel;

  @FXML public ImageView carSymbol = new ImageView();
  @FXML public ImageView seatSymbol = new ImageView();
  @FXML public ImageView gearboxSymbol = new ImageView();
  @FXML public ImageView fuelSymbol = new ImageView();
  @FXML public ImageView licensePlateSymbol = new ImageView();
  @FXML public ImageView engineSymbol = new ImageView();
  @FXML public ImageView editSymbol = new ImageView();
  @FXML public ImageView deleteSymbol = new ImageView();


  public VehicleListViewCell(ListOfVehiclesViewController listOfVehiclesViewController)
  {
    super();
    this.listOfVehiclesViewController=listOfVehiclesViewController;
  }

  public Image carImage = new Image("/GUI/Vehicle/CarSymbol.png");
  public Image minivanSymbolImage = new Image("/GUI/Vehicle/MiniVanSymbol.png");
  public Image busImage = new Image("/GUI/Vehicle/BusSymbol.png");
  public Image motorcycleImage = new Image("/GUI/Vehicle/MotorcycleSymbol.png");
  public Image seatSymbolImage = new Image("/GUI/Vehicle/SeatSymbol.png");
  public Image gearboxSymbolImage = new Image("/GUI/Vehicle/GearboxSymbol.png");
  public Image fuelSymbolImage = new Image("/GUI/Vehicle/FuelSymbol.png");
  public Image engineSymbolImage = new Image("/GUI/Vehicle/EnginePowerSymbol.png");
  public Image editSymbolImage = new Image("/GUI/Vehicle/Edit.png");
  public Image deleteSymbolImage = new Image("/GUI/Vehicle/Delete.png");
  public Image licensePlateImage = new Image("/GUI/Vehicle/LicensePlate.png");

  @Override protected void updateItem(Vehicle vehicle, boolean empty)
  {
    super.updateItem(vehicle, empty);
    this.vehicle = vehicle;

    if (empty || vehicle == null)
    {
      setText(null);
      setGraphic(null);
    }
    else
    {
      if (mLLoader == null)
      {
        mLLoader = new FXMLLoader(getClass().getResource("VehicleListViewCell.fxml"));
        mLLoader.setController(this);

        try
        {
          anchorPane = mLLoader.load();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }

      }
      seatSymbol.setImage(seatSymbolImage);
      gearboxSymbol.setImage(gearboxSymbolImage);
      fuelSymbol.setImage(fuelSymbolImage);
      licensePlateSymbol.setImage(licensePlateImage);
      engineSymbol.setImage(engineSymbolImage);
      editSymbol.setImage(editSymbolImage);
      deleteSymbol.setImage(deleteSymbolImage);


      makeLabel.setText(vehicle.getMake());
      modelLabel.setText(vehicle.getModel());
      yearLabel.setText(String.valueOf(vehicle.getYear()));
      gearboxTypeLabel.setText(vehicle.getTypeOfGearbox());
      fuelTypeLabel.setText(vehicle.getTypeOfFuel());
      nbOfSeatsLabel.setText(String.valueOf(vehicle.getNumberOfSeats()));
      licensePlateLabel.setText(vehicle.getLicensePlate());
      enginesPowerLabel.setText(String.valueOf(vehicle.getEnginesPower()));
      priceLabel.setText(String.valueOf(vehicle.getPrice()));

      if (vehicle.getType().equals("Motorcycle")){
        carSymbol.setImage(motorcycleImage);
      } else if (vehicle.getType().equals("Minibus")) {
        carSymbol.setImage(busImage);
      } else if (vehicle.getType().equals("Van")) {
        carSymbol.setImage(minivanSymbolImage);
      } else carSymbol.setImage(carImage);

      if (getIndex()%2==0){
        //OnOrange
        setStyle("-fx-background-color: FFFFFF");
      } else {
        //OnWhite
        setStyle("-fx-background-color: F4AF82");
      }

      setText(null);
      setGraphic(this.anchorPane);
    }

    }


  public void clickedEditButton() throws SQLException, RemoteException
  {
    listOfVehiclesViewController.onEdit(vehicle);
  }

  public void clickedDeleteButton() throws RemoteException, SQLException
  {
    listOfVehiclesViewController.onClickedDelete(vehicle);
  }
}
