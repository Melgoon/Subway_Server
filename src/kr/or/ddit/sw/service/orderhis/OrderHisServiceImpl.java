package kr.or.ddit.sw.service.orderhis;

import kr.or.ddit.sw.dao.orderhis.IOrderHisDao;
import kr.or.ddit.sw.dao.orderhis.OrderHisDaoImpl;
import kr.or.ddit.sw.vo.orderhis.OrderHisVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class OrderHisServiceImpl extends UnicastRemoteObject implements IOrderHisService {
    private IOrderHisDao dao;
    private static IOrderHisService service;

    private OrderHisServiceImpl() throws RemoteException {
        super();
        dao = OrderHisDaoImpl.getInstance();
    }

    public static IOrderHisService getInstance() throws RemoteException {
        if (service == null) {
            service = new OrderHisServiceImpl();
        }
        return service;
    }


    @Override
    public List<OrderVO> selectid(String id) throws RemoteException {
        return dao.selectid(id);
    }
}
