package kr.or.ddit.sw.service.ordertable;

import kr.or.ddit.sw.dao.ordertable.IOrderTableDao;
import kr.or.ddit.sw.dao.ordertable.OrderTableDaoImpl;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class OrderTableServiceImpl extends UnicastRemoteObject implements IOrderTableService{

    private IOrderTableDao dao;
    private static IOrderTableService service;

    private OrderTableServiceImpl() throws RemoteException {
        super();
        dao = OrderTableDaoImpl.getInstance();
    }

    public static IOrderTableService getInstance() throws RemoteException {
        if(service == null){
            service = new OrderTableServiceImpl();
        }
        return service;
    }

    @Override
    public List<FoodMtrVO> select(int mtr_div) {
        return dao.select(mtr_div);
    }

    @Override
    public Object insert(CombiVO vo) throws RemoteException {
        return dao.insert(vo);
    }

    @Override
    public List<OrderVO> orderselect() throws RemoteException {
        return dao.orderselect();
    }
}
