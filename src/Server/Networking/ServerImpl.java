package Server.Networking;

import Client.Model.Vehicle;
import Server.Model.ServerModelManager;
import Shared.ClientCallBack;
import Shared.RMIServer;
import Util.Request;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerImpl implements RMIServer
{
    private ServerModelManager serverModelManager;
    private Map<ClientCallBack, PropertyChangeListener> listeners = new HashMap<>();

    public ServerImpl(ServerModelManager serverModelManager) throws RemoteException
    {
        this.serverModelManager = serverModelManager;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException
    {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
    }

    @Override
    public void newRequest(Request request)
    {

    }

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException {
        serverModelManager.addVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getListOfVehicles()
    {
        return serverModelManager.getListOfVehicles();
    }
}
