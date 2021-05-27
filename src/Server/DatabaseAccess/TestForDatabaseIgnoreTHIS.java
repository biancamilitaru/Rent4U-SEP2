package Server.DatabaseAccess;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Model.Status;
import Client.Model.Vehicle;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestForDatabaseIgnoreTHIS {
    public static void main(String[] args) throws SQLException, RemoteException {
        ManageVehicles manageVehicles = new Rent4UDAO();
        Vehicle vehicle1 = new Vehicle("dd34", 5, "type", "make", "model",
                2010, "manual", "petrol", 10, 50);
        Vehicle vehicle2 = new Vehicle("dd34", 5, "NEWtype", "make", "model",
                2010, "manual", "petrol", 10, 50);
        //manageVehicles.addNewVehicle(vehicle1);
        //manageVehicles.editVehicleInfo(vehicle1, vehicle2);
        ManageBookings manageBookings = new Rent4UDAO();
        GregorianCalendar start_time = new GregorianCalendar(2021, 5, 26, 8, 30);
        GregorianCalendar end_time = new GregorianCalendar(2021, 5, 27, 10,00);
        Booking booking1 = new Booking(1,1000000000, "CHANGED", start_time, end_time, 200);
        //manageBookings.createBooking(booking1);
        Status status = new Status(start_time,end_time, "In Service");
        //manageVehicles.setStatus(vehicle1, status);
        Booking booking2 = new Booking(1000000000, "dd34", start_time, end_time, 200);
        //manageBookings.editBookingInfo(booking1, booking2);
        //System.out.println(manageBookings.viewAllBookings());
        GregorianCalendar date_of_birth = new GregorianCalendar(2000,9,9);
        Customer customer = new Customer("alex", "alexandri", date_of_birth, "email",
                "password", "5678", "license", "2000000000");
        ManageCustomers manageCustomers = new Rent4UDAO();
        //manageCustomers.addCustomer(customer);
        System.out.println(manageCustomers.viewAllCustomers());
    }
}
