package kr.or.ddit.sw.dao.notice;

import kr.or.ddit.sw.vo.notice.NoticeVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.RemoteException;
import java.util.List;

public interface INoticeDao {

    public int insertNotice(NoticeVO nv);

    public List<NoticeVO> selectNoticeAll();

    public int deleteNotice(NoticeVO nv);

    public int updateNotice(NoticeVO nv);



}
