package kr.or.ddit.sw.service.registFoodMtr;


import kr.or.ddit.sw.dao.registFoodMtr.IRegistFoodMtrDao;
import kr.or.ddit.sw.dao.registFoodMtr.RegistFoodMtrDaoImpl;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.foodmtr.MtrPicVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RegistFoodMtrServiceImpl extends UnicastRemoteObject implements IRegistFoodMtrService {

    private final IRegistFoodMtrDao registFoodMtrDao;
    private static IRegistFoodMtrService service;

    public RegistFoodMtrServiceImpl() throws RemoteException {
        super();
        registFoodMtrDao = RegistFoodMtrDaoImpl.getInstance();
    }

    public static IRegistFoodMtrService getInstance() throws RemoteException {
        if (service == null) {
            service = new RegistFoodMtrServiceImpl();
        }
        return service;
    }


    @Override
    public int insertFoodMtr(FoodMtrVO vo) throws RemoteException {
        return registFoodMtrDao.insertFoodMtr(vo);
    }

    @Override
    public int insertFoodMtrPic(MtrPicVO vo) throws RemoteException {
        return registFoodMtrDao.insertFoodMtrPic(vo);
    }

    @Override
    public List<FoodMtrVO> selectFoodMtr() throws RemoteException {
        return registFoodMtrDao.selectFoodMtr();
    }

    @Override
    public int deleteFoodMtr(FoodMtrVO vo) throws RemoteException {
        return registFoodMtrDao.deleteFoodMtr(vo);
    }
}
