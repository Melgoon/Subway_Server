package kr.or.ddit.sw.service.sales;

import kr.or.ddit.sw.dao.sales.ISalesDao;
import kr.or.ddit.sw.dao.sales.SalesDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SalesServiceImpl extends UnicastRemoteObject implements ISalesService {
    private ISalesDao dao;
    private static ISalesService instance;

    private SalesServiceImpl() throws RemoteException {
        dao= SalesDaoImpl.getInstance();
    }

    public static ISalesService getInstance() throws RemoteException {
        if (instance==null){
            instance= new SalesServiceImpl();
        }
        return instance;
    }
    @Override
    public int deliveryNo(String jiJum) throws RemoteException {
        return dao.deliveryNo(jiJum);
    }

    @Override
    public int deliveryPr(String jiJum) throws RemoteException {
        return dao.deliveryPr(jiJum);
    }

    @Override
    public int deliveryChatNo(String jiJum, int chart_no) throws RemoteException {
        return dao.deliveryChatNo(jiJum,chart_no);
    }

    @Override
    public String deliveryChatPr(String jiJum, int chart_no) throws RemoteException {
        return dao.deliveryChatPr(jiJum, chart_no);
    }

    @Override
    public int reservationNo(String jiJum) throws RemoteException {
        return dao.reservationNo(jiJum);
    }

    @Override
    public int reservationPr(String jiJum) throws RemoteException {
        return dao.reservationPr(jiJum);
    }

    @Override
    public int reservationChatNo(String jiJum, int chart_no) throws RemoteException {
        return dao.reservationChatNo(jiJum, chart_no);
    }

    @Override
    public String reservationChatPr(String jiJum, int chart_no) throws RemoteException {
        return dao.reservationChatPr(jiJum, chart_no);
    }
}
