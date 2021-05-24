package Server.DatabaseAccess;

import Client.Model.Vehicle;
import Server.Model.Status;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageVehicles
{
    void addNewVehicle(Vehicle vehicle) throws SQLException;
  ArrayList<Vehicle> getListOfVehicles();
  void setStatus(Vehicle vehicle, Status status);
}
