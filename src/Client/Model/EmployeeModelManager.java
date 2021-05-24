package Client.Model;

import Client.Networking.Client;
import Server.Model.Status;
import Util.Answer;
import Util.Request;

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

    @Override public void newRequest(Request request)
    {
        client.newRequest(request);
    }

    @Override
    public void newAnswer(Answer answer)
    {

    }

    @Override public void addVehicle(Vehicle vehicle) throws SQLException, RemoteException {
        client.addVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException {
        return client.getListOfVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws RemoteException {
        client.setStatus(vehicle,status);
    }

    @Override public void createBooking(Booking booking)
    {
        client.createBooking(booking);
    }
}
