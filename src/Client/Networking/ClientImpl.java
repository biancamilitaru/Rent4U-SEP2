package Client.Networking;

import Client.Model.Vehicle;
import Server.Model.Status;
import Shared.ClientCallBack;
import Shared.RMIServer;
import Util.Answer;
import Util.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override public void newRequest(Request request)
    {
        try
        {
            server.newRequest(request);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void newAnswer(Answer answer)
    {

    }

    @Override public void addVehicle(Vehicle vehicle)
        throws SQLException, RemoteException
    {
        server.addVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getListOfVehicles() throws SQLException, RemoteException {
       return server.viewAllVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws RemoteException {
        server.setStatus(vehicle,status);
    }
}
