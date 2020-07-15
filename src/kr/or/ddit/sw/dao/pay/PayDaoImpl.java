package kr.or.ddit.sw.dao.pay;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.service.pay.IPayService;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.pay.PayVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class PayDaoImpl implements IPayDao {

    private static PayDaoImpl dao;
    private static SqlMapClient smc;

    private PayDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static PayDaoImpl getInstance(){
        if(dao==null){
            dao=new PayDaoImpl();
        }
        return dao;
    }

    @Override
    public Object Deliinsert(PayVO pv) throws RemoteException {
        int cnt= 0;
        try{
            Object obj=smc.insert("pay.delipayinsert",pv);

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
    public Object Reserinsert(PayVO pv) throws RemoteException {
        int cnt= 0;
        try{
            Object obj=smc.insert("pay.reserpayinsert",pv);

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
    public PayVO payvo() {
        PayVO vo = null;
        try {
            vo = (PayVO) smc.queryForObject("pay.lastpay");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }
}
