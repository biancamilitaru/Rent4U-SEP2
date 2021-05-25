package Client.Model;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ClientModel
{
  boolean login (String s);
  void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException;
  void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
  void createBooking(Booking booking) throws RemoteException;
  void editVehicleInfo(Vehicle vehicle,Vehicle newVehicle) throws RemoteException;
  ArrayList<Booking> getBookings() throws SQLException, RemoteException;
  void editBookingInfo(Booking booking, int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, int price) throws RemoteException;
}
