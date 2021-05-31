package Shared;

import Client.Model.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface RMIServer extends Remote
{
    void startServer() throws RemoteException, AlreadyBoundException;
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
    ArrayList<Vehicle> viewAllVehicles() throws SQLException, RemoteException;
    void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
    void createBooking(Booking booking) throws RemoteException, SQLException;
    void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws RemoteException, SQLException;
    ArrayList<Booking> viewAllBookings() throws RemoteException, SQLException;
    void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
    ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws RemoteException, SQLException;
    void createCustomerAccount(Customer customer) throws RemoteException, SQLException;
    ArrayList<Customer> getCustomers() throws RemoteException, SQLException;
    void editCustomerInfo(Customer customer, Customer newCustomer)throws RemoteException, SQLException;
    void deleteVehicle(Vehicle vehicle) throws RemoteException, SQLException;
    void createPersonalAccount(Customer customer) throws RemoteException, SQLException;
    void deleteBooking(Booking booking) throws RemoteException, SQLException;
    void deleteCustomer(Customer customer) throws RemoteException, SQLException;
    Customer checkForPassword(String emailAddress, String password) throws RemoteException, SQLException;
    void editPersonalInfo(Customer customer, Customer newCustomer)throws RemoteException, SQLException;
    ArrayList<Booking> getPersonalBookings(Customer customer) throws RemoteException, SQLException;
    void editPersonalBooking(Booking booking, Booking newBooking) throws RemoteException, SQLException;
    void createEmployee(Employee employee) throws RemoteException, SQLException;
    void deletePersonalBooking(Booking booking) throws RemoteException, SQLException;
    void editEmployeeInfo(Employee employee,Employee newEmployee) throws RemoteException, SQLException;
}
