package Client.Views.ListOfPersonalBookings;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Customer;
import Client.ViewModel.ListOfPersonalBookingsViewModel;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfPersonalBookingsViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfPersonalBookingsViewModel listOfPersonalBookingsViewModel;
  @FXML ListView<Booking> listView;
  private Customer customer;

  public final ObservableList<Booking> bookingsObservableList = FXCollections.observableArrayList();


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    this.listOfPersonalBookingsViewModel = viewModelFactory.getListOfPersonalBookingViewModel()
    getBookingData(listOfPersonalBookingsViewModel.getPersonalBookings(customer));
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public void onAddBookingButton(ActionEvent evt) throws SQLException, RemoteException
  {
    viewHandler.openAddBooking();
  }

  public void onMenuButton(javafx.event.ActionEvent evt)
      throws SQLException, RemoteException
  {
    viewHandler.openMenuCustomerView(customer);
  }

  public ObservableList<Booking> getBookingData(
      ArrayList<Booking> bookingsArrayList)
  {
    for (int x = 0; x<bookingsArrayList.size(); x++){
      bookingsObservableList.add(bookingsArrayList.get(x));
    }
    return bookingsObservableList;
  }

  public void onEdit(Booking booking) throws SQLException, RemoteException
  {
    viewHandler.openEditPersonalBooking(booking);
  }

  public void onDelete(Booking booking) throws RemoteException, SQLException
  {
    listOfPersonalBookingsViewModel.deleteBooking(booking);
    viewHandler.openPersonalBookings(customer);
  }

}
