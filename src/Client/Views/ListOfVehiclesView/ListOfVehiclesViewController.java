package Client.Views.ListOfVehiclesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.text.TableView;

public class ListOfVehiclesViewController implements ViewController
{

  private ViewHandler viewHandler;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;

  @FXML TableView table = new TableView();
  @FXML




  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.listOfVehiclesViewModel = viewModelFactory.getListOfVehiclesViewModel();
  }

  public void onAddVehicleButton(ActionEvent evt)
  {
    viewHandler.openAddVehicle();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  private void addInfoToTable() {
    TableColumn<Project, Void> colBtn = new TableColumn("Information");

    Callback<TableColumn<Project, Void>, TableCell<Project, Void>> cellFactory = new Callback<TableColumn<Project, Void>, TableCell<Project, Void>>() {
      @Override
      public TableCell<Project, Void> call(final TableColumn<Project, Void> param) {
        final TableCell<Project, Void> cell = new TableCell<Project, Void>() {

          private final Button btn = new Button("More info");

          {
            btn.setOnAction((ActionEvent event) -> {
              Project data = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + data);
              try
              {
                ProjectInfoView.setProject(data);
                showInfo();
              }
              catch (IOException e)
              {
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
