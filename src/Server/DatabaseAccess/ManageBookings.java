package Server.DatabaseAccess;

import Client.Model.Booking;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ManageBookings
{
  void createBooking(Booking booking) throws SQLException;
  ArrayList<Booking> viewAllBookings() throws SQLException;
  void editBookingInfo(Booking booking, Booking newBooking) throws RemoteException, SQLException;
}
