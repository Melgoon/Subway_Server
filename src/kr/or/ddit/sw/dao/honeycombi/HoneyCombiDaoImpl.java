package kr.or.ddit.sw.dao.honeycombi;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.honeycombi.HoneyCombiVO;

import java.sql.SQLException;
import java.util.List;

public class HoneyCombiDaoImpl implements IHoneyCombiDao {
    private SqlMapClient smc;
    private static IHoneyCombiDao dao;

    private HoneyCombiDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IHoneyCombiDao getInstance() {
        if (dao == null) {
            dao = new HoneyCombiDaoImpl();
        }
        return dao;
    }

    @Override
    public List<HoneyCombiVO> selectAllHoney() {
        List<HoneyCombiVO> list = null;
        try {
            list = smc.queryForList("honey.selectAll");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HoneyCombiVO> selectHoney(String menu) {
        return null;
    }

    @Override
    public Object insertHoney(HoneyCombiVO honeyCombiVO) {
        Object obj = null;
        try {
            obj = smc.insert("honey.insert", honeyCombiVO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    @Override
    public HoneyCombiVO selectHoneyBtn(String name) {
        HoneyCombiVO vo = null;
        try {
            vo = (HoneyCombiVO) smc.queryForObject("honey.selectBtn",name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
