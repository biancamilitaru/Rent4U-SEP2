package Core;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private static ViewHandler instance = new ViewHandler();

  public static ViewHandler getInstance(){
    return instance;
  }

  private Stage stage;

  private ViewHandler() {}

  public void start() throws IOException
  {
    stage = new Stage();
    ViewFactory.init(stage);
    openToLogInView();
  }

  private void openToLogInView()
  {
    Scene logInViewScene = ViewFactory.getScene("LogIn");
    stage.setTitle(String.valueOf(logInViewScene));
    stage.show();
  }

}
