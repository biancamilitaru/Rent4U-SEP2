package Client.Views;

import Client.ViewHandler;
import ViewModel.LogInViewModel;
import javafx.fxml.FXML;

import java.io.IOException;

public class LogInViewController
{
  @FXML private javafx.scene.control.TextField passwordTextField;

  private ViewHandler viewHandler;
  protected LogInViewModel logInViewModel;


  public void init(LogInViewModel logInViewModel)
  {
    this.logInViewModel = logInViewModel;
    this.viewHandler=viewHandler;

    passwordTextField.textProperty().bindBidirectional(logInViewModel.passwordProperty());


  }
}
