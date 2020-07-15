package kr.or.ddit.sw.dao.pay;

import kr.or.ddit.sw.vo.pay.PayVO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPayDao extends Remote {

    Object Deliinsert(PayVO pv) throws RemoteException;
    Object Reserinsert(PayVO pv) throws RemoteException;
    public PayVO payvo() throws RemoteException;

}
