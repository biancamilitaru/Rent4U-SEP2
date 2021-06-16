package Client.Core;

import Client.Model.ClientModel;
import Client.Model.ClientModelManager;

public class ModelFactory
{
  private static ModelFactory instance;
  public static ModelFactory getInstance()
  {
    if(instance == null)
      instance = new ModelFactory();
    return instance;
  }

  private ModelFactory() {}

  private ClientModel clientModel;

  public ClientModel getClientModel(){
    if (clientModel == null)
      clientModel = new ClientModelManager(ClientFactory.getInstance().getClient());
    return clientModel;
  }

}
