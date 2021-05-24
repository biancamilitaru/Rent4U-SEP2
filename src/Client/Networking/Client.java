package Client.Networking;

import Client.Model.Vehicle;
import Server.Model.Status;
import Util.Answer;
import Util.Request;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Client
{
    void startClient();
    void newRequest(Request request);
    void newAnswer(Answer answer);
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getListOfVehicles();
  void setStatus(Vehicle vehicle, Status status);
}
