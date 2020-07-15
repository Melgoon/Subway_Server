package kr.or.ddit.sw.service.login;

import kr.or.ddit.sw.dao.join.IJoinEmailDao;
import kr.or.ddit.sw.dao.join.JoinEmailDaoImpl;
import kr.or.ddit.sw.dao.login.ILoginEmailDao;
import kr.or.ddit.sw.dao.login.LoginEmailDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginEmailServiceImpl extends UnicastRemoteObject implements ILoginEmailService {
    private final ILoginEmailDao dao;

    private static ILoginEmailService service;

    private LoginEmailServiceImpl() throws RemoteException {
        super();
        dao = LoginEmailDaoImpl.getInstance();
    }

    public static ILoginEmailService getInstance() throws RemoteException {
        if (service == null) {
            service = new LoginEmailServiceImpl();
        }
        return service;
    }

    @Override
    public void emailCheck(String email) {
        dao.emailCheck(email);
    }
}
