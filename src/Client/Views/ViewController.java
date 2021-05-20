package Client.Views;

import Client.ViewHandler;
import Client.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
