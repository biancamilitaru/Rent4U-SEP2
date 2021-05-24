package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;
import Server.Model.Status;

public class SetStatusViewModel
{
  private ClientModel userModel;

  public SetStatusViewModel(ClientModel userModel){
    this.userModel = userModel;

  }
  public void setStatus(Vehicle vehicle, Status status){
    userModel.setStatus(vehicle,status);
  }

}

