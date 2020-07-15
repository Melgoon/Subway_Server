package kr.or.ddit.sw.service.join;

import kr.or.ddit.sw.dao.join.IJoinDao;
import kr.or.ddit.sw.dao.join.JoinDaoImpl;
import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JoinServiceImpl extends UnicastRemoteObject implements IJoinService {

    private final IJoinDao joinDao;
    private static IJoinService service;

    public JoinServiceImpl() throws RemoteException {
        super();
        joinDao = JoinDaoImpl.getInstance();
    }

    public static IJoinService getInstance() throws RemoteException {
        if (service == null) {
            service = new JoinServiceImpl();
        }
        return service;
    }

    @Override
    public Object insertMember(MemberVO mv) throws RemoteException {
        return joinDao.insertMember(mv);
    }

    @Override
    public Object insertOwner(OwnerVO own) throws RemoteException {
        return joinDao.insertOwner(own);
    }

    /**
     * 회원정보 수정하기위한 것
     * @param mv
     * @return
     * @throws RemoteException
     */
    @Override
    public int updateMember(MemberVO mv) throws RemoteException {
        return joinDao.updateMember(mv);
    }
}
