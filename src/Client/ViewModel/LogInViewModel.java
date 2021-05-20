package Client.ViewModel;

import Client.Model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.beans.PropertyChangeEvent;

public class LogInViewModel
{
  private ClientModel userModel;
  private StringProperty password;

  public LogInViewModel(ClientModel userModel)
  {
    this.userModel= userModel;
    password = new SimpleStringProperty();

  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public void logIn()
  {

    System.out.println(password.get());
    userModel.login(password.get());
  }


}
