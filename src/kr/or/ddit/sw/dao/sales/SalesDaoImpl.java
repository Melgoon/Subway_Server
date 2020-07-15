package kr.or.ddit.sw.dao.sales;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.ordertable.DeliveryVO;
import kr.or.ddit.sw.vo.ordertable.ReservationVO;

import java.sql.SQLException;

public class SalesDaoImpl implements ISalesDao{
    SqlMapClient smc;
    private static ISalesDao instance;

    private SalesDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static ISalesDao getInstance(){
        if (instance==null){
            instance= new SalesDaoImpl();
        }
        return instance;
    }

    @Override
    public int deliveryNo(String jiJum) {
        int cnt=0;
        try {
            cnt = (int) smc.queryForObject("chart.deliveryNo",jiJum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int deliveryPr(String jiJum) {
        String test= null;
        int cnt=0;
        try {
            test = (String) smc.queryForObject("chart.deliveryPr",jiJum);
            if (test ==null){
                cnt=0;
            }else if (test !=null){
                cnt = Integer.parseInt(test);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int deliveryChatNo(String jiJum, int chart_no) {
        int cnt=0;
        DeliveryVO vo = new DeliveryVO();
        vo.setDeli_jijum(jiJum);
        vo.setChartNo(chart_no);
        try {
            cnt = (int) smc.queryForObject("chart.deliveryChatNo",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public String deliveryChatPr(String jiJum,int chart_no) {
        String cnt=null;
        DeliveryVO vo = new DeliveryVO();
        vo.setDeli_jijum(jiJum);
        vo.setChartNo(chart_no);
        try {
            cnt= (String) smc.queryForObject("chart.deliveryChatPr",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int reservationNo(String jiJum) {
        int cnt=0;
        try {
            cnt = (int) smc.queryForObject("chart.reservationNo",jiJum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int reservationPr(String jiJum) {
        int cnt=0;
        String test=null;
        try {
            test= (String) smc.queryForObject("chart.reservationPr",jiJum);
            if (test==null){
                cnt =0;
            }else if (test !=null){
                cnt = Integer.parseInt(test);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int reservationChatNo(String jiJum,int chart_no) {
        int cnt=0;
        ReservationVO vo= new ReservationVO();
        vo.setReser_jijum(jiJum);
        vo.setChart_no(chart_no);
        try {
            cnt = (int) smc.queryForObject("chart.reservationChatNo",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public String reservationChatPr(String jiJum,int chart_no) {
        String cnt= null;
        ReservationVO vo = new ReservationVO();
        vo.setReser_jijum(jiJum);
        vo.setChart_no(chart_no);
        try {
            cnt = (String) smc.queryForObject("chart.reservationChatPr",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }
}
