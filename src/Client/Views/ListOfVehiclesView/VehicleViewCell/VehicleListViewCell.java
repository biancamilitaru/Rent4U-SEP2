package Client.Views.ListOfVehiclesView.VehicleViewCell;

import Client.Model.Vehicle;
import Client.Views.ListOfVehiclesView.ListOfVehiclesViewController;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.css.Stylesheet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    this.listOfVehiclesViewController=listOfVehiclesViewController;

    Platform.runLater(() ->  carSymbol.setImage(listOfVehiclesViewController.getCarSymbolImageOrange()));
    Platform.runLater(() ->  seatSymbol.setImage(listOfVehiclesViewController.getSeatSymbolImageOrange()));
    Platform.runLater(() ->  gearboxSymbol.setImage(listOfVehiclesViewController.getGearboxSymbolImageOrange()));
    Platform.runLater(() ->  fuelSymbol.setImage(listOfVehiclesViewController.getFuelSymbolImageOrange()));
    Platform.runLater(() ->  licensePlateSymbol.setImage(listOfVehiclesViewController.getLicensePlateSymbolImage()));
    Platform.runLater(() ->  engineSymbol.setImage(listOfVehiclesViewController.getEngineSymbolImageOrange()));
    Platform.runLater(() ->  editSymbol.setImage(listOfVehiclesViewController.getEditSymbolImageOrange()));
    Platform.runLater(() ->  deleteSymbol.setImage(listOfVehiclesViewController.getDeleteSymbolImageOrange()));
  }

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
      makeLabel.setText(vehicle.getMake());
      modelLabel.setText(vehicle.getModel());
      yearLabel.setText(String.valueOf(vehicle.getYear()));
      gearboxTypeLabel.setText(vehicle.getTypeOfGearbox());
      fuelTypeLabel.setText(vehicle.getTypeOfFuel());
      nbOfSeatsLabel.setText(String.valueOf(vehicle.getNumberOfSeats()));
      licensePlateLabel.setText(vehicle.getLicensePlate());
      enginesPowerLabel.setText(String.valueOf(vehicle.getEnginesPower()));
      priceLabel.setText(String.valueOf(vehicle.getPrice()));

      System.out.println(getId());

      if (getIndex()%2==0){
        //OnOrange
        setStyle("-fx-background-color: FFFFFF");
      } else {
        //OnWhite
        setStyle("-fx-background-color: F4AF82");
        System.out.println(getStyle());
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
