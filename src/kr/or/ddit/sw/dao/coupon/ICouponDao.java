package kr.or.ddit.sw.dao.coupon;

import kr.or.ddit.sw.vo.coupon.CouponPicVO;

import java.util.List;

public interface ICouponDao {

    public List<CouponPicVO> selectCoupon(String mem_id);
}
