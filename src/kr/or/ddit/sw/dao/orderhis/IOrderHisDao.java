package kr.or.ddit.sw.dao.orderhis;

import kr.or.ddit.sw.vo.ordertable.OrderVO;

import java.util.List;

public interface IOrderHisDao {
    public List<OrderVO> selectid(String id);
}
