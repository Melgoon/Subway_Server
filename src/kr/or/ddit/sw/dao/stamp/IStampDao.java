package kr.or.ddit.sw.dao.stamp;

import kr.or.ddit.sw.vo.coupon.CouponHisVO;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;
import kr.or.ddit.sw.vo.coupon.CouponVO;
import kr.or.ddit.sw.vo.foodmtr.MtrPicVO;
import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.stamp.StampHisVO;
import kr.or.ddit.sw.vo.stamp.StampVO;

import java.util.List;

public interface IStampDao {
    public StampHisVO findStampNumbers(String mem_id);

    public List<CouponPicVO> selectCoupon(String mem_id);

    public int insertCoupon(CouponVO vo);

    public int insertCouponHis(CouponHisVO vo);

    public int updateStamp(StampHisVO vo);

    public List<MemberVO> findMemberId();

    public int insertCouponB(CouponVO vo);

    public int insertStamp(StampHisVO vo);



}
