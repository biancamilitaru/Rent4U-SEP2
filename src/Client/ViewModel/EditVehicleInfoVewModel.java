package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class EditVehicleInfoVewModel
{
  private ClientModel userModel;

  public EditVehicleInfoVewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public void editVehicleInfo(Vehicle vehicle,String licensePlate, int enginePower, String type, String make, String model, int year,
      String gearBoxType, String fuelType, int numberOfSeats, double price)
      throws RemoteException
  {
    userModel.editVehicleInfo(vehicle,licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType,numberOfSeats,price);
  }
}
