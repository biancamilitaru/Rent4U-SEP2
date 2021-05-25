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
    void createBooking(Booking booking) throws RemoteException;
    void editVehicleInfo(Vehicle vehicle, String licensePlate, int enginePower, String type, String make, String model,
        int year, String gearBoxType, String fuelType, int numberOfSeats, double price) throws RemoteException;
    ArrayList<Booking> viewAllBookings() throws SQLException;
    void editBookingInfo(Booking booking, int idOfCustomer, String licencePlate, GregorianCalendar startTime, GregorianCalendar endTime, int price) throws RemoteException;
}
