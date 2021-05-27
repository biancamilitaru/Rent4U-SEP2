package Server.DatabaseAccess;

import Client.Model.Status;
import Client.Model.Vehicle;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ManageVehicles
{
    void addNewVehicle(Vehicle vehicle) throws SQLException;
    ArrayList<Vehicle> viewAllVehicles() throws SQLException;
    void setStatus(Vehicle vehicle, Status status) throws SQLException;
    void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws SQLException;
    ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws RemoteException, SQLException;
  void deleteVehicle(Vehicle vehicle) throws RemoteException, SQLException;
}
