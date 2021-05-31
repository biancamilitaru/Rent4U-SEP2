package Client.Views.ListOfBookingsView.BookingViewCell;

import Client.Core.ViewHandler;
import Client.Model.Booking;
import Client.Views.ListOfBookingsView.ListOfBookingsViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class BookingListViewCell extends ListCell<Booking>
{
  private FXMLLoader mLLoader;
  @FXML AnchorPane anchorPane;

  @FXML Label bookingIdLabel;
  @FXML Label customerIdLabel;
  @FXML Label licensePlateLabel;
  @FXML Label startDateLabel;
  @FXML Label endDateLabel;
  @FXML Label priceLabel;

  private ListOfBookingsViewController listOfBookingsViewController;
  public Booking booking;

  public BookingListViewCell(ListOfBookingsViewController listOfBookingsViewController){
    this.listOfBookingsViewController=listOfBookingsViewController;
  }

  @Override protected void updateItem(Booking booking, boolean empty)
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

  public void onClickedEdit() throws SQLException, RemoteException
  {
    listOfBookingsViewController.onEdit(booking);
  }

  public void onClickedDeleteButton() throws RemoteException, SQLException
  {
    listOfBookingsViewController.onDelete(booking);
  }

}
