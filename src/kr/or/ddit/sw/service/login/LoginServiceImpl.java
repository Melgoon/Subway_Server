package kr.or.ddit.sw.service.login;

import kr.or.ddit.sw.dao.login.ILoginDao;
import kr.or.ddit.sw.dao.login.LoginDaoImpl;
import kr.or.ddit.sw.vo.member.MemberVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServiceImpl extends UnicastRemoteObject implements ILoginService {

    private final ILoginDao dao;
    private static ILoginService service;

    public LoginServiceImpl() throws RemoteException {
        super();
        dao = LoginDaoImpl.getInstance();
    }

    public static ILoginService getInstance() throws RemoteException {
        if (service == null) {
            service = new LoginServiceImpl();
        }
        return service;
    }

    @Override
    public MemberVO login(String id) throws RemoteException {
        return dao.login(id);
    }
}
