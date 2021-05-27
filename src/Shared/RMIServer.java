package Shared;

import Client.Model.Booking;
import Client.Model.Status;
import Client.Model.Vehicle;


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
  void createCustomerAccount(String firstName, String lastName, GregorianCalendar dateOfBirth, String email, String password,
      String phoneNumber, String drivingLicenseNumber, String cpr_number);
}
