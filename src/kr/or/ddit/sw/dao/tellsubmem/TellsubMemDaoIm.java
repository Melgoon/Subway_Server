package kr.or.ddit.sw.dao.tellsubmem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.sw.dao.tellsub.ITellSubDao;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class TellsubMemDaoIm implements ITellsubMemDao {

    private SqlMapClient smc;
    private static ITellsubMemDao instance;

    private TellsubMemDaoIm(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static ITellsubMemDao getInstance(){
        if (instance==null){
            instance= new TellsubMemDaoIm();
        }
        return instance;
    }


    @Override
    public int insertTellsubMem(String user_id) {
        int cnt=0;
        try {
            Object obj =smc.insert("tellsubmem.insertTellsubMem",user_id);
            if (obj ==null){
                cnt = 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<TellSubVO> selectUnionTell(String user_id) {
        List<TellSubVO> list =null;
        try {
            list =smc.queryForList("tellsubmem.selectUnionTell",user_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    //클릭했을때 현재 게시판번호 및 회원아이디
    @Override
    public int updateTellsubMem(TellSubMemVO vo) {
        int cnt=0;
        try {
           cnt = smc.update("tellsubmem.updateTellsubMem",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public TellSubVO selectDetail(int tellSub_no) {

        return null;
    }

    @Override
    public int selectTellSubNO(String user_id) {
        int cnt=0;
        try {
            cnt = (int) smc.queryForObject("tellsubmem.selectTellSubNO",user_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

}
