package kr.or.ddit.sw.service.menuintro;

import kr.or.ddit.sw.dao.menuIntro.IMenuIntroDao;
import kr.or.ddit.sw.dao.menuIntro.MenuIntroDaoImpl;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MenuIntroServiceImpl extends UnicastRemoteObject implements IMenuIntroService {

    private static IMenuIntroService service;
    private IMenuIntroDao dao;

    private MenuIntroServiceImpl() throws RemoteException {
        super();
        dao = MenuIntroDaoImpl.getInstance();
    }

    public static IMenuIntroService getInstance() throws RemoteException {
        if(service == null){
            service = new MenuIntroServiceImpl();
        }
        return service;
    }

    @Override
    public List<ProdVO> selectAll() throws RemoteException {
        return dao.selectAll();
    }

    @Override
    public List<ProdVO> selectKate(int kate) throws RemoteException {
        return dao.selectKate(kate);
    }
}
