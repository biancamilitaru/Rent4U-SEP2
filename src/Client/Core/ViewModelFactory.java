package Client.Core;

import Client.ViewModel.LogInViewModel;

public class ViewModelFactory
{
  private static ViewModelFactory instance = new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }

  private LogInViewModel logInViewModel;

  private ViewModelFactory() {
  }

  public LogInViewModel getLogInViewModel() {
    if (logInViewModel == null)
      logInViewModel = new LogInViewModel(ModelFactory.getInstance().getClientModel());
    return logInViewModel;
  }




}
