package Client.Views.SetStatusView;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class SetStatusViewController implements ViewController
{

  private ViewHandler viewHandler;
  private SetStatusViewModel setStatusViewModel;

  @FXML Button setStatusButton;
  @FXML Button goToMenuButton;
  @FXML TextField statusTextField;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    setStatusViewModel = viewModelFactory.getSetStatusViewModel();
  }

  public void onMenuButton(ActionEvent evt)
  {
    viewHandler.openMainMenu();
  }

  public void setSetStatusButton(ActionEvent evt)
  {
    setStatusViewModel.setStatus(,statusTextField.getText());
  }


}
