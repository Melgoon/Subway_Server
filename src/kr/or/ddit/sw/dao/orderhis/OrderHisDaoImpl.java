package kr.or.ddit.sw.dao.orderhis;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.orderhis.OrderHisVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.pay.PayVO;

import java.sql.SQLException;
import java.util.List;

public class OrderHisDaoImpl implements IOrderHisDao {
    private SqlMapClient smc;

    private static IOrderHisDao dao;

    private OrderHisDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IOrderHisDao getInstance(){
        if(dao == null){
            dao = new OrderHisDaoImpl();
        }
        return dao;
    }


    @Override
    public List<OrderVO> selectid(String id) {
        List<OrderVO> vo = null;
        try {
            vo = (List<OrderVO>) smc.queryForList("orderVO.idselect",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
