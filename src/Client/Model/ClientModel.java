package Client.Model;

import Util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface ClientModel extends PropertyChangeSubject
{
  void login (String s);
}
