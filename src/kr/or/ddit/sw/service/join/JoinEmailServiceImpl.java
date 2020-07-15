package kr.or.ddit.sw.service.join;

import kr.or.ddit.sw.dao.join.IJoinEmailDao;
import kr.or.ddit.sw.dao.join.JoinEmailDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JoinEmailServiceImpl extends UnicastRemoteObject implements IJoinEmailService {
    private final IJoinEmailDao dao;

    private static IJoinEmailService service;

    private JoinEmailServiceImpl() throws RemoteException {
        super();
        dao = new JoinEmailDaoImpl();
    }

    public static IJoinEmailService getInstance() throws RemoteException {
        if (service == null) {
            service = new JoinEmailServiceImpl();
        }
        return service;
    }

    @Override
    public void emailCheck(String email, Integer num) {
        dao.emailCheck(email, num);
    }
}
