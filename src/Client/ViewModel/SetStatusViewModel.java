package Client.ViewModel;

import Client.Model.ClientModel;
import Client.Model.Vehicle;
import Server.Model.Status;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class SetStatusViewModel
{
  private ClientModel userModel;

  public SetStatusViewModel(ClientModel userModel){
    this.userModel = userModel;

  }
  public void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException {
    userModel.setStatus(vehicle,status);
  }

}

