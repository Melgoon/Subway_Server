package kr.or.ddit.sw.dao.login;

import kr.or.ddit.sw.vo.member.MemberVO;

public interface ILoginDao {
    MemberVO login(String id);
}
