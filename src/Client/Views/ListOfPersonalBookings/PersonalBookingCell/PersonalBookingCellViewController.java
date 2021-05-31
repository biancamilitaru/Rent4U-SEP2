package Client.Views.ListOfPersonalBookings.PersonalBookingCell;

import Client.Model.Booking;
import Client.Model.Customer;
import Client.Views.ListOfBookingsView.ListOfBookingsViewController;
import Client.Views.ListOfPersonalBookings.ListOfPersonalBookingsViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PersonalBookingCellViewController extends ListCell<Booking>
{
  private FXMLLoader mLLoader;
  @FXML AnchorPane anchorPane;

  @FXML Label bookingIdLabel;
  @FXML Label customerIdLabel;
  @FXML Label licensePlateLabel;
  @FXML Label startDateLabel;
  @FXML Label endDateLabel;
  @FXML Label priceLabel;

  private ListOfPersonalBookingsViewController listOfPersonalBookingsViewController;
  public Booking booking;
  private Customer customer;

  public PersonalBookingCellViewController(ListOfPersonalBookingsViewController listOfPersonalBookingsViewController)
  {
    this.listOfPersonalBookingsViewController = listOfPersonalBookingsViewController;
  }

  @Override protected void updateItem(Booking booking, boolean empty)
  {
    int id = Integer.parseInt(customer.getCpr_number());
    if (booking.getIdOfCustomer() == id)
    {
      this.booking=booking;
      super.updateItem(booking, empty);

      if (empty || booking == null)
      {
        setText(null);
        setGraphic(null);
      }
      else
      {
        if (mLLoader == null)
        {
          mLLoader = new FXMLLoader(getClass().getResource("BookingViewCell.fxml"));
          mLLoader.setController(this);

          try
          {
            anchorPane = mLLoader.load();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }

        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy \n hh:mm");

        bookingIdLabel.setText(String.valueOf(booking.getBooking_id()));
        customerIdLabel.setText(String.valueOf(booking.getIdOfCustomer()));
        licensePlateLabel.setText(booking.getLicencePlate());
        dateFormat.setCalendar(booking.getStartTime());
        startDateLabel.setText(dateFormat.format(booking.getStartTime().getTime()));
        dateFormat.setCalendar(booking.getEndTime());
        endDateLabel.setText(dateFormat.format(booking.getEndTime().getTime()));
        priceLabel.setText(String.valueOf(booking.getPrice()));

        setText(null);

        setGraphic(this.anchorPane);
      }
    }
  }

  public void onClickedEditButton() throws SQLException, RemoteException
  {
    listOfPersonalBookingsViewController.onEdit(booking);
  }

  public void onClickedDeleteButton() throws RemoteException, SQLException
  {
    listOfPersonalBookingsViewController.onDelete(booking);
  }

}