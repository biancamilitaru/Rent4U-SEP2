package Client.Views.ListOfBookingsView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Booking;
import Client.Model.Vehicle;
import Client.ViewModel.ListOfBookingsViewModel;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfBookingsViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfBookingsViewModel listOfBookingsViewModel;

  @FXML TableView table = new TableView();

  public final ObservableList<Booking> tableObservableList = FXCollections.observableArrayList();


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException
  {
    this.viewHandler = viewHandler;
    this.listOfBookingsViewModel = viewModelFactory.getListOfBookingsViewModel();
    addEditButton();
    getBookingData(listOfBookingsViewModel.getBookings());
    table.setItems(tableObservableList);
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
      tableObservableList.add(bookingsArrayList.get(x));
    }
    return tableObservableList;
  }



  private void addEditButton() {
    TableColumn<Booking, Void> colBtn = new TableColumn("Edit");

    Callback<TableColumn<Booking, Void>, TableCell<Booking, Void>> cellFactory = new Callback<TableColumn<Booking, Void>, TableCell<Booking, Void>>() {
      @Override
      public TableCell<Booking, Void> call(final TableColumn<Booking, Void> param) {
        final TableCell<Booking, Void> cell = new TableCell<Booking, Void>() {

          private final Button btn = new Button("Edit");

          {
            btn.setOnAction((ActionEvent event) -> {
              Booking data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              try {
                viewHandler.openEditBooking(data);
              } catch (SQLException throwables) {
                throwables.printStackTrace();
              } catch (RemoteException e) {
                e.printStackTrace();
              }
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };

    colBtn.setCellFactory(cellFactory);
    colBtn.setPrefWidth(82.5);

    table.getColumns().add(colBtn);

  }

}
