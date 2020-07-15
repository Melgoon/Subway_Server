package kr.or.ddit.sw.service.regAdvertise;

import kr.or.ddit.sw.dao.regAdvertise.IRegAdvertiseDao;
import kr.or.ddit.sw.dao.regAdvertise.RegAdvertiseDaoImpl;
import kr.or.ddit.sw.vo.advertise.AdvertiseVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RegAdvertiseSeviceImpl extends UnicastRemoteObject implements IRegAdvertiseService {
    private final IRegAdvertiseDao regAdvertiseDao;
    private static IRegAdvertiseService service;

    public RegAdvertiseSeviceImpl() throws RemoteException {
        super();
        regAdvertiseDao = RegAdvertiseDaoImpl.getInstance();
    }

    public static IRegAdvertiseService getInstance() throws RemoteException {
        if (service == null) {
            service = new RegAdvertiseSeviceImpl();
        }
        return service;
    }


    @Override
    public int insertAdvertise(AdvertiseVO vo) {
        return regAdvertiseDao.insertAdvertise(vo);
    }


}
