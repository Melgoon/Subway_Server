package kr.or.ddit.sw.service.join;

import kr.or.ddit.sw.dao.join.IIdCheckDao;
import kr.or.ddit.sw.dao.join.IdCheckDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IdCheckServiceImpl extends UnicastRemoteObject implements IIdCheckService {

    private static IIdCheckService service;
    private final IIdCheckDao dao;

    public IdCheckServiceImpl() throws RemoteException {
        super();
        dao = IdCheckDaoImpl.getInstance();
    }

    public static IIdCheckService getInstance() throws RemoteException {
        if (service == null) {
            service = new IdCheckServiceImpl();
        }
        return service;
    }

    @Override
    public Object checkId(String id) throws RemoteException {
        return dao.checkId(id);
    }
}
