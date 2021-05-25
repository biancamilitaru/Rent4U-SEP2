package Client.Model;

import Server.Model.Date;
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
  void editVehicleInfo(Vehicle vehicle,String licensePlate, int enginePower, String type, String make, String model, int year,
      String gearBoxType, String fuelType, int numberOfSeats, double price);
  ArrayList<Booking> getBookings();
  void editBookingInfo(Booking booking, int idOfCustomer, String licencePlate, Date startTime, Date endTime, int price);
}
