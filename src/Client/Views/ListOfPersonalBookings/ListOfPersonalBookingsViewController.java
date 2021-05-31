package Client.Views.ListOfPersonalBookings;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Customer;
import Client.ViewModel.ListOfPersonalBookingsViewModel;
import Client.Views.ListOfBookingsView.BookingViewCell.BookingListViewCell;
import Client.Views.ListOfPersonalBookings.PersonalBookingCell.PersonalBookingCellViewController;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

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
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.listOfPersonalBookingsViewModel = viewModelFactory.getListOfPersonalBookingViewModel();
  }

  public void setCustomer(Customer customer) throws SQLException, RemoteException {
    this.customer = customer;
    getBookingData(listOfPersonalBookingsViewModel.getPersonalBookings(customer));
    listView.setItems(bookingsObservableList);
    listView.setCellFactory(vehicleListView -> new PersonalBookingCellViewController(this));

    listView.setFixedCellSize(73);
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
    //viewHandler.openEditPersonalBooking(booking);
  }

  public void onDelete(Booking booking) throws RemoteException, SQLException
  {
    listOfPersonalBookingsViewModel.deletePersonalBooking(booking);
    viewHandler.openPersonalBookings(customer);
  }
}
