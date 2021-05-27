package Server.Model;

import Client.Model.Booking;
import Client.Model.Customer;
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
  void createBooking(Booking booking) throws SQLException;
  void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws RemoteException, SQLException;
  ArrayList<Booking> viewAllBookings() throws SQLException;
  void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
  ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws SQLException, RemoteException;
  void addCustomer(Customer customer) throws RemoteException, SQLException;
  ArrayList<Customer> viewAllCustomers() throws RemoteException, SQLException;
  void editCustomerInfo(Customer customer, Customer newCustomer) throws RemoteException, SQLException;
}


