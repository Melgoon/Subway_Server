package kr.or.ddit.sw.dao.stamp;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.dao.registFoodMtr.IRegistFoodMtrDao;
import kr.or.ddit.sw.dao.registFoodMtr.RegistFoodMtrDaoImpl;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.coupon.CouponHisVO;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;
import kr.or.ddit.sw.vo.coupon.CouponVO;
import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.stamp.StampHisVO;
import kr.or.ddit.sw.vo.stamp.StampVO;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StampDaoImpl implements IStampDao {

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static IStampDao iStampDao;

    private StampDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static IStampDao getInstance(){
        if(iStampDao == null){
            iStampDao = new StampDaoImpl();
        }
        return iStampDao;
    }

    @Override
    public StampHisVO findStampNumbers(String mem_id) {
        StampHisVO vo = new StampHisVO();
        try {
            vo = (StampHisVO) smc.queryForObject("stamp.select",mem_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return vo;
    }

    @Override
    public List<CouponPicVO> selectCoupon(String mem_id) {
        List<CouponPicVO> list = new ArrayList<>();
        try {
            list = smc.queryForList("coupon.selectCouponAdr",mem_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertCoupon(CouponVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("coupon.insertCouponFromStamp",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;

    }


    @Override
    public int insertCouponHis(CouponHisVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("coupon.insertCouponHisFromStamp",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int updateStamp(StampHisVO vo) {
        int cnt = 0;
        try {
            cnt = smc.update("stamp.updateStamp",vo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;

    }

    @Override
    public List<MemberVO> findMemberId() {
        List<MemberVO> list = new ArrayList<>();
        try {
            list = smc.queryForList("coupon.selectMemberBirth");
            System.out.println(list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertCouponB(CouponVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("coupon.insertCouponFromStampB",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;

    }

    @Override
    public int insertStamp(StampHisVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("stamp.insertStamp",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }
}
