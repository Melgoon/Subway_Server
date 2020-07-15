package kr.or.ddit.sw.dao.alarm;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.notice.NoticeMemChkVO;
import kr.or.ddit.sw.vo.notice.NoticeVO;

import java.sql.SQLException;
import java.util.List;

public class AlarmDaoImpl implements IAlarmDao {

    private SqlMapClient smc;
    private static IAlarmDao instance;

    private AlarmDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    public static IAlarmDao getInstance(){
        if (instance==null){
            instance = new AlarmDaoImpl();
        }
        return instance;
    }

    @Override
    public List<NoticeVO> ReadNoSelect(String cv) {
        List<NoticeVO> list =null;
        try {
            list =smc.queryForList("noticeChk.ReadNoSelect",cv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("떠야한다 "+list.size());
        return list;
    }


    @Override
    public int noticeNumber(String cv) {
        int cnt= 0;
        try {
            cnt = (int) smc.queryForObject("noticeChk.noticeNumber",cv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }
    @Override
    public List<Integer> disSelectNO(String userId) {
        List<Integer> list = null;
        try {
          list = smc.queryForList("noticeChk.disSelectNO",userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteChk(int no) {
        int cnt=0;
        try {
            cnt= smc.delete("noticeChk.deleteChk",no);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int insertChk(NoticeMemChkVO vo) {
        int cnt=0;
        try {
            Object obj = smc.insert("noticeChk.insertChk",vo);
            if (obj==null){
                cnt=1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    @Override
    public String newUserChk(String user_id) {
        String a= null;
        try {
          a = (String) smc.queryForObject("noticeChk.newUserChk",user_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Integer> noticeNo() {
        List<Integer> list= null;
        try {
            list = smc.queryForList("noticeChk.noticeNo");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Integer> noticeChkNo(String user_id) {
        List<Integer> list =null;
        try {
            list = smc.queryForList("noticeChk.noticeChkNo",user_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    @Override
    public int updateNo(NoticeMemChkVO vo) {
        int cnt =0;
        try {
           cnt = smc.update("noticeChk.updateNo",vo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

}
