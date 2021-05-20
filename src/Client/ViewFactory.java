package Client;

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
    createScene("LogInScene");
  }

  private static void createScene(String sceneName) throws IOException
  {
    Scene scene = null;
    if (sceneName.equals("LogInScene")){
      //Have to include the root to the specific FXML file
      Parent root = loadFXML("logInView_FXML_Path");

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

    //View Controller interface has to be created
    ViewController vc = loader.getController();
    vc.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    return root;
  }

  public static Scene getScene(String sceneName){
    return scenes.get(sceneName);
  }
}
