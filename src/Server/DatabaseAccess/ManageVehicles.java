package Server.DatabaseAccess;

import Client.Model.Status;
import Client.Model.Vehicle;


import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageVehicles
{
    void addNewVehicle(Vehicle vehicle) throws SQLException;
    ArrayList<Vehicle> viewAllVehicles() throws SQLException;
    void setStatus(Vehicle vehicle, Status status) throws SQLException;
  void editVehicleInfo(Vehicle vehicle, String licensePlate, int enginePower, String type, String make, String model,
      int year, String gearBoxType, String fuelType, int numberOfSeats, double price);
}
