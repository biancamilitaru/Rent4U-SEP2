package Server.Model;

import Client.Model.*;

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
  void createPersonalAccount(Customer customer) throws RemoteException, SQLException;
  void editCustomerInfo(Customer customer, Customer newCustomer) throws RemoteException, SQLException;
  void deleteVehicle(Vehicle vehicle) throws RemoteException, SQLException;
  void deleteBooking(Booking booking) throws RemoteException, SQLException;
  void deleteCustomer(Customer customer) throws RemoteException, SQLException;
  Customer checkForPassword(String emailAddress, String password) throws RemoteException, SQLException;
  void editPersonalInfo(Customer customer,Customer newCustomer)throws RemoteException, SQLException;
  void editPersonalBooking(Booking booking, Booking newBooking) throws RemoteException, SQLException;
  ArrayList<Booking> getPersonalBookings(Customer customer) throws RemoteException, SQLException;
  void createEmployee(Employee employee) throws RemoteException, SQLException;
}


