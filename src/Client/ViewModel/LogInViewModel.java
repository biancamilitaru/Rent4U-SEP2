package Client.ViewModel;

import Client.Model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.beans.PropertyChangeEvent;

public class LogInViewModel
{
  private ClientModel userModel;
  private StringProperty password;
  private String employeePassword;
  private String managerPassword;

  public LogInViewModel(ClientModel userModel)
  {
    this.userModel= userModel;
    password = new SimpleStringProperty();
    employeePassword = "default";
    managerPassword = "default2";
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public int logIn()
  {
    System.out.println(password.getValue());
    if(password.getValue().equals(employeePassword)) {
      return 0;
    }
    else if (password.getValue().equals(managerPassword))
      return 1;
    else return -1;
  }


}
