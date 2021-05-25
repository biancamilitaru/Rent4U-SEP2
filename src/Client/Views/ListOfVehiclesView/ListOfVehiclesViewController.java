package Client.Views.ListOfVehiclesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.Model.Vehicle;
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

public class ListOfVehiclesViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;

  @FXML TableView table = new TableView();

  public final ObservableList<Vehicle> tableObservableList = FXCollections.observableArrayList();


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) throws SQLException, RemoteException {
    this.viewHandler = viewHandler;
    this.listOfVehiclesViewModel = viewModelFactory.getListOfVehiclesViewModel();
    addStatusButton();
    addEditButton();
    getVehicleData(listOfVehiclesViewModel.getVehicles());
    table.setItems(tableObservableList);
  }

  public void onAddVehicleButton(ActionEvent evt)
  {
    viewHandler.openAddVehicle();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public ObservableList<Vehicle> getVehicleData(ArrayList<Vehicle> vehiclesArrayList)
  {
    for (int x = 0; x<vehiclesArrayList.size(); x++){
      tableObservableList.add(vehiclesArrayList.get(x));
    }
    return tableObservableList;
}

  private void addStatusButton() {
    TableColumn<Vehicle, Void> colBtn = new TableColumn("Status");

    Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>> cellFactory = new Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>>() {
      @Override
      public TableCell<Vehicle, Void> call(final TableColumn<Vehicle, Void> param) {
        final TableCell<Vehicle, Void> cell = new TableCell<Vehicle, Void>() {

          private final Button btn = new Button("Change Status");

          {
            btn.setOnAction((ActionEvent event) -> {
              Vehicle data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              viewHandler.openSetStatusView(data);

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

  private void addEditButton() {
    TableColumn<Vehicle, Void> colBtn = new TableColumn("Edit");

    Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>> cellFactory = new Callback<TableColumn<Vehicle, Void>, TableCell<Vehicle, Void>>() {
      @Override
      public TableCell<Vehicle, Void> call(final TableColumn<Vehicle, Void> param) {
        final TableCell<Vehicle, Void> cell = new TableCell<Vehicle, Void>() {

          private final Button btn = new Button("Edit");

          {
            btn.setOnAction((ActionEvent event) -> {
              Vehicle data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              //Add method that will open a window with data
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
