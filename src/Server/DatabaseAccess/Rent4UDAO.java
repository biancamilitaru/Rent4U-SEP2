package Server.DatabaseAccess;

import Client.Model.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private Rent4UDAO() throws SQLException
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Vehicle(licence_plate, type, make, model," +
                    " year, engine_power, type_of_gearbox, number_of_seats, type_of_fuel, price)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, vehicle.getLicensePlate());
            statement.setString(2, vehicle.getType());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setInt(5, vehicle.getYear());
            statement.setInt(6, vehicle.getEnginesPower());
            statement.setString(7, vehicle.getTypeOfGearbox());
            statement.setInt(8, vehicle.getNumberOfSeats());
            statement.setString(9, vehicle.getTypeOfFuel());
            statement.setInt(10, vehicle.getPrice());
        }
    }

    public Book create(String isbn, String title, int yearOfPublishing, Author author) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO Book(isbn, title, yearOfPublishing, author_id)" +
                            " VALUES (?, ?, ?, ?);");
            statement.setString(1, isbn);
            statement.setString(2, title);
            statement.setInt(3, yearOfPublishing);
            statement.setInt(4, author.getId());
            statement.executeUpdate();
            return new Book(isbn, title, yearOfPublishing, author);
        }
    }
}
