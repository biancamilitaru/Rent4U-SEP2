package Client.Model;

import Client.Networking.Client;
import Util.Answer;
import Util.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClientModelManager implements ClientModel{

    private PropertyChangeSupport support;
    private Client client;

    public ClientModelManager(Client client)
    {
        this.client = client;
        support = new PropertyChangeSupport(this);
        client.startClient();
        client.addListener("NewRequest",this::newAnswer);
    }

    @Override
    public void login(String s) {

    }

    @Override
    public void newRequest(Request request) {

    }

    @Override
    public void newAnswer(Answer answer) {

    }

    @Override
    public void addListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
