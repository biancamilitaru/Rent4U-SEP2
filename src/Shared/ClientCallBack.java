package Shared;

import Util.Answer;
import Util.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
    void newAnswer(Answer answer) throws RemoteException;
    void newRequest(Request request) throws RemoteException;
}
