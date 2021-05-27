package Client.Model;

import Client.Networking.Client;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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

    @Override public void createBooking(Booking booking) throws RemoteException, SQLException {
        client.createBooking(booking);
    }

    @Override public void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle)
            throws RemoteException, SQLException {
        client.editVehicleInfo(vehicle, newVehicle);
    }

    @Override public ArrayList<Booking> getBookings()
        throws SQLException, RemoteException
    {
        return client.getListOfBookings();
    }

    @Override public void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException {
         client.editBookingInfo(booking,newBooking);
    }

    @Override public void createCustomerAccount(String firstName,
        String lastName, GregorianCalendar dateOfBirth, String email,
        String password, String phoneNumber, String drivingLicenseNumber,
        String cpr_number)
    {
        client.createCustomerAccount(firstName,lastName,dateOfBirth,email,password,phoneNumber,drivingLicenseNumber,cpr_number);
    }

    @Override public ArrayList<Customer> getCustomers()
        throws SQLException, RemoteException, SQLException
    {
        return client.getCustomers();
    }

    @Override public void editCustomerInfo(String firstName, String lastName,
        GregorianCalendar dateOfBirth, String email, String password,
        String phoneNumber, String drivingLicenseNumber, String cpr_number)
        throws RemoteException, SQLException
    {
        client.editCustomerInfo(firstName,lastName,dateOfBirth,email,password,phoneNumber,drivingLicenseNumber,cpr_number);

    }

}
