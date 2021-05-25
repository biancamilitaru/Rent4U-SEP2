package Server.Model;

import Client.Model.Booking;
import Client.Model.Vehicle;
import Server.DatabaseAccess.ManageBookings;
import Server.DatabaseAccess.ManageVehicles;
import Server.DatabaseAccess.Rent4UDAO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
    private ManageVehicles manageVehicles;
    private ManageBookings manageBookings;

    public ServerModelManager() throws SQLException {
        manageVehicles = new Rent4UDAO();
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException {
        manageVehicles.addNewVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> viewAllVehicles() throws SQLException {
        return manageVehicles.viewAllVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws SQLException {
        manageVehicles.setStatus(vehicle,status);
    }

    @Override public void createBooking(Booking booking)
    {
        manageBookings.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, String licensePlate,
        int enginePower, String type, String make, String model, int year,
        String gearBoxType, String fuelType, int numberOfSeats, double price) throws
        RemoteException
    {
        manageVehicles.editVehicleInfo(vehicle,licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType,numberOfSeats,price);
    }

    public ArrayList<Booking> viewAllBookings() throws SQLException
    {
        return manageBookings.viewAllBookings();
    }
}
