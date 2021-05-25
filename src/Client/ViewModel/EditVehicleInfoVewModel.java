package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;

public class EditVehicleInfoVewModel
{
  private ClientModel userModel;

  public EditVehicleInfoVewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public void editVehicleInfo(Vehicle vehicle,String licensePlate, int enginePower, String type, String make, String model, int year,
      String gearBoxType, String fuelType, int numberOfSeats, double price)
  {
    userModel.editVehicleInfo(vehicle,licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType,numberOfSeats,price);
  }
}
