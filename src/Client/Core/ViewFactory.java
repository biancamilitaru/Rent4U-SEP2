package Client.Core;

import Client.Views.LogInView.LoginViewController;
import Client.Views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory
{
  private static Map<String, Scene> scenes;
  private static Stage stage;

  static
  {
    scenes = new HashMap<>();
  }

  public static void init(Stage theStage) throws IOException
  {
    stage = theStage;

    //createScene("LogInScene");
  }

  public void open()
  {
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("../Views/LogInView/LoginView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println(e.getMessage());
      System.out.println(loader.getLocation());
    }
    LoginViewController view = loader.getController();
    view.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    stage.setTitle("Chat");
  }
/*
  private static void createScene(String sceneName) throws IOException
  {
    Scene scene = null;
    if (sceneName.equals("LogInScene")){
      //Have to include the root to the specific FXML file
      Parent root = loadFXML(".../Views/LogInView/LoginView.fxml");

      scene = new Scene(root);
      stage.setTitle("LogIn");
    }
    scenes.put(sceneName, scene);
  }

  private static Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewFactory.class.getResource(path));
    Parent root = loader.load();

    ViewController vc = loader.getController();
    vc.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    return root;
  }


 */

  public static Scene getScene(String sceneName){
    return scenes.get(sceneName);
  }
}
