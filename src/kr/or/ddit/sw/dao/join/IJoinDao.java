package kr.or.ddit.sw.dao.join;

import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IJoinDao {
    Object insertMember(MemberVO mv);

    Object insertOwner(OwnerVO own);

    // 회원 정보 수정하기 위한 select문
    public int updateMember(MemberVO mv);
}
