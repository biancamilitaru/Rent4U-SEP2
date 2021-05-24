package Server.Model;

import Client.Model.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServerModel
{
    void addVehicle(Vehicle vehicle) throws SQLException;
  ArrayList<Vehicle> getListOfVehicles();
  void setStatus(Vehicle vehicle, Status status);
}


