package Server.Networking;

import Server.Model.ServerModelManager;
import Shared.ClientCallBack;
import Shared.RMIServer;
import Util.Answer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
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
    public void registerClient(ClientCallBack clientCallBack) throws RemoteException
    {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    clientCallBack.newAnswer((Answer) evt.getNewValue());
                } catch (RemoteException e)
                {
                    e.printStackTrace();
                    serverModelManager.removeListener("NewAnswer", this);
                }
            }
        };
        listeners.put(clientCallBack, listener);
        System.out.println("New listener");
        serverModelManager.addListener("NewAnswer", listener);

    }

    @Override
    public void unregisterClient(ClientCallBack clientCallBack) throws RemoteException
    {
        PropertyChangeListener listener = listeners.get(clientCallBack);
        if (listener != null)
        {
            serverModelManager.removeListener(listener);
        }
    }
}
