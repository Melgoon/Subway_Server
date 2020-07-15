package kr.or.ddit.sw.service.chatpass;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.dao.chatpass.IOwnerChatPassDao;
import kr.or.ddit.sw.dao.chatpass.OwnerChatPassImDao;
import kr.or.ddit.sw.util.SqlMapClientFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class OwnerChatPassImService extends UnicastRemoteObject implements IOwnerChatPassService {

    private IOwnerChatPassDao dao;
    private static IOwnerChatPassService instance;

    private OwnerChatPassImService() throws RemoteException {
        dao = OwnerChatPassImDao.getInstance();
    }

    public static IOwnerChatPassService getInstance() throws RemoteException {
        if (instance==null){
            instance= new OwnerChatPassImService();
        }
        return instance;
    }


    @Override
    public String OwnerPassChk(int code) throws RemoteException {
        return dao.OwnerPassChk(code);
    }
}
