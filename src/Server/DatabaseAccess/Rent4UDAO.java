package Server.DatabaseAccess;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Status;
import Client.Model.Vehicle;


import java.rmi.RemoteException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Rent4UDAO implements ManageVehicles,ManageBookings,ManageCustomers
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO status(license_plate, " +
                    "start_time, end_time, status) VALUES (?, ?, ?, ?)");
            statement.setString(1, vehicle.getLicensePlate());
            Timestamp start_time = new Timestamp(status.getStartDate().getTimeInMillis());
            statement.setTimestamp(2, start_time);
            Timestamp end_time = new Timestamp(status.getEndDate().getTimeInMillis());
            statement.setTimestamp(3, end_time);
            statement.setString(4, status.getStatus());
            statement.executeUpdate();
        }
    }

    @Override public void editVehicleInfo(Vehicle vehicle, Vehicle newVehicle) throws SQLException {
        try(Connection connection = getConnection()){

            PreparedStatement statement = connection.prepareStatement("UPDATE vehicle SET licence_plate = ? WHERE licence_plate = ?");
            statement.setString(1, newVehicle.getLicensePlate());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET type = ? WHERE licence_plate = ?");
            statement.setString(1, newVehicle.getType());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET make = ? WHERE licence_plate = ?");
            statement.setString(1, newVehicle.getMake());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET model = ? WHERE licence_plate = ?");
            statement.setString(1, newVehicle.getModel());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET year = ? WHERE licence_plate = ?");
            statement.setInt(1, newVehicle.getYear());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET engine_power = ? WHERE licence_plate = ?");
            statement.setInt(1, newVehicle.getEnginesPower());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET type_of_gearbox = ? WHERE licence_plate = ?");
            if(newVehicle.getTypeOfGearbox().equalsIgnoreCase("automatic"))
                statement.setString(1, "Automatic");
            else
                statement.setString(1, "Manual");
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET number_of_seats = ? WHERE licence_plate = ?");
            statement.setInt(1, newVehicle.getNumberOfSeats());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET type_of_fuel = ? WHERE licence_plate = ?");
            if(newVehicle.getTypeOfFuel().equalsIgnoreCase("petrol"))
                statement.setString(1, "Petrol");
            else if(newVehicle.getTypeOfFuel().equalsIgnoreCase("diesel"))
                statement.setString(1, "Diesel");
            else if(newVehicle.getTypeOfFuel().equalsIgnoreCase("electric"))
                statement.setString(1, "Electric");
            else
                statement.setString(1, "Hybrid");
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE Vehicle SET price = ? WHERE licence_plate = ?");
            statement.setDouble(1, newVehicle.getPrice());
            statement.setString(2, vehicle.getLicensePlate());
            statement.executeUpdate();
        }
    }

    @Override public void deleteVehicle(Vehicle vehicle)
        throws RemoteException, SQLException
    {

    }

    @Override public void createBooking(Booking booking) throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO booking(start_time," +
                    "end_time, cpr_of_customer, licence_plate, total_price) VALUES (?, ?, ?, ?, ?)");
            Timestamp start_time = new Timestamp(booking.getStartTime().getTimeInMillis());
            statement.setTimestamp(1, start_time);
            Timestamp end_time = new Timestamp(booking.getStartTime().getTimeInMillis());
            statement.setTimestamp(2, end_time);
            statement.setInt(3, booking.getIdOfCustomer());
            statement.setString(4, booking.getLicencePlate());
            statement.setDouble(5, booking.getPrice());
            statement.executeUpdate();
        }
    }

    @Override public ArrayList<Booking> viewAllBookings() throws SQLException
    {
        ArrayList<Booking> bookings = new ArrayList<>();
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM booking");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                bookings.add(getBooking(resultSet));
            }
        }
        return bookings;
    }

    private Booking getBooking(ResultSet resultSet) throws SQLException
    {
        int booking_id = resultSet.getInt(1);
        Timestamp start_time_timestamp = resultSet.getTimestamp(2);
        LocalDateTime start_time_local = start_time_timestamp.toLocalDateTime();
        GregorianCalendar start_time = new GregorianCalendar(start_time_local.getYear(), start_time_local.getMonthValue(),
                start_time_local.getDayOfMonth(), start_time_local.getHour(), start_time_local.getMinute());
        Timestamp end_time_timestamp = resultSet.getTimestamp(3);
        LocalDateTime end_time_local = end_time_timestamp.toLocalDateTime();
        GregorianCalendar end_time = new GregorianCalendar(end_time_local.getYear(), end_time_local.getMonthValue(),
                end_time_local.getDayOfMonth(), end_time_local.getHour(), end_time_local.getMinute());
        int id_of_customer = resultSet.getInt(4);
        String license_plate = resultSet.getString(5);
        double price = resultSet.getDouble(6);
        return new Booking(booking_id, id_of_customer, license_plate, start_time, end_time, price);
    }

    @Override public void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE booking SET start_time = ? " +
                    "WHERE booking_id = ?");
            Timestamp start_time = new Timestamp(newBooking.getStartTime().getTimeInMillis());
            statement.setTimestamp(1, start_time);
            statement.setInt(2, booking.getBooking_id());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE booking SET end_time = ? WHERE booking_id = ?");
            Timestamp end_time = new Timestamp(newBooking.getEndTime().getTimeInMillis());
            statement.setTimestamp(1, end_time);
            statement.setInt(2, booking.getBooking_id());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE booking SET cpr_of_customer = ? WHERE booking_id = ?");
            statement.setInt(1, newBooking.getIdOfCustomer());
            statement.setInt(2, booking.getBooking_id());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE booking SET licence_plate = ? WHERE booking_id = ?");
            statement.setString(1, newBooking.getLicencePlate());
            statement.setInt(2, booking.getBooking_id());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE booking SET total_price = ? WHERE booking_id = ?");
            statement.setDouble(1, newBooking.getPrice());
            statement.setInt(2, booking.getBooking_id());
            statement.executeUpdate();
        }
    }

    @Override public void deleteBooking(Booking booking)
        throws RemoteException, SQLException
    {

    }

    @Override public void createCustomerAccount(String firstName,
        String lastName, GregorianCalendar dateOfBirth, String email,
        String password, String phoneNumber, String drivingLicenseNumber,
        String cpr_number)
    {

    }

    @Override public ArrayList<Customer> getCustomers() throws SQLException
    {
        return null;
    }

    @Override public void editCustomerInfo(String firstName, String lastName,
        GregorianCalendar dateOfBirth, String email, String password,
        String phoneNumber, String drivingLicenseNumber, String cpr_number)
        throws RemoteException, SQLException
    {

    }

    @Override public void deleteCustomer(Customer customer)
        throws RemoteException, SQLException
    {

    }
}
