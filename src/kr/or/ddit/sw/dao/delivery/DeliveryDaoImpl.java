package kr.or.ddit.sw.dao.delivery;

import com.ibatis.sqlmap.client.SqlMapClient;
import javafx.fxml.Initializable;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.ordertable.DeliveryVO;

import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeliveryDaoImpl implements IDeliveryDao {

    private static DeliveryDaoImpl dao;
    private static SqlMapClient smc;

    private DeliveryDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static DeliveryDaoImpl getInstance(){
        if(dao==null){
            dao=new DeliveryDaoImpl();
        }
        return dao;
    }

    @Override
    public Object insert(DeliveryVO dv) throws RemoteException {
        int cnt= 0;
        try{
            Object obj=smc.insert("deliveryVO.insert", dv);

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
    public List<DeliveryVO> deliselect() throws RemoteException {
        ArrayList<DeliveryVO> TellList = new ArrayList<DeliveryVO>();
        try{
            TellList = (ArrayList<DeliveryVO>) smc.queryForList("deliveryVO.deliselect");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return TellList;
    }

    @Override
    public int updatedel(DeliveryVO dv) throws RemoteException {
        int cnt = 0;

        try{
            cnt = smc.update("deliveryVO.deliupdate",dv);
        } catch (SQLException throwables) {
            cnt = 0;
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public DeliveryVO select(int deli_no) throws RemoteException {
        DeliveryVO vo = null;
        try {
            vo = (DeliveryVO) smc.queryForObject("deliveryVO.select",deli_no);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }

    @Override
    public List<DeliveryVO> selectJijum(String jijum) throws RemoteException {
        List<DeliveryVO> list = null;
        try {
            list = smc.queryForList("deliveryVO.jijum",jijum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
