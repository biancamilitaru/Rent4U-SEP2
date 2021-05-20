package Client.Model;

import Util.Answer;
import Util.PropertyChangeSubject;
import Util.Request;

public interface ClientModel extends PropertyChangeSubject
{
  void login (String s);
  void newRequest(Request request);
  void newAnswer(Answer answer);
}
