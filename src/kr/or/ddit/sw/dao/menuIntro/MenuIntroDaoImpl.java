package kr.or.ddit.sw.dao.menuIntro;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.sql.SQLException;
import java.util.List;

public class MenuIntroDaoImpl implements IMenuIntroDao{

    private SqlMapClient smc;
    private static IMenuIntroDao dao;

    private MenuIntroDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static IMenuIntroDao getInstance(){
        if(dao == null){
            dao = new MenuIntroDaoImpl();
        }
        return dao;
    }

    @Override
    public List<ProdVO> selectAll() {
        List<ProdVO> list = null;
        try {
            list = smc.queryForList("prod.selectMenuList");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ProdVO> selectKate(int kate) {
        List<ProdVO> list = null;
        try {
            list = smc.queryForList("prod.selectKate",kate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }




}
