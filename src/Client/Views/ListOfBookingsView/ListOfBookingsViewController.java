package Client.Views.ListOfBookingsView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Vehicle;
import Client.ViewModel.ListOfBookingsViewModel;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.AddBookingView.VehicleViewCell.VehicleListViewCell;
import Client.Views.ListOfBookingsView.BookingViewCell.BookingListViewCell;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfBookingsViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfBookingsViewModel listOfBookingsViewModel;

  @FXML ListView<Booking> listView;

  public final ObservableList<Booking> bookingsObservableList = FXCollections.observableArrayList();


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    this.listOfBookingsViewModel = viewModelFactory.getListOfBookingsViewModel();
    getBookingData(listOfBookingsViewModel.getBookings());

    listView.setItems(bookingsObservableList);
    listView.setCellFactory(vehicleListView -> new BookingListViewCell());

    listView.setFixedCellSize(73);
  }

  public void onAddBookingButton(ActionEvent evt)
      throws SQLException, RemoteException
  {
    viewHandler.openAddBooking();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public ObservableList<Booking> getBookingData(
      ArrayList<Booking> bookingsArrayList)
  {
    for (int x = 0; x<bookingsArrayList.size(); x++){
      bookingsObservableList.add(bookingsArrayList.get(x));
    }
    return bookingsObservableList;
  }

}
