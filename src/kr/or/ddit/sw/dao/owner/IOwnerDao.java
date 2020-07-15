package kr.or.ddit.sw.dao.owner;

import kr.or.ddit.sw.vo.owner.OwnerVO;
import kr.or.ddit.sw.vo.owner.TempOwnerVO;

public interface IOwnerDao {
    //오너 회원가입 인터페이스
    public Object insertowner(OwnerVO vo);


    //오너 로그인 인터페이스
    public OwnerVO owerlogin(TempOwnerVO vo);
}
