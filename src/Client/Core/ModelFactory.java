package Client.Core;

import Client.Model.ClientModel;
import Client.Model.EmployeeModelManager;

public class ModelFactory
{
  private static ModelFactory instance = new ModelFactory();
  public static ModelFactory getInstance(){
    return instance;
  }
  private ClientModel clientModel;

  private ModelFactory() {}

  public ClientModel getClientModel(){
    if (clientModel == null)
      clientModel = new EmployeeModelManager(ClientFactory.getInstance().getClient());
    return clientModel;
  }

}
