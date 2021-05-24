package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;

import java.util.ArrayList;

public class ListOfVehiclesViewModel
{
  private ClientModel userModel;

  public ListOfVehiclesViewModel(ClientModel userModel)
  {
    this.userModel=userModel;
  }

  public ArrayList<Vehicle> getVehicles()
  {
    return userModel.getVehicles();
  }

}
