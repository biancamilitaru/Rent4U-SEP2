package Client.Views.ListOfBookingsView.BookingViewCell;

import Client.Model.Booking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class BookingListViewCell extends ListCell<Booking>
{
  private FXMLLoader mLLoader;
  @FXML AnchorPane anchorPane;

  @FXML Label bookingIdLabel;
  @FXML Label customerIdLabel;
  @FXML Label licensePlateLabel;
  @FXML Label startDateLabel;
  @FXML Label startTimeLabel;
  @FXML Label endDateLabel;
  @FXML Label endTimeLabel;
  @FXML Label priceLabel;

  @Override protected void updateItem(Booking booking, boolean empty)
  {
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
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat timeFormat = new SimpleDateFormat("H:m");

      bookingIdLabel.setText(String.valueOf(booking.getBooking_id()));
      customerIdLabel.setText(String.valueOf(booking.getIdOfCustomer()));
      licensePlateLabel.setText(booking.getLicencePlate());
      startDateLabel.setText(dateFormat.format(booking.getStartTime()));
      startTimeLabel.setText(timeFormat.format(booking.getStartTime()));
      endDateLabel.setText(dateFormat.format(booking.getEndTime()));
      endTimeLabel.setText(timeFormat.format(booking.getEndTime()));
      priceLabel.setText(String.valueOf(booking.getPrice()));

      setText(null);

      setGraphic(this.anchorPane);
    }
  }

}
