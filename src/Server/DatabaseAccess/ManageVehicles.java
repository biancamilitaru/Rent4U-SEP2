package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.SQLException;

public interface ManageVehicles
{
    void addNewVehicle(Vehicle vehicle) throws SQLException;
}
