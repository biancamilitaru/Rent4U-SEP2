package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;
import javafx.event.Event;
import javafx.event.EventHandler;

public class AddVehicleViewModel
{
  private ClientModel userModel;

  public AddVehicleViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public void addVehicle(String licensePlate, int enginePower, String type, String make, String model, int year,
      String gearBoxType, String fuelType, int numberOfSeats, double price)
  {
    userModel.addVehicle(new Vehicle(licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType, numberOfSeats,price));

  }
}
