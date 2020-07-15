package kr.or.ddit.sw.dao.chatpass;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;

import java.security.acl.Owner;
import java.sql.SQLException;

public class OwnerChatPassImDao implements IOwnerChatPassDao {
    private SqlMapClient smc;
    private static IOwnerChatPassDao instance;

    private OwnerChatPassImDao() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IOwnerChatPassDao getInstance(){
        if (instance==null){
            instance =new OwnerChatPassImDao();
        }
        return instance;
    }

    @Override
    public String OwnerPassChk(int code) {
        String passChk = null;
        try {
            passChk = (String) smc.queryForObject("Chat.OwnerPassChk",code);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return passChk;
    }
}
