package kr.or.ddit.sw.dao.owner;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.owner.OwnerVO;
import kr.or.ddit.sw.vo.owner.TempOwnerVO;

import java.sql.SQLException;

public class OwnerDaoImpl implements IOwnerDao{
    private SqlMapClient smc;
    private static IOwnerDao dao;
    private OwnerDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static IOwnerDao getInstance(){
        if(dao == null){
            dao = new OwnerDaoImpl();
        }
        return dao;
    }

    @Override
    public Object insertowner(OwnerVO vo) {
        Object object = null;
        try {
             object = smc.insert("owner.insert",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
    }

    @Override
    public OwnerVO owerlogin(TempOwnerVO tempOwnerVO) {
        OwnerVO vo = null;
        try {
            vo = (OwnerVO) smc.queryForObject("owner.login",tempOwnerVO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
