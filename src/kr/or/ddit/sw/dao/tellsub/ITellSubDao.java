package kr.or.ddit.sw.dao.tellsub;

import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ITellSubDao extends Remote{
    Object insertTell(TellSubVO tv) throws RemoteException;

    public int deleteTell(TellSubVO tv) throws RemoteException;



    public int updateTell(TellSubVO tv) throws RemoteException;

    public List<TellSubVO> selectAllTell(String get_tellsub_no) throws RemoteException;

    public List<TellSubVO> choisselectTell(TellSubVO Tellsub_no) throws RemoteException;
}
