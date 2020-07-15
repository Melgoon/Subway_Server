package kr.or.ddit.sw.service.login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginEmailService extends Remote {
   void emailCheck(String email) throws RemoteException;
}
