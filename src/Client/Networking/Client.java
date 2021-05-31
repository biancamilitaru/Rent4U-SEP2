package Client.Networking;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Status;
import Client.Model.Vehicle;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface Client
{
    void startClient();
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
    ArrayList<Vehicle> getListOfVehicles() throws SQLException, RemoteException;
    void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
    void createBooking(Booking booking) throws RemoteException, SQLException;
    void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws RemoteException, SQLException;
    ArrayList<Booking> getListOfBookings() throws SQLException, RemoteException;
    void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
    ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws RemoteException, SQLException;
    void createCustomerAccount(Customer customer) throws RemoteException, SQLException;
    ArrayList<Customer> getCustomers() throws SQLException, RemoteException;
  void editCustomerInfo(Customer customer,Customer newCustomer)throws RemoteException, SQLException;
  void createPersonalAccount(Customer customer) throws RemoteException, SQLException;
  void deleteVehicle(Vehicle vehicle) throws RemoteException, SQLException;
  void deleteBooking(Booking booking) throws RemoteException, SQLException;
  void deleteCustomer(Customer customer) throws RemoteException, SQLException;
  Customer checkForPassword(String emailAddress, String password) throws RemoteException, SQLException;
  void editPersonalInfo(Customer customer,Customer newCustomer)throws RemoteException, SQLException;
  ArrayList<Booking> getPersonalBookings(Customer customer) throws RemoteException, SQLException;
  void editPersonalBooking(Booking booking, Booking newBooking) throws RemoteException, SQLException;

}
