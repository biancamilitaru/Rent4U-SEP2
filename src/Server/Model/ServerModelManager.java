package Server.Model;

import Client.Model.Booking;
import Client.Model.Status;
import Client.Model.Vehicle;
import Server.DatabaseAccess.ManageBookings;
import Server.DatabaseAccess.ManageVehicles;
import Server.DatabaseAccess.Rent4UDAO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ServerModelManager implements ServerModel
{
    private ManageVehicles manageVehicles;
    private ManageBookings manageBookings;

    public ServerModelManager() throws SQLException {
        manageVehicles = new Rent4UDAO();
        manageBookings = new Rent4UDAO();
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

    @Override public void createBooking(Booking booking) throws SQLException {
        manageBookings.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws
            RemoteException, SQLException {
        manageVehicles.editVehicleInfo(vehicle, newVehicle);
    }

    public ArrayList<Booking> viewAllBookings() throws SQLException
    {
        return manageBookings.viewAllBookings();
    }

    @Override public void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException {
        manageBookings.editBookingInfo(booking, newBooking);
    }
}
