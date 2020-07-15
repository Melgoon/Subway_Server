package kr.or.ddit.sw.dao.alarm;

import kr.or.ddit.sw.vo.notice.NoticeMemChkVO;
import kr.or.ddit.sw.vo.notice.NoticeVO;

import java.util.List;

public interface IAlarmDao {

    /**
     * 일반게시판 맴체크랑 , 맴버랑 조인해서 현재 맴체크전부 풀력

     */
    //읽어야 할 게시판 번호 추출
    public List<NoticeVO> ReadNoSelect(String cv);
    // 읽어야할 게시판 수
    public int noticeNumber(String cv);

    public int updateNo(NoticeMemChkVO vo);

// 추가 할것들 회원별 읽어야할 게시판 번호 추출
    public List<Integer> disSelectNO(String user_id);

    public int deleteChk(int no);
    public int insertChk(NoticeMemChkVO vo);

    public String newUserChk(String user_id);

    //게시판 번호 뽑아온다.
    public List<Integer> noticeNo();

    public List<Integer> noticeChkNo(String user_id);



}
