package kr.or.ddit.sw.dao.notice;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.notice.NoticeVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class NoticeDaoImpl implements INoticeDao {

    private SqlMapClient smc;
    private static INoticeDao dao;

    private NoticeDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static INoticeDao getInstance() {
        if (dao == null) {
            dao = new NoticeDaoImpl();
        }
        return dao;
    }

    @Override
    public int insertNotice(NoticeVO nv) {
        int cnt = 0;
        try {
            Object obj = smc.insert("notice.insertNotice", nv);
            if (obj == null) {
                cnt = 1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<NoticeVO> selectNoticeAll() {
        List<NoticeVO> list = null;

        try {
            list = smc.queryForList("notice.selectNoticeAll");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteNotice(NoticeVO nv) {
        int cnt = 0;

        try {
            cnt = smc.delete("notice.deleteNotice", nv);
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int updateNotice(NoticeVO nv) {
       int cnt = 0;
        try {
            cnt = smc.update("notice.updateNotice", nv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }
}



