package Server.Model;

import Util.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ServerModelManager implements ServerModel
{
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void newRequest(Request request) {
        support.firePropertyChange("NewRequest", null, request);
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
