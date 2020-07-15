package kr.or.ddit.sw.service.tellsub;

import kr.or.ddit.sw.dao.tellsub.TellSubDaoImpl;
import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TellSubServiceImpl extends UnicastRemoteObject implements ITellSubService {

    private TellSubDaoImpl dao;
    private static TellSubServiceImpl service;

    private TellSubServiceImpl() throws RemoteException{
        super();
        dao = TellSubDaoImpl.getInstance();
    }

    public static TellSubServiceImpl getInstance() throws RemoteException{
        if(service == null){
            service = new TellSubServiceImpl();
        }
        return service;
    }

    @Override
    public Object insertTell(TellSubVO tv) throws RemoteException {
       return dao.insertTell(tv);
    }

    @Override
    public int deleteTell(TellSubVO tv) throws RemoteException {
        return dao.deleteTell(tv);
    }

    @Override
    public int updateTell(TellSubVO tv) throws RemoteException {
        return dao.updateTell(tv);
    }

    @Override
    public List<TellSubVO> selectAllTell(String get_tellsub_no) throws RemoteException {
        return dao.selectAllTell(get_tellsub_no);
    }

    @Override
    public List<TellSubVO> choisselectTell(TellSubVO Tellsub_no) throws RemoteException {
        return dao.choisselectTell(Tellsub_no);
    }
}
