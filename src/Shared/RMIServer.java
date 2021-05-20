package Shared;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
    void startServer() throws RemoteException, AlreadyBoundException;
    void registerClient(ClientCallBack clientCallBack) throws RemoteException;
    void unregisterClient(ClientCallBack clientCallBack) throws RemoteException;
}
