package kr.or.ddit.sw.dao.tellsub;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TellSubDaoImpl implements ITellSubDao {
    private static TellSubDaoImpl dao;
    private static SqlMapClient smc;

    private TellSubDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static TellSubDaoImpl getInstance(){
        if(dao==null){
            dao=new TellSubDaoImpl();
        }
        return dao;
    }

    /*1. 텔서브웨이 게시글 생성*/
    @Override
    public Object insertTell(TellSubVO tv) throws RemoteException {
        int cnt= 0;
        try{
            Object obj=smc.insert("tellsub.insert", tv);

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
    public int deleteTell(TellSubVO tv) throws RemoteException {
        int cnt = 0;

        try{
            cnt = smc.update("tellsub.delete", tv);
        }catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }


    @Override
    public int updateTell(TellSubVO tv) throws RemoteException {
       int cnt = 0;

       try{
           cnt = smc.update("tellsub.update", tv);
       } catch (SQLException throwables) {
           cnt = 0;
           throwables.printStackTrace();
       }
       return cnt;
    }
    /*게시글 전체 조회*/
    @Override
    public List<TellSubVO> selectAllTell(String get_tellsub_no) throws RemoteException{
        ArrayList<TellSubVO> TellList = new ArrayList<TellSubVO>();
        try{
            TellList = (ArrayList<TellSubVO>) smc.queryForList("tellsub.select", get_tellsub_no);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return TellList;
    }

    @Override
    public List<TellSubVO> choisselectTell(TellSubVO Tellsub_no) throws RemoteException {
        ArrayList<TellSubVO> TellList = new ArrayList<TellSubVO>();

        try{
            TellList = (ArrayList<TellSubVO>) smc.queryForList("tellsub.choisselect", Tellsub_no);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return TellList;
    }
    /*2. 텔서브웨이 게시글 삭제*//*
    @Override
    public int deleteTell(TellSubVO tv) throws RemoteException {
        int cnt = 0;

        try{
            cnt = smc.update("deleteTellSub", tv);
        }catch (SQLException e){
            cnt = 0;
            e.printStackTrace();
        } finally{

        }
        return cnt;
    }
    *//*3. 텔서브웨이 게시글 수정*//*
    @Override
    public int updateTell(TellSubVO tv) throws RemoteException {
        int cnt = 0;
        try{
            cnt = smc.update("updateTellSub",tv);
        }catch (SQLException e){
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<TellSubVO> selectAllTell(int Tellsub_no) throws RemoteException {
        ArrayList<TellSubVO> TellsubList = new ArrayList<TellSubVO>();

        try{
            TellsubList = (ArrayList<TellSubVO>) smc.queryForList("selectList", Tellsub_no);
        } catch(SQLException e){
            System.out.println("에러!");
        }
        return TellsubList;
    }*/
}
