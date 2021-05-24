package Client.Views;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ViewController
{
  void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) throws SQLException, RemoteException;
}
