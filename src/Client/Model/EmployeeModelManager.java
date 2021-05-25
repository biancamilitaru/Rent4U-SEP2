package Client.Model;

import Client.Networking.Client;
import Server.Model.Date;
import Server.Model.Status;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModelManager implements ClientModel
{

    private Client client;
    private String password;

    public EmployeeModelManager(Client client)
    {
        this.client = client;
        client.startClient();
        password = "default";
    }

    @Override public boolean login(String s)
    {
        return s.equals(password);
    }

    @Override public void addVehicle(Vehicle vehicle) throws SQLException, RemoteException {
        client.addVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
        return client.getListOfVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException {
        client.setStatus(vehicle,status);
    }

    @Override public void createBooking(Booking booking) throws RemoteException {
        client.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, String licensePlate,
        int enginePower, String type, String make, String model, int year,
        String gearBoxType, String fuelType, int numberOfSeats, double price)
        throws RemoteException
    {
        client.editVehicleInfo(vehicle,licensePlate,enginePower,type,make,model,year,gearBoxType,fuelType,numberOfSeats,price);
    }

    @Override public ArrayList<Booking> getBookings()
        throws SQLException, RemoteException
    {
        return client.getListOfBookings();
    }

    @Override public void editBookingInfo(Booking booking, int idOfCustomer,
        String licencePlate, Client.Model.Date startTime,
        Client.Model.Date endTime, int price) throws RemoteException
    {

    }

}
