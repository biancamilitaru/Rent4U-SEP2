package Server.DatabaseAccess;

import Client.Model.Booking;
import Client.Model.Vehicle;
import Server.Model.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Rent4UDAO implements ManageVehicles,ManageBookings
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

    @Override
    public ArrayList<Vehicle> viewAllVehicles() throws SQLException
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vehicle");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                vehicles.add(getVehicle(resultSet));
            }
        }
        return vehicles;
    }

    private Vehicle getVehicle(ResultSet resultSet) throws SQLException {
        String licencePlate = resultSet.getString(1);
        String type = resultSet.getString(2);
        String make = resultSet.getString(3);
        String model = resultSet.getString(4);
        int year = resultSet.getInt(5);
        int enginePower = resultSet.getInt(6);
        String typeOfGearBox = resultSet.getString(7);
        int numberOfSeats = resultSet.getInt(8);
        String typeOfFuel = resultSet.getString(9);
        double price = resultSet.getDouble(10);
        return new Vehicle(licencePlate, enginePower, type, make, model, year, typeOfGearBox, typeOfFuel, numberOfSeats, price);
    }

    @Override public void setStatus(Vehicle vehicle, Status status) throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Status(license_plate, " +
                    "start_time, end_time, status) VALUES (?, ?, ?, ?)");
        }
    }

    @Override public void editVehicleInfo(Vehicle vehicle, String licensePlate,
        int enginePower, String type, String make, String model, int year,
        String gearBoxType, String fuelType, int numberOfSeats, double price)
    {

    }

    @Override public void createBooking(Booking booking)
    {

    }
}
