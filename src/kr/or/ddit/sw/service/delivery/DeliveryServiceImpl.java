package kr.or.ddit.sw.service.delivery;

import javafx.fxml.Initializable;
import kr.or.ddit.sw.dao.delivery.DeliveryDaoImpl;
import kr.or.ddit.sw.vo.ordertable.DeliveryVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DeliveryServiceImpl extends UnicastRemoteObject implements IDeliveryService {

    private DeliveryDaoImpl dao;
    private static DeliveryServiceImpl service;

    private DeliveryServiceImpl() throws RemoteException{
        super();
        dao = DeliveryDaoImpl.getInstance();
    }

    public static DeliveryServiceImpl getInstance() throws RemoteException{
        if(service == null){
            service = new DeliveryServiceImpl();
        }
        return service;
    }


    @Override
    public Object insert(DeliveryVO dv) throws RemoteException {
        return dao.insert(dv);
    }

    @Override
    public List<DeliveryVO> deliselect() throws RemoteException {
        return dao.deliselect();
    }

    @Override
    public int updatedel(DeliveryVO dv) throws RemoteException {
        return dao.updatedel(dv);
    }

    @Override
    public DeliveryVO select(int deli_no) throws RemoteException {
        return dao.select(deli_no);
    }

    @Override
    public List<DeliveryVO> selectJijum(String jijum) throws RemoteException {
        return dao.selectJijum(jijum);
    }
}
