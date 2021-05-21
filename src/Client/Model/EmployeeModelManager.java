package Client.Model;

import Client.Networking.Client;
import Util.Request;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EmployeeModelManager implements ClientModel{

    private PropertyChangeSupport support;
    private Client client;
    private String password;

    public EmployeeModelManager(Client client)
    {
        this.client = client;
        support = new PropertyChangeSupport(this);
        client.startClient();
        client.addListener("NewRequest",this::newAnswer);
        password = "default";
    }

    @Override
    public void login(String s) {
        if(s.equals(password))
            System.out.println("Log in successfully!");
    }

    @Override
    public void newRequest(Request request) {
        client.newRequest(request);
    }

    @Override
    public void newAnswer(PropertyChangeEvent evt)
    {
        support.firePropertyChange("NewAnswer", null, evt.getNewValue());
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
