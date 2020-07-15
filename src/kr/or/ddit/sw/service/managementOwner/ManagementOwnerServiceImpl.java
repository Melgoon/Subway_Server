package kr.or.ddit.sw.service.managementOwner;

import kr.or.ddit.sw.dao.managementOwner.IManagementOwnerDao;
import kr.or.ddit.sw.dao.managementOwner.ManagementOwnerDaoImpl;
import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ManagementOwnerServiceImpl extends UnicastRemoteObject implements IManagementOwnerService {

    private final IManagementOwnerDao managementOwnerDao;
    private static IManagementOwnerService service;

    public ManagementOwnerServiceImpl() throws RemoteException {
        super();
        managementOwnerDao = ManagementOwnerDaoImpl.getInstance();
    }

    public static IManagementOwnerService getInstance() throws RemoteException {
        if (service == null) {
            service = new ManagementOwnerServiceImpl();
        }
        return service;
    }



    @Override
    public List<OwnerVO> selectOwner() throws RemoteException {
        return managementOwnerDao.selectOwner();
    }

    @Override
    public int updateOwner(OwnerVO vo) throws RemoteException {
        return managementOwnerDao.updateOwner(vo);
    }
}
