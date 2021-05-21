package Client.Views.MenuView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.MenuViewModel;
import Client.Views.ViewController;
import javafx.fxml.FXML;

import java.awt.*;

public class MenuViewController implements ViewController
{

  private ViewHandler viewHandler;
  private MenuViewModel menuViewModel;

  @FXML private Button openAddVehicleButton;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.menuViewModel = viewModelFactory.getMenuViewModel();
  }

  public void odAddVehicleButton()
  {
    viewHandler.openAddVehicle();
  }




}
