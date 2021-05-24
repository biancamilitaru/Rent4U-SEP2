package Shared;

import Client.Model.Vehicle;
import Util.Request;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIServer extends Remote
{
    void startServer() throws RemoteException, AlreadyBoundException;
    void newRequest(Request request) throws RemoteException;
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getListOfVehicles();
}
