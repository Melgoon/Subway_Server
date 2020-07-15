package kr.or.ddit.sw.dao.ordertable;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class OrderTableDaoImpl implements IOrderTableDao{
    private SqlMapClient smc;
    private static IOrderTableDao dao;

    private OrderTableDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static IOrderTableDao getInstance(){
        if(dao == null) {
            dao = new OrderTableDaoImpl();
        }
        return dao;
    }

    @Override
    public List<FoodMtrVO> select(int mtr_div) {
        List<FoodMtrVO> list = null;
        try {
            list = smc.queryForList("foodMtr.selectdiv",mtr_div);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Object insert(CombiVO vo) {
        Object obj = null;
        try {
            obj = smc.insert("foodMtr.insertCombi",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    @Override
    public List<OrderVO> orderselect() throws RemoteException {
        List<OrderVO> list = null;
        try {
            list = smc.queryForList("orderVO.select");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
