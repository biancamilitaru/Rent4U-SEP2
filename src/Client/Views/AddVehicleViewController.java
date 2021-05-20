package Client.Views;

import Client.ViewHandler;
import Client.ViewModelFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;

import java.awt.*;

import static java.lang.Integer.parseInt;

public class AddVehicleViewController implements ViewController
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

  @FXML private MenuButton typeMenuButton;


  private ViewHandler viewHandler;
  private AddVehicleViewModel addVehicleViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    this.addVehicleViewModel = vmf.getAddVehicleViewModel;
  }

  private String getFuelType(){
    if (petrolTypeButton.isSelected()){
      return  "petrol";
    }
    if (dieselTypeButton.isSelected()){
      return "diesel";
    }
    if (hybridTypeButton.isSelected(){
      return "hybrid";
    }
  }

  private String getGearBoxType(){
    if (automaticGearBoxButton.isSelected()){
      return "automatic";
    }
    if (manualGearBoxButton.isSelected()){
      return "manual";
    }
  }



  public void onAddButton(){
    Platform.runLater(() -> addVehicleViewModel.addVehicle(
        licensePlateField.getText(),
        enginePowerField.getText(),
        typeMenuButton.getOnShowing(),
        makeField.getText(),
        modelField.getText(),
        parseInt(yearField.getText()),
        getGearBoxType(),
        getFuelType(),
        parseInt(priceField.getText())
        ));
    viewHandler.openMainMenu;
  }

  public void onExitButton(){
    viewHandler.openMainMenu;
  }
}
