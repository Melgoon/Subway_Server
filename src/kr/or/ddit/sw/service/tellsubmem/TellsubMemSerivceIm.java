package kr.or.ddit.sw.service.tellsubmem;

import kr.or.ddit.sw.dao.tellsubmem.ITellsubMemDao;
import kr.or.ddit.sw.dao.tellsubmem.TellsubMemDaoIm;
import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TellsubMemSerivceIm extends UnicastRemoteObject implements ITellsubMemService {

    private ITellsubMemDao dao;
    private static ITellsubMemService instance;

    private TellsubMemSerivceIm() throws RemoteException {
        dao= TellsubMemDaoIm.getInstance();
    }

    public static ITellsubMemService getInstance() throws RemoteException {
        if (instance==null){
            instance= new TellsubMemSerivceIm();
        }
        return instance;
    }


    @Override
    public int insertTellsubMem(String user_id) throws RemoteException {
        return dao.insertTellsubMem(user_id);
    }

    @Override
    public List<TellSubVO> selectUnionTell(String user_id) throws RemoteException {
        return dao.selectUnionTell(user_id);
    }

    @Override
    public int updateTellsubMem(TellSubMemVO vo) throws RemoteException {
        return dao.updateTellsubMem(vo);
    }


    @Override
    public TellSubVO selectDetail(int tellSub_no) throws RemoteException {
        return dao.selectDetail(tellSub_no);
    }

    @Override
    public int selectTellSubNO(String user_id) throws RemoteException{
        return dao.selectTellSubNO(user_id);
    }

}
