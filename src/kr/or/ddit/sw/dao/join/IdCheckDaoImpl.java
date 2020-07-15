package kr.or.ddit.sw.dao.join;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.member.MemberVO;

import java.sql.SQLException;

public class IdCheckDaoImpl implements IIdCheckDao {

    private final SqlMapClient smc;
    private static IIdCheckDao dao;

    public IdCheckDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IIdCheckDao getInstance() {
        if (dao == null) {
            dao = new IdCheckDaoImpl();
        }
        return dao;
    }

    @Override
    public Object checkId(String id) {
        MemberVO vo = null;
        try {
            vo = (MemberVO) smc.queryForObject("member.idcheck", id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
