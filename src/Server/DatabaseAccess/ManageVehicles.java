package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageVehicles
{
    void addNewVehicle(Vehicle vehicle) throws SQLException;
  ArrayList<Vehicle> getListOfVehicles();
}
