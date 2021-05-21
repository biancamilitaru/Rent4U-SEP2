package Server.Model;

import Client.Model.Vehicle;

import java.sql.SQLException;


public interface ServerModel
{
    void addVehicle(Vehicle vehicle) throws SQLException;
}


