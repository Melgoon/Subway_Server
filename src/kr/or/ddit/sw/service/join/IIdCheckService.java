package kr.or.ddit.sw.service.join;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IIdCheckService extends Remote {
    Object checkId(String id) throws RemoteException;
}
