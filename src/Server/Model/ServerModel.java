package Server.Model;

import Client.Model.Booking;
import Client.Model.Status;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ServerModel
{
    void addVehicle(Vehicle vehicle) throws SQLException;
  ArrayList<Vehicle> viewAllVehicles() throws SQLException;
  void setStatus(Vehicle vehicle, Status status) throws SQLException;
  void createBooking(Booking booking);
  void editVehicleInfo(Vehicle vehicle, String licensePlate, int enginePower, String type, String make, String model,
      int year, String gearBoxType, String fuelType, int numberOfSeats, double price)
      throws RemoteException;
  ArrayList<Booking> viewAllBookings() throws SQLException;
  void editBookingInfo(Booking booking, int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, int price) throws RemoteException;
}


