package Client.Views.SetStatusViewController;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.ViewModel.MenuViewModel;
import Client.ViewModel.SetStatusViewModel;
import Client.Views.ViewController;

public class SetStatusViewController implements ViewController
{

  private ViewHandler viewHandler;
  private SetStatusViewModel setStatusViewModel;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    setStatusViewModel = viewModelFactory.getSetStatusViewModel();
  }
}
