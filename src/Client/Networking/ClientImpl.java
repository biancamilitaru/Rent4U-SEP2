package Client.Networking;

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
        } catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void startClient()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("Server");
            server.registerClient(this);
        } catch (RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void newRequest(Request request) {

    }

    @Override
    public void newAnswer(Answer answer) {

    }

    @Override
    public void addListener(String name, PropertyChangeListener listener) {

    }

    @Override
    public void addListener(PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String name, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {

    }
}
