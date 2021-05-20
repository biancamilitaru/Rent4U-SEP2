package Server.Model;

import Util.PropertyChangeSubject;
import Util.Request;

public interface ServerModel extends PropertyChangeSubject
{
    void newRequest(Request request);
}
