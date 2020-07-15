package kr.or.ddit.sw.dao.join;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class JoinDaoImpl implements IJoinDao {
    private final SqlMapClient smc;
    private static IJoinDao joinDao;

    private JoinDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IJoinDao getInstance() {
        if (joinDao == null) {
            joinDao = new JoinDaoImpl();
        }
        return joinDao;
    }

    @Override
    public Object insertMember(MemberVO mv) {
        Object obj = 1;
        try {
            obj = smc.insert("member.insert", mv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    @Override
    public Object insertOwner(OwnerVO own) {
        Object obj = 1;
        try {
            obj = smc.insert("owner.insert", own);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }


    @Override
    public int updateMember(MemberVO mv) {
        int cnt=0;
        try {
            cnt = smc.update("member.updateMember",mv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }


}
