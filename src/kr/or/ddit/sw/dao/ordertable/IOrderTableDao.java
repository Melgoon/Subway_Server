package kr.or.ddit.sw.dao.ordertable;

import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;

import java.rmi.RemoteException;
import java.util.List;

public interface IOrderTableDao {
    public List<FoodMtrVO> select(int mtr_div);
    public Object insert(CombiVO vo);
    public List<OrderVO> orderselect() throws RemoteException;

}
