package kr.or.ddit.sw.service.pay;

import kr.or.ddit.sw.dao.pay.PayDaoImpl;
import kr.or.ddit.sw.vo.pay.PayVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PayServiceImpl extends UnicastRemoteObject implements IPayService {

    private PayDaoImpl dao;
    private static PayServiceImpl service;

    private PayServiceImpl() throws RemoteException{
        super();
        dao = PayDaoImpl.getInstance();
    }

    public static PayServiceImpl getInstance() throws RemoteException{
        if(service == null){
            service = new PayServiceImpl();
        }
        return service;
    }

    @Override
    public Object Deliinsert(PayVO pv) throws RemoteException {
        return dao.Deliinsert(pv);
    }

    @Override
    public Object Reserinsert(PayVO pv) throws RemoteException {
        return dao.Reserinsert(pv);
    }

    @Override
    public PayVO payvo() throws RemoteException {
        return dao.payvo();
    }


}
