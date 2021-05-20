package Client;

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
      clientModel = new ClientModel();
    return clientModel;
  }

}
