package Shared;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
    void startServer() throws RemoteException, AlreadyBoundException;
}
