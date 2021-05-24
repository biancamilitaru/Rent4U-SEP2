package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Rent4UDAO implements ManageVehicles
{
    //We are using singleton for this class because we want to have only one instance in our program
    private static Rent4UDAO instance;
    public static synchronized Rent4UDAO getInstance() throws SQLException
    {
        if(instance == null)
            instance = new Rent4UDAO();
        return instance;
    }

    public Rent4UDAO() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=rent4u",
                "postgres","maria5561");
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) throws  SQLException
    {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Vehicle(licence_plate, type, make, model,"
                    + "year, engine_power, type_of_gearbox, number_of_seats, type_of_fuel, price)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, vehicle.getLicensePlate());
            statement.setString(2, vehicle.getType());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setInt(5, vehicle.getYear());
            statement.setInt(6, vehicle.getEnginesPower());
            if(vehicle.getTypeOfGearbox().equalsIgnoreCase("automatic"))
                statement.setString(7, "Automatic");
            else
                statement.setString(7, "Manual");
            statement.setInt(8, vehicle.getNumberOfSeats());
            if(vehicle.getTypeOfFuel().equalsIgnoreCase("petrol"))
                statement.setString(9, "Petrol");
            else if(vehicle.getTypeOfFuel().equalsIgnoreCase("diesel"))
                statement.setString(9, "Diesel");
            else if(vehicle.getTypeOfFuel().equalsIgnoreCase("electric"))
                statement.setString(9, "Electric");
            else
                statement.setString(9, "Hybrid");
            statement.setDouble(10, vehicle.getPrice());
            statement.executeUpdate();
        }
    }

    @Override public ArrayList<Vehicle> getListOfVehicles()
    {
        return null;
    }

}
