package Client.Networking;

import Util.Answer;
import Util.PropertyChangeSubject;
import Util.Request;

public interface Client extends PropertyChangeSubject
{
    void startClient();
    void newRequest(Request request);
    void newAnswer(Answer answer);
}
