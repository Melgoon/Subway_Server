package kr.or.ddit.sw.dao.honeycombi;

import kr.or.ddit.sw.vo.honeycombi.HoneyCombiVO;

import java.util.List;

public interface IHoneyCombiDao {
    //모든 게시글을 조회하여 리턴
    public List<HoneyCombiVO> selectAllHoney();
    //메뉴로 게시글들을 조회한다.
    public List<HoneyCombiVO> selectHoney(String menu);
    //게시글 삽입 메소드
    public Object insertHoney(HoneyCombiVO honeyCombiVO);
    //제목을 매개변수로 하여 조회하여 리턴하는 메소드
    public HoneyCombiVO selectHoneyBtn(String name);
}
