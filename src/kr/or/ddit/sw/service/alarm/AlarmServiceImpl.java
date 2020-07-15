package kr.or.ddit.sw.service.alarm;

import kr.or.ddit.sw.dao.alarm.AlarmDaoImpl;
import kr.or.ddit.sw.dao.alarm.IAlarmDao;
import kr.or.ddit.sw.vo.notice.NoticeMemChkVO;
import kr.or.ddit.sw.vo.notice.NoticeVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AlarmServiceImpl extends UnicastRemoteObject implements IAlarmService{
    private static IAlarmService instance;
    private IAlarmDao dao;

    private AlarmServiceImpl() throws RemoteException {
        super();
        dao= AlarmDaoImpl.getInstance();
    }

    public static IAlarmService getInstance() throws RemoteException{
        if (instance==null){
            instance= new AlarmServiceImpl();
        }
        return instance;
    }

    @Override
    public List<NoticeVO> ReadNoSelect(String cv)  throws RemoteException{

        return dao.ReadNoSelect(cv);
    }

    @Override
    public int noticeNumber(String cv)throws RemoteException {
        return dao.noticeNumber(cv);
    }
    @Override
    public int updateNo(NoticeMemChkVO vo) throws RemoteException{
        return dao.updateNo(vo);
    }

    @Override
    public List<Integer> disSelectNO(String user_id) throws RemoteException{
        return dao.disSelectNO(user_id);
    }

    @Override
    public int deleteChk(int no) throws RemoteException {
        return dao.deleteChk(no);
    }

    @Override
    public int insertChk(NoticeMemChkVO vo) throws RemoteException {
        return dao.insertChk(vo);
    }

    @Override
    public String newUserChk(String user_id) throws RemoteException {
        return dao.newUserChk(user_id);
    }

    @Override
    public List<Integer> noticeNo() throws RemoteException {
        return dao.noticeNo();
    }

    @Override
    public List<Integer> noticeChkNo(String user_id) throws RemoteException {
        return dao.noticeChkNo(user_id);
    }
}
