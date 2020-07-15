package kr.or.ddit.sw.service.coupon;

import kr.or.ddit.sw.dao.coupon.CouponDaoImpl;
import kr.or.ddit.sw.dao.coupon.ICouponDao;
import kr.or.ddit.sw.dao.registFoodMtr.IRegistFoodMtrDao;
import kr.or.ddit.sw.dao.registFoodMtr.RegistFoodMtrDaoImpl;
import kr.or.ddit.sw.service.registFoodMtr.IRegistFoodMtrService;
import kr.or.ddit.sw.service.registFoodMtr.RegistFoodMtrServiceImpl;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CouponServiceImpl extends UnicastRemoteObject implements ICouponService {

    private final ICouponDao iCouponDao;
    private static ICouponService service;

    public CouponServiceImpl() throws RemoteException {
        super();
        iCouponDao = CouponDaoImpl.getInstance();
    }

    public static ICouponService getInstance() throws RemoteException {
        if (service == null) {
            service = new CouponServiceImpl();
        }
        return service;
    }

    @Override
    public List<CouponPicVO> selectCoupon(String mem_id) throws RemoteException {
        List<CouponPicVO> list = new ArrayList<>();
        list = iCouponDao.selectCoupon(mem_id);
        return list;
    }
}
