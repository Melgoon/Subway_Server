package kr.or.ddit.sw.service.honeycombi;

import kr.or.ddit.sw.dao.honeycombi.HoneyCombiDaoImpl;
import kr.or.ddit.sw.dao.honeycombi.IHoneyCombiDao;
import kr.or.ddit.sw.vo.honeycombi.HoneyCombiVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HoneyCombiService extends UnicastRemoteObject implements IHoneyCombiService {
    private IHoneyCombiDao dao;
    private static IHoneyCombiService service;

    private HoneyCombiService() throws RemoteException {
        super();
        dao = HoneyCombiDaoImpl.getInstance();
    }

    public static IHoneyCombiService getInstance() throws RemoteException {
        if (service == null) {
            service = new HoneyCombiService();
        }
        return service;
    }

    @Override
    public List<HoneyCombiVO> selectAllHoney() throws RemoteException {
        return dao.selectAllHoney();
    }

    @Override
    public List<HoneyCombiVO> selectHoney(String menu) throws RemoteException {
        return null;
    }

    @Override
    public Object insertHoney(HoneyCombiVO honeyCombiVO) throws RemoteException {
        return dao.insertHoney(honeyCombiVO);
    }

    @Override
    public HoneyCombiVO selectHoneyBtn(String name) throws RemoteException {
        return dao.selectHoneyBtn(name);
    }
}
