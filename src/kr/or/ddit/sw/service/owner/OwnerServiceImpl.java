package kr.or.ddit.sw.service.owner;

import kr.or.ddit.sw.dao.owner.IOwnerDao;
import kr.or.ddit.sw.dao.owner.OwnerDaoImpl;
import kr.or.ddit.sw.vo.owner.OwnerVO;
import kr.or.ddit.sw.vo.owner.TempOwnerVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OwnerServiceImpl extends UnicastRemoteObject implements IOwnerService{

    private IOwnerDao dao;
    private static IOwnerService service;
    private OwnerServiceImpl() throws RemoteException {
        super();
        dao = OwnerDaoImpl.getInstance();
    }
    public static IOwnerService getInstance() throws RemoteException {
        if(service == null){
            service = new OwnerServiceImpl();
        }
        return service;
    }

    @Override
    public Object insertowner(OwnerVO vo) throws RemoteException {
        return dao.insertowner(vo);
    }

    @Override
    public OwnerVO owerlogin(TempOwnerVO tempOwnerVO) throws RemoteException {
        return dao.owerlogin(tempOwnerVO);
    }
}
