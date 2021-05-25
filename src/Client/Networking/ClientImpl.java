package Client.Networking;

import Client.Model.Booking;
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

    @Override public void createBooking(Booking booking) throws RemoteException {
        server.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, String licensePlate,
        int enginePower, String type, String make, String model, int year,
        String gearBoxType, String fuelType, int numberOfSeats, double price)
        throws RemoteException
    {
        server.editVehicleInfo(vehicle,licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType,numberOfSeats,price);
    }

    @Override public ArrayList<Booking> getListOfBookings()
        throws SQLException, RemoteException
    {
        return server.viewAllBookings();
    }

    @Override public void editBookingInfo(Booking booking, int idOfCustomer,
        String licencePlate, GregorianCalendar startTime,
        GregorianCalendar endTime, int price) throws RemoteException
    {
        server.editBookingInfo(booking,idOfCustomer,licencePlate,startTime,endTime,price);
    }
}
