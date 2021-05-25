package Client.Networking;

import Client.Model.Booking;
import Client.Model.Vehicle;
import Server.Model.Status;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Client
{
    void startClient();
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
    ArrayList<Vehicle> getListOfVehicles() throws SQLException, RemoteException;
    void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
    void createBooking(Booking booking) throws RemoteException;
  void editVehicleInfo(Vehicle vehicle, String licensePlate, int enginePower, String type, String make, String model,
      int year, String gearBoxType, String fuelType, int numberOfSeats, double price)
      throws RemoteException;
}
