package kr.or.ddit.sw.service.notice;

import kr.or.ddit.sw.dao.notice.INoticeDao;
import kr.or.ddit.sw.dao.notice.NoticeDaoImpl;
import kr.or.ddit.sw.vo.notice.NoticeVO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NoticeServiceImpl extends UnicastRemoteObject implements INoticeService {

    private INoticeDao dao;
    private static INoticeService service;

    private NoticeServiceImpl() throws RemoteException {
        super();
        dao = NoticeDaoImpl.getInstance();
    }

    public static INoticeService getInstance() throws RemoteException {
        if (service == null){
            service = new NoticeServiceImpl();
        }
        return service;
    }

    @Override
    public int insertNotice(NoticeVO nv) throws RemoteException {
        return dao.insertNotice(nv);
    }

    @Override
    public List<NoticeVO> selectNoticeAll() throws RemoteException {
        return dao.selectNoticeAll();
    }

    @Override
    public int deleteNotice(NoticeVO nv) throws RemoteException {
        return dao.deleteNotice(nv);
    }

    @Override
    public int updateNotice(NoticeVO nv) throws RemoteException {
        return dao.updateNotice(nv);
    }
}
