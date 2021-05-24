package Client.Model;

import Server.Model.Status;
import Util.Answer;
import Util.Request;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientModel
{
  boolean login (String s);
  void newRequest(Request request);
  void newAnswer(Answer answer);
  void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException;
  void setStatus(Vehicle vehicle, Status status) throws RemoteException;
}
