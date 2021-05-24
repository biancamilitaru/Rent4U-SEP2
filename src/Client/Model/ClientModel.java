package Client.Model;

import Server.Model.Status;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientModel
{
  boolean login (String s);
  void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException;
  void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
  void createBooking(Booking booking) throws RemoteException;

}
