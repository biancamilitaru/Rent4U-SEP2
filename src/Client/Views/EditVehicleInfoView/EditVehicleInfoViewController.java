package Client.Views.EditVehicleInfoView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Vehicle;
import Client.ViewModel.EditVehicleInfoViewModel;
import Client.Views.ViewController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class EditVehicleInfoViewController implements ViewController
{
  @FXML private TextField licensePlateField;
  @FXML private TextField enginePowerField;
  @FXML private TextField makeField;
  @FXML private TextField modelField;
  @FXML private TextField yearField;
  @FXML private TextField nbOfSeatsField;
  @FXML private TextField priceField;

  @FXML private RadioButton automaticGearBoxButton;
  @FXML private RadioButton manualGearBoxButton;

  @FXML private RadioButton petrolTypeButton;
  @FXML private RadioButton dieselTypeButton;
  @FXML private RadioButton hybridTypeButton;
  @FXML private RadioButton electricTypeButton;

  @FXML private ComboBox<String> types;

  private ViewHandler viewHandler;
  private Vehicle vehicle;
  private EditVehicleInfoViewModel editVehicleInfoViewModel;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler=viewHandler;
    editVehicleInfoViewModel =viewModelFactory.getEditVehicleInfoViewModel();
    types.getItems().addAll("Car", "Minibus", "Bus", "Motorcycle");
  }

  private String getFuelType(){
    if (petrolTypeButton.isSelected()){
      return  "petrol";
    }
    if (dieselTypeButton.isSelected()){
      return "diesel";
    }
    if (hybridTypeButton.isSelected()){
      return "hybrid";
    }

    if (electricTypeButton.isSelected()){
      return "electric";
    }

    else return "Not selected";
  }

  private String getGearBoxType(){
    if (automaticGearBoxButton.isSelected()){
      return "automatic";
    }
    if (manualGearBoxButton.isSelected()){
      return "manual";
    }
    else return "Not selected";
  }

  public void setVehicle(Vehicle vehicle)
  {
    this.vehicle=vehicle;
    makeField.setText(vehicle.getMake());
    modelField.setText(vehicle.getModel());
    yearField.setText(String.valueOf(vehicle.getYear()));
    nbOfSeatsField.setText(String.valueOf(vehicle.getNumberOfSeats()));
    priceField.setText(String.valueOf(vehicle.getPrice()));
    licensePlateField.setText(vehicle.getLicensePlate());
    enginePowerField.setText(String.valueOf(vehicle.getEnginesPower()));

    if(vehicle.getType().equalsIgnoreCase("Car"))
      types.getSelectionModel().select("Car");
    else if(vehicle.getType().equalsIgnoreCase("Minibus"))
      types.getSelectionModel().select("Minibus");
    else if(vehicle.getType().equalsIgnoreCase("Motorcycle"))
      types.getSelectionModel().select("Motorcycle");
    else if(vehicle.getType().equalsIgnoreCase("Van"))
      types.getSelectionModel().select("Van");

    if (vehicle.getTypeOfGearbox().equalsIgnoreCase("automatic"))
      automaticGearBoxButton.fire();
    else
      manualGearBoxButton.fire();

    if (vehicle.getTypeOfFuel().equalsIgnoreCase("petrol"))
      petrolTypeButton.fire();
    else if (vehicle.getTypeOfFuel().equalsIgnoreCase("diesel"))
      dieselTypeButton.fire();
    else if (vehicle.getTypeOfFuel().equalsIgnoreCase("hybrid"))
      hybridTypeButton.fire();
    else if (vehicle.getTypeOfFuel().equalsIgnoreCase("electric"))
      electricTypeButton.fire();
  }

  public void onUpdateVehicleButton() throws SQLException, RemoteException {
    Platform.runLater(()->{
      try{
        editVehicleInfoViewModel.editVehicleInfo(vehicle,licensePlateField.getText(),
            parseInt(enginePowerField.getText()),
            types.getSelectionModel().getSelectedItem(),
            makeField.getText(),
            modelField.getText(),
            parseInt(yearField.getText()),
            getGearBoxType(),
            getFuelType(),
            parseInt(nbOfSeatsField.getText()),
            parseDouble(priceField.getText())
        );
      }
      catch (NumberFormatException | RemoteException | SQLException e)
      {
        e.printStackTrace();
      }

    });
    viewHandler.openListOfVehicleView();
  }



  public void onExitButton(){
    viewHandler.openMainMenu();
  }

}
