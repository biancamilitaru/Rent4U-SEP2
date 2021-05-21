package Client.Model;

import Util.PropertyChangeSubject;
import Util.Request;

import java.beans.PropertyChangeEvent;

public interface ClientModel extends PropertyChangeSubject
{
  void login (String s);
  void newRequest(Request request);
  void newAnswer(PropertyChangeEvent evt);
  void addVehicle(Vehicle vehicle);
}
