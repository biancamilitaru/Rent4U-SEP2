package Client.Views.ListOfVehiclesView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.ListOfVehiclesViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;

public class ListOfVehiclesViewController implements ViewController
{

  private ViewHandler viewHandler;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;



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
}
