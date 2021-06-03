package Client.Views.EditPersonalBookingView.VehicleViewCell;

import Client.Model.Vehicle;
import Client.Views.AddBookingCustomerView.AddBookingCustomerViewController;
import Client.Views.EditPersonalBookingView.EditPersonalBookingViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class VehicleListViewCell extends ListCell<Vehicle>
{
  public Vehicle vehicle;
  @FXML Label makeLabel;
  @FXML Label modelLabel;
  @FXML Label yearLabel;
  @FXML Label gearboxTypeLabel;
  @FXML Label fuelTypeLabel;
  @FXML Label nbOfSeatsLabel;
  @FXML Label licensePlateLabel;
  @FXML Label enginesPowerLabel;
  @FXML Label priceLabel;

  @FXML AnchorPane anchorPane;

  private FXMLLoader mLLoader;
  private EditPersonalBookingViewController viewController;

  public VehicleListViewCell(
      EditPersonalBookingViewController editPersonalBookingViewController){
    this.viewController=editPersonalBookingViewController;
  }

  @Override protected void updateItem(Vehicle vehicle, boolean empty)
  {
    super.updateItem(vehicle, empty);
    this.vehicle=vehicle;

    if (empty || vehicle == null)
    {
      setText(null);
      setGraphic(null);
    }
    else
    {
      if (mLLoader == null)
      {
        mLLoader = new FXMLLoader(getClass().getResource("VehicleViewCell.fxml"));
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
      enginesPowerLabel.setText(String.valueOf(vehicle.getEnginesPower()) + " HP");
      priceLabel.setText(String.valueOf(vehicle.getPrice()));

      if (viewController.getBooking().getLicencePlate().equals(vehicle.getLicensePlate())){
        setStyle("-fx-background-color: F4AF82");
      }

      setText(null);
      setGraphic(this.anchorPane);
    }
  }

  public void onChooseButton()
  {
    viewController.setVehicle(vehicle);
    setStyle("-fx-background-color: D87737");
    viewController.setTotalPriceOfBooking();
  }
}