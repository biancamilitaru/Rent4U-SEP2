package Client.Core;

import Client.ViewModel.*;

public class ViewModelFactory
{
  private static ViewModelFactory instance = new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }

  private LogInViewModel logInViewModel;
  private AddVehicleViewModel addVehicleViewModel;
  private MenuViewModel menuViewModel;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;
  private CreateBookingViewModel createBookingViewModel;

  private ViewModelFactory() {
  }

  public LogInViewModel getLogInViewModel() {
    if (logInViewModel == null)
      logInViewModel = new LogInViewModel(ModelFactory.getInstance().getClientModel());
    return logInViewModel;
  }

  public AddVehicleViewModel getAddVehicleViewModel()
  {
    if(addVehicleViewModel==null)
      addVehicleViewModel=new AddVehicleViewModel(ModelFactory.getInstance().getClientModel());
    return addVehicleViewModel;
  }

  public MenuViewModel getMenuViewModel()
  {
    if(menuViewModel==null)
      menuViewModel=new MenuViewModel(ModelFactory.getInstance().getClientModel());
    return menuViewModel;
  }

  public ListOfVehiclesViewModel getListOfVehiclesViewModel()
  {
    if(listOfVehiclesViewModel==null)
      listOfVehiclesViewModel=new ListOfVehiclesViewModel(ModelFactory.getInstance().getClientModel());
    return listOfVehiclesViewModel;
  }
  public CreateBookingViewModel getCreateBookingViewModel() {
    if (createBookingViewModel == null)
      createBookingViewModel = new CreateBookingViewModel(ModelFactory.getInstance().getClientModel());
    return createBookingViewModel;
  }






}
