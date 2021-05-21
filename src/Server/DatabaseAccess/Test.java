package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        ManageVehicles manageVehicles = new Rent4UDAO();
        Vehicle vehicle = new Vehicle("A78", 7, "type", "make",
                "model", 2009, "automatic", "electric", 9, 100);
        manageVehicles.addNewVehicle(vehicle);
    }
}
