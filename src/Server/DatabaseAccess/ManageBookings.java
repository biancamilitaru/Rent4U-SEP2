package Server.DatabaseAccess;

import Client.Model.Booking;
import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ManageBookings
{
  void createBooking(Booking booking) throws SQLException;
  ArrayList<Booking> viewAllBookings() throws SQLException;
  void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
  void deleteBooking(Booking booking) throws RemoteException, SQLException;
  ArrayList<Booking> getPersonalBookings(Customer customer) throws RemoteException, SQLException;
  void editPersonalBooking(Booking booking, Booking newBooking) throws RemoteException, SQLException;
}
