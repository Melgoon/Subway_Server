package kr.or.ddit.sw.dao.login;


import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.member.MemberVO;

import java.sql.SQLException;

public class LoginDaoImpl implements ILoginDao {

    private final SqlMapClient smc;
    private static LoginDaoImpl dao;

    private LoginDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static LoginDaoImpl getInstance(){
        if (dao == null){
            dao = new LoginDaoImpl();
        }
        return dao;
    }


    @Override
    public MemberVO login(String id) {
        MemberVO vo = null;
        try {
            vo = (MemberVO) smc.queryForObject("member.idcheck", id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
