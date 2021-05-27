package Client.Core;

import Client.ViewModel.*;

public class ViewModelFactory
{
  private static ViewModelFactory instance = new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    if(instance == null)
      instance = new ViewModelFactory();
    return instance;
  }

  private LogInViewModel logInViewModel;
  private AddVehicleViewModel addVehicleViewModel;
  private MenuViewModel menuViewModel;
  private ListOfVehiclesViewModel listOfVehiclesViewModel;
  private AddBookingViewModel addBookingViewModel;
  private SetStatusViewModel setStatusViewModel;
  private EditVehicleInfoViewModel editVehicleInfoVewModel;
  private EditBookingInfoViewModel editBookingInfoViewModel;
  private ListOfBookingsViewModel listOfBookingsViewModel;
  private AddCustomerAccountViewModel addCustomerAccountViewModel;
  private ListOfCustomersViewModel listOfCustomersViewModel;

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
  public AddBookingViewModel getAddBookingViewModel() {
    if (addBookingViewModel == null)
      addBookingViewModel = new AddBookingViewModel(ModelFactory.getInstance().getClientModel());
    return addBookingViewModel;
  }

  public SetStatusViewModel getSetStatusViewModel()
  {
    if (setStatusViewModel == null)
      setStatusViewModel = new SetStatusViewModel(ModelFactory.getInstance().getClientModel());
    return setStatusViewModel;
  }

  public EditVehicleInfoViewModel getEditVehicleInfoViewModel()
  {
    if(editVehicleInfoVewModel==null)
      editVehicleInfoVewModel=new EditVehicleInfoViewModel(ModelFactory.getInstance().getClientModel());
    return editVehicleInfoVewModel;
  }

  public EditBookingInfoViewModel getEditBookingInfoViewModel()
  {
    if(editBookingInfoViewModel==null)
      editBookingInfoViewModel=new EditBookingInfoViewModel(ModelFactory.getInstance().getClientModel());
    return editBookingInfoViewModel;
  }
  public ListOfBookingsViewModel getListOfBookingsViewModel()
  {
    if(listOfBookingsViewModel==null)
      listOfBookingsViewModel=new ListOfBookingsViewModel(ModelFactory.getInstance().getClientModel());
    return listOfBookingsViewModel;
  }

  public AddCustomerAccountViewModel getAddCustomerAccountViewModelViewModel()
  {
    if(addCustomerAccountViewModel==null)
      addCustomerAccountViewModel=new AddCustomerAccountViewModel(ModelFactory.getInstance().getClientModel());
    return addCustomerAccountViewModel;
  }

  public ListOfCustomersViewModel getListOfCustomersViewModel()
  {
    if(listOfCustomersViewModel==null)
      listOfCustomersViewModel=new ListOfCustomersViewModel(ModelFactory.getInstance().getClientModel());
    return listOfCustomersViewModel;
  }
}
