package Server.DatabaseAccess;

import Client.Model.Booking;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageBookings
{
  void createBooking(Booking booking);
  ArrayList<Booking> viewAllBookings() throws SQLException;
}
