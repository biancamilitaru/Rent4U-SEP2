package Server.Model;

import Client.Model.Vehicle;
import Server.DatabaseAccess.ManageVehicles;
import Server.DatabaseAccess.Rent4UDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
    private ManageVehicles manageVehicles;

    public ServerModelManager() throws SQLException {
        manageVehicles = new Rent4UDAO();
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException {
        manageVehicles.addNewVehicle(vehicle);
    }

    @Override public ArrayList<Vehicle> getListOfVehicles()
    {
        return manageVehicles.getListOfVehicles();
    }

    @Override public void setStatus(Vehicle vehicle, Status status)
    {
        manageVehicles.setStatus(vehicle,status);
    }
}
