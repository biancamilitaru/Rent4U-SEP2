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
  private EditCustomerInfoViewModel editCustomerInfoViewModel;
  private ListOfCustomersViewModel listOfCustomersViewModel;
  private AddPersonalAccountViewModel addpersonalAccountViewModel;
  private MenuForLogInViewModel menuForLogInViewModel;
  private EditPersonalInfoViewModel editPersonalInfoViewModel;
  private LogInCustomerViewModel logInCustomerViewModel;

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
  public EditCustomerInfoViewModel getEditCustomerInfoViewModelViewModel()
  {
    if(editCustomerInfoViewModel==null)
      editCustomerInfoViewModel=new EditCustomerInfoViewModel(ModelFactory.getInstance().getClientModel());
    return editCustomerInfoViewModel;
  }
  public AddPersonalAccountViewModel getAddPersonalAccountViewModelViewModel()
  {
    if(addpersonalAccountViewModel==null)
      addpersonalAccountViewModel=new AddPersonalAccountViewModel(ModelFactory.getInstance().getClientModel());
    return addpersonalAccountViewModel;
  }
  public EditPersonalInfoViewModel getEditPersonalInfoViewModelViewModel()
  {
    if(editPersonalInfoViewModel==null)
      editPersonalInfoViewModel=new EditPersonalInfoViewModel(ModelFactory.getInstance().getClientModel());
    return editPersonalInfoViewModel;
  }

  public MenuForLogInViewModel getMenuForLogInViewModel()
  {
    if(menuForLogInViewModel==null)
      menuForLogInViewModel=new MenuForLogInViewModel(ModelFactory.getInstance().getClientModel());
    return menuForLogInViewModel;
  }

  public LogInCustomerViewModel getLogInCustomerViewModel()
  {
    if(logInCustomerViewModel==null)
      logInCustomerViewModel=new LogInCustomerViewModel(ModelFactory.getInstance().getClientModel());
    return logInCustomerViewModel;
  }
}
