package kr.or.ddit.sw.dao.reservation;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.ordertable.ReservationVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements IReservationDao {

    private static ReservationDaoImpl dao;
    private static SqlMapClient smc;

    private ReservationDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static ReservationDaoImpl getInstance(){
        if(dao==null){
            dao=new ReservationDaoImpl();
        }
        return dao;
    }

    @Override
    public Object insert(ReservationVO rv) throws RemoteException {
        int cnt= 0;
        try{
            Object obj=smc.insert("reservationVO.insert",rv);

            if(obj==null){
                cnt=1;
            }else{

            }
        }catch (SQLException e){
            cnt=0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<ReservationVO> rserselect() throws RemoteException {
        ArrayList<ReservationVO> ReserList = new ArrayList<ReservationVO>();
        try{
            ReserList = (ArrayList<ReservationVO>) smc.queryForList("reservationVO.rserselect");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ReserList;
    }

    @Override
    public int updateReser(ReservationVO rv) throws RemoteException {
        int cnt = 0;

        try{
            cnt = smc.update("reservationVO.reserupdate",rv);
        } catch (SQLException throwables) {
            cnt = 0;
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public ReservationVO select(int reser_no) throws RemoteException {
        ReservationVO vo = null;
        try {
            vo = (ReservationVO) smc.queryForObject("reservationVO.select",reser_no);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }

    @Override
    public List<ReservationVO> selectJijum(String jijum) throws RemoteException {
        List<ReservationVO> list = null;
        try {
            list = smc.queryForList("reservationVO.jijum",jijum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
