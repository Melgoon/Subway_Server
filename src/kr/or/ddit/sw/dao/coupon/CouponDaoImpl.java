package kr.or.ddit.sw.dao.coupon;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.dao.managementOwner.IManagementOwnerDao;
import kr.or.ddit.sw.dao.managementOwner.ManagementOwnerDaoImpl;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouponDaoImpl implements ICouponDao {
    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static ICouponDao iCouponDao;

    private CouponDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static ICouponDao getInstance(){
        if(iCouponDao == null){
            iCouponDao = new CouponDaoImpl();
        }
        return iCouponDao;
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
}
