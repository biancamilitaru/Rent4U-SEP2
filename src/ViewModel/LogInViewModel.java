package ViewModel;

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
  private void onLoginResponse(PropertyChangeEvent evt)
  {
    String result = (String) evt.getNewValue();

  }




  public StringProperty passwordProperty()
  {
    return password;

  }

  public void login()
  {

    System.out.println(password.get());
    userModel.login(password.get());

  }


}
