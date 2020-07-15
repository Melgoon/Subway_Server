package kr.or.ddit.sw.service.reservation;

import kr.or.ddit.sw.dao.reservation.ReservationDaoImpl;
import kr.or.ddit.sw.vo.ordertable.ReservationVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReservationServiceImpl extends UnicastRemoteObject implements IReservationService{

    private ReservationDaoImpl dao;
    private static ReservationServiceImpl service;

    private ReservationServiceImpl() throws RemoteException{
        super();
        dao = ReservationDaoImpl.getInstance();
    }

    public static ReservationServiceImpl getInstance() throws RemoteException{
        if(service == null){
            service = new ReservationServiceImpl();
        }
        return service;
    }

    @Override
    public Object insert(ReservationVO rv) throws RemoteException {
        return dao.insert(rv);
    }

    @Override
    public List<ReservationVO> rserselect() throws RemoteException {
        return dao.rserselect();
    }

    @Override
    public int updateReser(ReservationVO rv) throws RemoteException {
        return dao.updateReser(rv);
    }

    @Override
    public ReservationVO select(int reser_no) throws RemoteException {
        return dao.select(reser_no);
    }

    @Override
    public List<ReservationVO> selectJijum(String jijum) throws RemoteException {
        return dao.selectJijum(jijum);
    }
}
