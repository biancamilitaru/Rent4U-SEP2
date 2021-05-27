package Client.Model;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ClientModel
{
  boolean login (String s);
  void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
  ArrayList<Vehicle> getVehicles() throws SQLException, RemoteException;
  void setStatus(Vehicle vehicle, Status status) throws RemoteException, SQLException;
  void createBooking(Booking booking) throws RemoteException, SQLException;
  void editVehicleInfo(Vehicle vehicle,Vehicle newVehicle) throws RemoteException, SQLException;
  ArrayList<Booking> getBookings() throws RemoteException, SQLException;
  void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
  void createCustomerAccount(Customer customer) throws RemoteException, SQLException;
  ArrayList<Customer> getCustomers() throws RemoteException, SQLException;;
  ArrayList<Vehicle> getFreeVehicles(GregorianCalendar startDate, GregorianCalendar endDate, String type) throws RemoteException, SQLException;
  void editCustomerInfo(String firstName, String lastName, GregorianCalendar dateOfBirth, String email, String password, String phoneNumber,
      String drivingLicenseNumber, String cpr_number) throws RemoteException, SQLException;;
}
