package Client.Networking;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Status;
import Client.Model.Vehicle;
import Shared.ClientCallBack;
import Shared.RMIServer;

import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ClientImpl implements Client, ClientCallBack

{

    private RMIServer server;
    private PropertyChangeSupport support;

    public ClientImpl()
    {
        try
        {
            UnicastRemoteObject.exportObject(this, 0);
            support = new PropertyChangeSupport(this);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void startClient()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("Server");
        }
        catch (RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void addVehicle(Vehicle vehicle)
        throws SQLException, RemoteException
    {
        server.addVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getListOfVehicles() throws SQLException, RemoteException {
       return server.viewAllVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException {
        server.setStatus(vehicle,status);
    }

    @Override public void createBooking(Booking booking) throws RemoteException, SQLException {
        server.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, Vehicle newVehivle)
            throws RemoteException, SQLException {
        server.editVehicleInfo(vehicle,newVehivle);
    }

    @Override public ArrayList<Booking> getListOfBookings()
        throws SQLException, RemoteException
    {
        return server.viewAllBookings();
    }

    @Override public void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException {
        server.editBookingInfo(booking,newBooking);
    }

    @Override public void createCustomerAccount(String firstName,
        String lastName, GregorianCalendar dateOfBirth, String email,
        String password, String phoneNumber, String drivingLicenseNumber,
        String cpr_number)
    {
        server.createCustomerAccount(firstName,lastName,dateOfBirth,email,password,phoneNumber,drivingLicenseNumber,cpr_number);
    }

    @Override public ArrayList<Customer> getCustomers()
        throws SQLException, RemoteException
    {
        return server.getCustomers();
    }

    @Override
    public ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws RemoteException, SQLException {
        return server.getFreeVehicles(startDate, endDate, type);
    }
}
