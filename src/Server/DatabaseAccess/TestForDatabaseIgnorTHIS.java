package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class TestForDatabaseIgnorTHIS {
    public static void main(String[] args) throws SQLException {
        ManageVehicles manageVehicles = new Rent4UDAO();
        Vehicle vehicle = new Vehicle("A78", 7, "type", "make",
                "model", 2009, "automatic", "electric", 9, 100);
        //manageVehicles.addNewVehicle(vehicle);

        ArrayList<Vehicle> vehicles = manageVehicles.viewAllVehicles();
        for (int i = 0; i < vehicles.size(); i++)
        {
            System.out.println(vehicles.get(i).toString());
        }

    }
}
